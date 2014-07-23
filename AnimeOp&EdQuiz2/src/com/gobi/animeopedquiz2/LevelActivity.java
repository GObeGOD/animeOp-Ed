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

	MediaPlayer mp;
	AnimeOpandEdDataSource dataSource;
	List<AnimeOpAndEdData> animeOPandEd;
	int totalLevel_1_Attempts;
	int totalLevel_2_Attempts;
	int totalLevel_3_Attempts;
	int totalLevel_4_Attempts;
	int totalLevel_5_Attempts;
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
		
		//String[] bylevel = { Integer.toString(1) };
		//animeOPandEd = dataSource.listByLevel(bylevel);
	//	 totalLevelAttempts = 0;
		
		

		totalLevel_1_Attempts = returnlevelAttempts(1);
		totalLevel_2_Attempts = returnlevelAttempts(2);
		
		changerankIcon(1);

		rankView1.setBackgroundResource(R.drawable.rank_a);

		
		
		

		

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
		
		totalLevel_1_Attempts = returnlevelAttempts(1);
		totalLevel_2_Attempts = returnlevelAttempts(2);
		
		
		changerankIcon(1);
		

		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		dataSource.close();
	}
	
	
	
	
	
	
	public  int returnlevelAttempts(int level){
		String[] bylevel = { Integer.toString(level) };
		int  returnlevelAttempts = 0;
		 totalLevel_1_Attempts = 0;
		 totalLevel_2_Attempts = 0;
		 totalLevel_3_Attempts = 0;
		 totalLevel_4_Attempts = 0;
		 totalLevel_5_Attempts = 0;
		 
			Log.i("LLLLLL ", "returnlevelAttempts LEVEL : " + level);


		
			
				
			if (level == 1) 
			
			{
			
				Log.i("LLLLLL ", "AGAIN returnlevelAttempts LEVEL : " + level);
				animeOPandEd = dataSource.listByLevel(bylevel);
				
				if (animeOPandEd != null) {
					
					for (int i = 0; i < animeOPandEd.size(); i++)
					{
				 totalLevel_1_Attempts += animeOPandEd.get(i).getAttempts();
				//	Log.i("LLLLLL ", "index of " +  animeOPandEd.get(i).getAnswer());
					}			
				}
				
			
			Log.i("LEVELACTIVITY","LEVEL 1 ATTEMPTS:"+ totalLevel_1_Attempts);
			returnlevelAttempts = totalLevel_1_Attempts;
			 
			}
			
			
			
			if (level == 2) 
				
			{
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++){
					totalLevel_2_Attempts += animeOPandEd.get(i).getAttempts();
				//	totalLevel_2_Attempts += animeOPandEd.get(i).getAttempts();
				//	Log.i("LLLLLL ", "index of " +  animeOPandEd.get(i).getAnswer());

				}
				}
			Log.i("LEVELACTIVITY","LEVEL 2 ATTEMPTS:"+ totalLevel_2_Attempts);
			returnlevelAttempts = totalLevel_2_Attempts;
			}
			
			
			
			if (level == 3)

			{
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++) {
					totalLevel_3_Attempts += animeOPandEd.get(i).getAttempts();

				}
				}
				Log.i("LEVELACTIVITY", "LEVEL 3 ATTEMPTS:"
						+ totalLevel_3_Attempts);
				returnlevelAttempts = totalLevel_3_Attempts;
			}
	
			
			
			
			if (level == 4)

			{
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++) {
					totalLevel_4_Attempts += animeOPandEd.get(i).getAttempts();
				
				}

				}
				Log.i("LEVELACTIVITY", "LEVEL 4 ATTEMPTS:" + totalLevel_3_Attempts);
				returnlevelAttempts = totalLevel_4_Attempts;
			}
			
			
			
			if (level == 5)

			{
				animeOPandEd = dataSource.listByLevel(bylevel);
				if (animeOPandEd != null) {
				for (int i = 0; i < animeOPandEd.size(); i++) {
					totalLevel_5_Attempts += animeOPandEd.get(i).getAttempts();
				

				}
				}

				Log.i("LEVELACTIVITY", "LEVEL 4 ATTEMPTS:" + totalLevel_4_Attempts);
				returnlevelAttempts = totalLevel_5_Attempts;
			}
	
	
		

			
		
		
		return returnlevelAttempts;
		
	}
	
	public void changerankIcon(int userGradeLevel ){
		 userGradeLevel1 = null;
		 userGradeLevel2 = null;
		 userGradeLevel3 = null;
		 userGradeLevel4 = null;
		 userGradeLevel5 = null;
			rankView1.setImageResource(R.drawable.rank_a);

		 
		if (userGradeLevel == 1) {
			userGradeLevel1 = dataSource.userGrade(totalLevel_1_Attempts);
			Log.i("changerankIcon", "time to change LEVEL 1 ICON");
			  if (userGradeLevel1 == "S")
				  rankView1.setImageResource(R.drawable.rank_s);
				else if (userGradeLevel1 == "A")
					rankView1.setImageResource(R.drawable.rank_a);
				else if (userGradeLevel1 == "B")
					rankView1.setImageResource(R.drawable.rank_d);
				else if (userGradeLevel1 == "C")
					rankView1.setImageResource(R.drawable.rank_c);
				else if (userGradeLevel1 == "D")
					rankView1.setImageResource(R.drawable.rank_d);
				else if (userGradeLevel1 == "F")
					rankView1.setImageResource(R.drawable.rank_f);
				
		}

	}
	

}
