package com.gobi.animeopedquiz2;

import model.AnimeOpandEdDataSource;
import model.BaseActivity;
import model.DatabaseHandler;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingsActivity extends BaseActivity {
	
	Button reset_btn;

	MediaPlayer mp;
	AnimeOpandEdDataSource dataSource;
	DatabaseHandler db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	
        mp = MediaPlayer.create(this, R.raw.sound_click);
        reset_btn = (Button) findViewById(R.id.reset_btn);
        reset_btn.setTextColor(Color.WHITE);
		reset_btn.setTextSize(25);
    	reset_btn.setTypeface(null, Typeface.BOLD);
		
    	dataSource = new AnimeOpandEdDataSource(this);
		dataSource.open();
		db = new DatabaseHandler(this);
		
		

	}

	public void handleButton(View v) {
      
        if (v == reset_btn) {
            mp.start();
          db.dropTableAnimeOPandEd();
    		Toast.makeText(this, "Quiz reset!", Toast.LENGTH_SHORT).show();

			
			
		}
		//String name = getResources().getResourceEntryName(v.getId());

	
		//Intent intent = new Intent(this, MusicSelection.class);

	//	intent.putExtra("levelId", name);
	//	startActivity(intent);

	}

	@Override
	protected void onResume() {
		super.onResume();
		dataSource.open();
		 Log.i("onResume", "onResume!!");


   
	 
	}

	@Override
	protected void onPause() {
		super.onPause();
	//	dataSource.close();
	}
}
