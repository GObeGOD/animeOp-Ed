package com.gobi.animeopedquiz2;

import model.BaseActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends BaseActivity implements OnClickListener {

	private Button playButton;
	private Button settings_btn;
	AdView adView;
	 AdRequest adRequest;

	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);


		setContentView(R.layout.activity_main);
		
         mp = MediaPlayer.create(this, R.raw.sound_click);
         settings_btn = (Button) findViewById(R.id.settings_btn);
         settings_btn.setOnClickListener(this);
         settings_btn.setTextColor(Color.WHITE);
         settings_btn.setTextSize(25);
         settings_btn.setTypeface(null, Typeface.NORMAL);

		playButton = (Button) findViewById(R.id.playbutton);
		playButton.setOnClickListener(this);
		playButton.setTextColor(Color.WHITE);
		playButton.setTextSize(40);
		playButton.setTypeface(null, Typeface.BOLD);

		 // Look up the AdView as a resource and load a request.
	     adView = (AdView) this.findViewById(R.id.adView);
	    AdRequest adRequest = new AdRequest.Builder().build();
	  //  07-28 12:40:49.345: I/Ads(23418): Use AdRequest.Builder.addTestDevice("E6D9B7DA0AC372766C2C87BDAA680A3B") to get test ads on this device.

	     
	     // Create the interstitial.
	   //  interstitial = new InterstitialAd(this);
	    // interstitial.setAdUnitId("ca-app-pub-2035686375672240/2220282012");

	     
	     adRequest = new AdRequest.Builder()
        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        .addTestDevice("E6D9B7DA0AC372766C2C87BDAA680A3B")
        .build();
	    
	   
	  //  interstitial.loadAd(adRequest);
	    
	   adView.loadAd(adRequest);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v == playButton) {
            mp.start();

			
			Intent intent = new Intent(this, LevelActivity.class);
			// EditText editText = (EditText) findViewById(R.id.edit_message);
			// String message = editText.getText().toString();
			// intent.putExtra(EXTRA_MESSAGE, message);
			startActivity(intent);

		}
		
		if (v == settings_btn) {
            mp.start();

            Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
		
		}
	}
	

	
	
	
	
	  @Override
	  public void onResume() {
	    super.onResume();
	    if (adView != null) {
	      adView.resume();
	    }
	  }

	  @Override
	  public void onPause() {
	    if (adView != null) {
	      adView.pause();

	    }
	    super.onPause();
	  }

	  /** Called before the activity is destroyed. */
	  @Override
	  public void onDestroy() {
	    // Destroy the AdView.
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }

}
