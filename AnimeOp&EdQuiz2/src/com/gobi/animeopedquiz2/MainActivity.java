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

public class MainActivity extends BaseActivity implements OnClickListener {

	private Button playButton;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);


		setContentView(R.layout.activity_main);
		
         mp = MediaPlayer.create(this, R.raw.sound_click);

		playButton = (Button) findViewById(R.id.playbutton);
		playButton.setOnClickListener(this);
		playButton.setTextColor(Color.WHITE);
		playButton.setTextSize(40);
		playButton.setTypeface(null, Typeface.BOLD);




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
	}

}
