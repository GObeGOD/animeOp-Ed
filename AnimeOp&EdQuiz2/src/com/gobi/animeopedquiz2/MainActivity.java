package com.gobi.animeopedquiz2;

import model.BaseActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity implements OnClickListener {

	private Button playButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		playButton = (Button) findViewById(R.id.playbutton);
		playButton.setOnClickListener(this);

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

			
			Intent intent = new Intent(this, LevelActivity.class);
			// EditText editText = (EditText) findViewById(R.id.edit_message);
			// String message = editText.getText().toString();
			// intent.putExtra(EXTRA_MESSAGE, message);
			startActivity(intent);

		}
	}

}
