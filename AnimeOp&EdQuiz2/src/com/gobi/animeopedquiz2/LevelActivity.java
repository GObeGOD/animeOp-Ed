package com.gobi.animeopedquiz2;

import model.BaseActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends BaseActivity {
	
	Button btnLevel1;
	Button btnLevel2;
	Button btnLevel3;
	Button btnLevel4;
	Button btnLevel5;
	MediaPlayer mp;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levels);
		btnLevel1 = (Button) findViewById(R.id.level_1);
		btnLevel2 = (Button) findViewById(R.id.level_2);
		btnLevel3 = (Button) findViewById(R.id.level_3);
		btnLevel4 = (Button) findViewById(R.id.level_4);
	    btnLevel5 = (Button) findViewById(R.id.level_5);
		
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

		
		
		
		
		

		

	}

	public void handleButton(View v) {
        mp.start();

		String name = getResources().getResourceEntryName(v.getId());

	
		Intent intent = new Intent(this, MusicSelection.class);

		intent.putExtra("levelId", name);
		startActivity(intent);

	}

}
