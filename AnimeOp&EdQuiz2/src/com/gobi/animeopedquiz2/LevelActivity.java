package com.gobi.animeopedquiz2;

import java.util.List;

import model.AnimeOpAndEdData;
import model.AnimeOpandEdDataSource;
import model.BaseActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class LevelActivity extends BaseActivity {
	
	Button btnLevel1;
	Button btnLevel2;
	Button btnLevel3;
	Button btnLevel4;
	Button btnLevel5;
	ImageView rankView1;
	ImageView rankView2;
	ImageView rankView3;
	ImageView rankView4;
	ImageView rankView5;
	
	ProgressBar progressBar1;
	ProgressBar progressBar2;
	ProgressBar progressBar3;
	ProgressBar progressBar4;
	ProgressBar progressBar5;

	int progressMax;

	MediaPlayer mp;
	AnimeOpandEdDataSource dataSource;
	List<AnimeOpAndEdData> animeOPandEd;
	int totalLevel_1_Attempts;
	int totalLevel_2_Attempts;
	int totalLevel_3_Attempts;
	int totalLevel_4_Attempts;
	int totalLevel_5_Attempts;
	
	int totalLevel_1_complete;
	int totalLevel_2_complete;
	int totalLevel_3_complete;
	int totalLevel_4_complete;
	int totalLevel_5_complete;
	int  returnlevelAttempts;

	String userGradeLevel1;
	String userGradeLevel2;
	String userGradeLevel3;
	String userGradeLevel4;
	String userGradeLevel5;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levels);
		btnLevel1 = (Button) findViewById(R.id.level_1);
		btnLevel2 = (Button) findViewById(R.id.level_2);
		btnLevel3 = (Button) findViewById(R.id.level_3);
		btnLevel4 = (Button) findViewById(R.id.level_4);
	    btnLevel5 = (Button) findViewById(R.id.level_5);
	    
	    rankView1 = (ImageView) findViewById(R.id.rankView1);
	    rankView2 = (ImageView) findViewById(R.id.rankView2);
	    rankView3 = (ImageView) findViewById(R.id.rankView3);
	    rankView4 = (ImageView) findViewById(R.id.rankView4);
	    rankView5 = (ImageView) findViewById(R.id.rankView5);

	    
		 progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
		 progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
		 progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
		 progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
		 progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);


		 progressMax = 27;
		 progressBar1.setMax(progressMax);
		 progressBar2.setMax(progressMax);
		 progressBar3.setMax(progressMax);
		 progressBar4.setMax(progressMax);
		 progressBar5.setMax(progressMax);




	    
		
    	btnLevel1.setText("Level 1");
    	btnLevel2.setText("Level 2");
		btnLevel3.setText("Level 3");
		btnLevel4.setText("Level 4");
		btnLevel5.setText("Level 5");
		
		btnLevel1.setTextColor(Color.WHITE);
    	btnLevel2.setTextColor(Color.WHITE);
		btnLevel3.setTextColor(Color.WHITE);
		btnLevel4.setTextColor(Color.WHITE);
		btnLevel5.setTextColor(Color.WHITE);
		
		btnLevel1.setTextSize(40);
    	btnLevel2.setTextSize(40);
		btnLevel3.setTextSize(40);
		btnLevel4.setTextSize(40);
		btnLevel5.setTextSize(40);
		
		
		btnLevel1.setTypeface(null, Typeface.BOLD);
    	btnLevel2.setTypeface(null, Typeface.BOLD);
		btnLevel3.setTypeface(null, Typeface.BOLD);
		btnLevel4.setTypeface(null, Typeface.BOLD);
		btnLevel5.setTypeface(null, Typeface.BOLD);
        mp = MediaPlayer.create(this, R.raw.sound_click);
        
        dataSource = new AnimeOpandEdDataSource(this);
		dataSource.open();
		
		//ONly Levels that are complete and are able to change rank AND TO BE CHANGED
		changerankIcon(1);
		changerankIcon(2);
		changerankIcon(3);

		Log.i("OKAY","totalLevel_1_complete!!!:"+ totalLevel_1_complete);
		Log.i("OKAY","totalLevel_2_complete!!!:"+ totalLevel_2_complete);
		Log.i("OKAY","totalLevel_3_complete!!!:"+ totalLevel_3_complete);
		Log.i("OKAY","totalLevel_4_complete!!!:"+ totalLevel_4_complete);
		Log.i("OKAY","totalLevel_5_complete!!!:"+ totalLevel_5_complete);


		
		progressBar1.setProgress(totalLevel_1_complete);
		progressBar2.setProgress(totalLevel_2_complete);
		progressBar3.setProgress(totalLevel_3_complete);
		progressBar4.setProgress(totalLevel_4_complete);
		progressBar5.setProgress(totalLevel_5_complete);
		

		

	}

	public void handleButton(View v) {
        mp.start();

		String name = getResources().getResourceEntryName(v.getId());

	
		Intent intent = new Intent(this, MusicSelection.class);

		intent.putExtra("levelId", name);
		startActivity(intent);

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		dataSource.open();
		Log.i("LLLLLL ", "onResume");

		//ONly Levels that are complete and are able to change rank AND TO BE CHANGED
		changerankIcon(1);
		changerankIcon(2);
		changerankIcon(3);
		
		Log.i("OKAY","totalLevel_1_complete!!!:"+ totalLevel_1_complete);
		Log.i("OKAY","totalLevel_2_complete!!!:"+ totalLevel_2_complete);
		Log.i("OKAY","totalLevel_3_complete!!!:"+ totalLevel_3_complete);
		Log.i("OKAY","totalLevel_4_complete!!!:"+ totalLevel_4_complete);
		Log.i("OKAY","totalLevel_5_complete!!!:"+ totalLevel_5_complete);
		
		progressBar1.setProgress(totalLevel_1_complete);
		progressBar2.setProgress(totalLevel_2_complete);
		progressBar3.setProgress(totalLevel_3_complete);
		progressBar4.setProgress(totalLevel_4_complete);
		progressBar5.setProgress(totalLevel_5_complete);


		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		dataSource.close();
	}
	
	
	
	
	
	
	public  int returnlevelAttempts(int level){
		String[] bylevel = { Integer.toString(level) };
		 totalLevel_1_Attempts = 0;
		 totalLevel_2_Attempts = 0;
		 totalLevel_3_Attempts = 0;
		 totalLevel_4_Attempts = 0;
		 totalLevel_5_Attempts = 0;
		 
	
		 
	      returnlevelAttempts = 0 ;

		 
			Log.i("LLLLLL ", "returnlevelAttempts LEVEL : " + level);

			if (level == 1) 
			
			{
				totalLevel_1_complete = 0;
				animeOPandEd = dataSource.listByLevel(bylevel);
				
				if (animeOPandEd != null) {
					
					for (int i = 0; i < animeOPandEd.size(); i++)
					{
						totalLevel_1_Attempts += animeOPandEd.get(i).getAttempts();
				 
						if (animeOPandEd.get(i).getComplete().equals("yes")) {
							totalLevel_1_complete += 1; 
						}
				
					}			
				}
				
			
			Log.i("LEVELACTIVITY","LEVEL 1 ATTEMPTS:"+ totalLevel_1_Attempts + "complete:" + totalLevel_1_complete);
			Log.i("OKAY","totalLevel_1_complete!!!:"+ totalLevel_1_complete);
			returnlevelAttempts = totalLevel_1_Attempts;
		
		
			 
			}
			
			
			
			if (level == 2) 
				
			{
					totalLevel_2_complete = 0;
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++){
					totalLevel_2_Attempts += animeOPandEd.get(i).getAttempts();
					 if (animeOPandEd.get(i).getComplete().equals("yes")) {
						 totalLevel_2_complete += 1; 
					 }

				}
				}
			Log.i("LEVELACTIVITY","LEVEL 2 ATTEMPTS:"+ totalLevel_2_Attempts);
			returnlevelAttempts = totalLevel_2_Attempts;
			Log.i("OKAY","totalLevel_1_complete!!!:"+ totalLevel_2_complete);
			}
			
			
			
			if (level == 3)
				
			{
				totalLevel_3_complete = 0;
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++) {
					totalLevel_3_Attempts += animeOPandEd.get(i).getAttempts();
					
					 if (animeOPandEd.get(i).getComplete().equals("yes")) {
						 totalLevel_3_complete += 1; 
					 }
				}
				}
				Log.i("LEVELACTIVITY", "LEVEL 3 ATTEMPTS:"
						+ totalLevel_3_Attempts);
				returnlevelAttempts = totalLevel_3_Attempts;
			}
	
			
			
			
			if (level == 4)
				
			{
				totalLevel_4_complete = 0;
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++) {
					totalLevel_4_Attempts += animeOPandEd.get(i).getAttempts();
					
					 if (animeOPandEd.get(i).getComplete().equals("yes")) {
						 totalLevel_4_complete += 1; 
					 }
				}

				}
				Log.i("LEVELACTIVITY", "LEVEL 4 ATTEMPTS:" + totalLevel_3_Attempts);
				returnlevelAttempts = totalLevel_4_Attempts;
				
			}
			
			
			
			if (level == 5)
				
			{
				totalLevel_5_complete = 0;
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++) {
					totalLevel_5_Attempts += animeOPandEd.get(i).getAttempts();
					
					 if (animeOPandEd.get(i).getComplete().equals("yes")) {
						 totalLevel_5_complete += 1; 
					 }

				}
				}

				Log.i("LEVELACTIVITY", "LEVEL 4 ATTEMPTS:" + totalLevel_4_Attempts);
				returnlevelAttempts = totalLevel_5_Attempts;
			}
	
	
		

			
		
			Log.i("LEVELACTIVITY","returnlevelAttempts!!!:"+ returnlevelAttempts);

		return returnlevelAttempts;

	}
	
	
	
	
	
	
	public void changerankIcon(int userLevel ){

		
		
		if (userLevel == 1) {
			totalLevel_1_Attempts = returnlevelAttempts(1);

			userGradeLevel1 = dataSource.userGrade(totalLevel_1_Attempts);
			Log.i("changerankIcon", "userGradeLevel1 =" + userLevel +" attemps =" + totalLevel_1_Attempts);
			
			  if (userGradeLevel1 == "S"){
					Log.i("changerankIcon", "rank S");

				  rankView1.setImageDrawable(null);
				  rankView1.setImageResource(R.drawable.rank_s);
			  }
				else if (userGradeLevel1 == "A"){
					  rankView1.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView1.setImageResource(R.drawable.rank_a);
				}
				else if (userGradeLevel1 == "B")
				{
					  rankView1.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					  rankView1.setImageResource(R.drawable.rank_b);
				}
				else if (userGradeLevel1 == "C")
				{
					  rankView1.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView1.setImageResource(R.drawable.rank_c);
				}
				else if (userGradeLevel1 == "D"){
					  rankView1.setImageDrawable(null);
					
					rankView1.setImageResource(R.drawable.rank_d);
				}
				else if (userGradeLevel1 == "F"){
					  rankView1.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView1.setImageResource(R.drawable.rank_f);
				}
				
		}
	
		
		
		if (userLevel == 2) {
			totalLevel_2_Attempts = returnlevelAttempts(2);

			userGradeLevel2 = dataSource.userGrade(totalLevel_2_Attempts);
			Log.i("changerankIcon", "userGradeLevel2 =" + userLevel +" attemps =" + totalLevel_2_Attempts);
			
			  if (userGradeLevel2 == "S"){
					Log.i("changerankIcon", "rank S");

				  rankView2.setImageDrawable(null);
				  rankView2.setImageResource(R.drawable.rank_s);
			  }
				else if (userGradeLevel2 == "A"){
					  rankView2.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView2.setImageResource(R.drawable.rank_a);
				}
				else if (userGradeLevel2 == "B")
				{
					  rankView2.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					  rankView2.setImageResource(R.drawable.rank_b);
				}
				else if (userGradeLevel2 == "C")
				{
					  rankView2.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView2.setImageResource(R.drawable.rank_c);
				}
				else if (userGradeLevel2 == "D"){
					  rankView2.setImageDrawable(null);
					
					rankView2.setImageResource(R.drawable.rank_d);
				}
				else if (userGradeLevel2 == "F"){
					  rankView2.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView2.setImageResource(R.drawable.rank_f);
				}
				
		}

		 
		if (userLevel == 3) {
			totalLevel_3_Attempts = returnlevelAttempts(3);

			userGradeLevel3 = dataSource.userGrade(totalLevel_3_Attempts);
			Log.i("changerankIcon", "userGradeLevel3 =" + userLevel +" attemps =" + totalLevel_3_Attempts);
			
			  if (userGradeLevel3 == "S"){
					Log.i("changerankIcon", "rank S");

				  rankView3.setImageDrawable(null);
				  rankView3.setImageResource(R.drawable.rank_s);
			  }
				else if (userGradeLevel3 == "A"){
					  rankView3.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView3.setImageResource(R.drawable.rank_a);
				}
				else if (userGradeLevel3 == "B")
				{
					  rankView3.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					  rankView3.setImageResource(R.drawable.rank_b);
				}
				else if (userGradeLevel3 == "C")
				{
					  rankView3.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView3.setImageResource(R.drawable.rank_c);
				}
				else if (userGradeLevel3 == "D"){
					  rankView3.setImageDrawable(null);
					
					rankView3.setImageResource(R.drawable.rank_d);
				}
				else if (userGradeLevel3 == "F"){
					  rankView3.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView3.setImageResource(R.drawable.rank_f);
				}
				
		}

		
		
		
		
		if (userLevel == 4) {
			totalLevel_4_Attempts = returnlevelAttempts(4);

			userGradeLevel4 = dataSource.userGrade(totalLevel_4_Attempts);
			Log.i("changerankIcon", "userGradeLevel4 =" + userLevel +" attemps =" + totalLevel_4_Attempts);
			
			  if (userGradeLevel4 == "S"){
					Log.i("changerankIcon", "rank S");

				  rankView4.setImageDrawable(null);
				  rankView4.setImageResource(R.drawable.rank_s);
			  }
				else if (userGradeLevel4 == "A"){
					  rankView4.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView4.setImageResource(R.drawable.rank_a);
				}
				else if (userGradeLevel4 == "B")
				{
					  rankView4.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					  rankView4.setImageResource(R.drawable.rank_b);
				}
				else if (userGradeLevel4 == "C")
				{
					  rankView4.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView4.setImageResource(R.drawable.rank_c);
				}
				else if (userGradeLevel4 == "D"){
					  rankView4.setImageDrawable(null);
					
					rankView4.setImageResource(R.drawable.rank_d);
				}
				else if (userGradeLevel4 == "F"){
					  rankView4.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView4.setImageResource(R.drawable.rank_f);
				}
				
		}
		
		
		
		if (userLevel == 5) {
			totalLevel_5_Attempts = returnlevelAttempts(5);

			userGradeLevel5 = dataSource.userGrade(totalLevel_5_Attempts);
			Log.i("changerankIcon", "userGradeLevel5 =" + userLevel +" attemps =" + totalLevel_5_Attempts);
			
			  if (userGradeLevel5 == "S"){
					Log.i("changerankIcon", "rank S");

				  rankView5.setImageDrawable(null);
				  rankView5.setImageResource(R.drawable.rank_s);
			  }
				else if (userGradeLevel5 == "A"){
					  rankView5.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView5.setImageResource(R.drawable.rank_a);
				}
				else if (userGradeLevel5 == "B")
				{
					  rankView5.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					  rankView5.setImageResource(R.drawable.rank_b);
				}
				else if (userGradeLevel5 == "C")
				{
					  rankView5.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView5.setImageResource(R.drawable.rank_c);
				}
				else if (userGradeLevel5 == "D"){
					  rankView5.setImageDrawable(null);
					
					rankView5.setImageResource(R.drawable.rank_d);
				}
				else if (userGradeLevel5 == "F"){
					  rankView5.setImageDrawable(null);
					  Log.i("changerankIcon", "rank S");
					rankView5.setImageResource(R.drawable.rank_f);
				}
				
		}

		
		
		

	}
	

}
