package com.gobi.animeopedquiz2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.AnimeOpAndEdData;
import model.AnimeOpandEdDataSource;
import model.BaseActivity;
import model.Utilities;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class MusicPlayActivity extends BaseActivity implements
		OnCompletionListener, SeekBar.OnSeekBarChangeListener {

	private ImageButton musicPlayButton;
	private MediaPlayer mediaPlayer;
	private Utilities utilities;
	private SeekBar musicSeekBar;
	AnimeOpandEdDataSource dataSource;
	AnimeOpAndEdData currentAnime;
	Button question1_Button;
	Button question2_Button;
	Button question3_Button;
	Button question4_Button;

	private Handler mHandler = new Handler();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_play);
		Intent intent = getIntent();
		String animeSongName = intent
				.getStringExtra("com.example.animeopedquiz2.MESSAGE");
		Log.i("intent", "animesongName: " + animeSongName);
		dataSource = new AnimeOpandEdDataSource(this);
		dataSource.open();
		String[] songName = { animeSongName };

		currentAnime = dataSource.getAnimeBYSongName(songName);
		Log.i("ANIME CHOOSEN", "NAME: " + currentAnime.getName() + "song: "
				+ currentAnime.getSong() + "MUSIC: " + currentAnime.getMusic());

		musicPlayButton = (ImageButton) findViewById(R.id.musicPlayButton);
		musicSeekBar = (SeekBar) findViewById(R.id.musicSeekBar);
		question1_Button = (Button) findViewById(R.id.question1_Button);
		question2_Button = (Button) findViewById(R.id.question2_Button);
		question3_Button = (Button) findViewById(R.id.question3_Button);
		question4_Button = (Button) findViewById(R.id.question4_Button);

		String[] animeQuestions = new String[4];
		animeQuestions[0] = currentAnime.getQuestion1().toString();
		animeQuestions[1] = currentAnime.getQuestion2().toString();
		animeQuestions[2] = currentAnime.getQuestion3().toString();
		animeQuestions[3] = currentAnime.getQuestion4().toString();
		// int idx = new Random().nextInt(animeQuestions.length);

		List<String> ranQs = Arrays.asList(animeQuestions);

		Collections.shuffle(ranQs);

		question1_Button.setText(animeQuestions[0].toString());
		question2_Button.setText(animeQuestions[1].toString());
		question3_Button.setText(animeQuestions[2].toString());
		question4_Button.setText(animeQuestions[3].toString());

		Log.i("Questionsz",
				" q1: " + animeQuestions[0].toString() + " q2: "
						+ animeQuestions[1].toString() + " q3: "
						+ animeQuestions[2].toString() + " q4: "
						+ animeQuestions[3].toString());

		// Creating a Mediaplayer
		mediaPlayer = new MediaPlayer();
		utilities = new Utilities();
		playSong(currentAnime.getMusic());
		musicSeekBar.setOnSeekBarChangeListener(this);

		musicPlayButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// check for already playing
				if (mediaPlayer.isPlaying()) {

					if (mediaPlayer != null) {
						mediaPlayer.pause();
						// Changing button image to play button
						musicPlayButton
								.setImageResource(R.drawable.music_playbutton);
					}
				} else {
					// Resume song
					if (mediaPlayer != null) {
						mediaPlayer.start();
						// Changing button image to pause button
						musicPlayButton
								.setImageResource(R.drawable.music_pausebutton);
					}
				}
			}
		});

	}

	public void musicPlayClick(View view) {
		// int levelInt = Integer.parseInt(levelNum);
		// /insertLevel(levelInt);

		Intent intent = getIntent();
		String message = intent.getStringExtra(MusicSelection.EXTRA_MESSAGE);
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
				.show();

	}

	public void playSong(String path) {
		// Play song
		try {
			// / MediaPlayer.create(this, R.raw.beckophitintheusa);
			// AssetFileDescriptor afd = getAssets().openFd("usa.mp3");
			// String songname = path;

			int res = getResources().getIdentifier(path, "raw",
					this.getPackageName());

			String fileName = "android.resource://" + getPackageName() + "/"
					+ res;

			Log.i("playsong", "path: " + res);

			if (res != 0) {
				Log.d("playsong", "song found.");
				mediaPlayer.reset();
				// / mediaPlayer.setDataSource(afd.getFileDescriptor(),
				// afd.getStartOffset(), afd.getLength());
				mediaPlayer.setDataSource(this, Uri.parse(fileName));
				mediaPlayer.prepare();
				mediaPlayer.start();
				// Changing Button Image to pause image
				musicPlayButton.setImageResource(R.drawable.music_pausebutton);

				// Set Progress bar values
				musicSeekBar.setProgress(0);
				musicSeekBar.setMax(92);
				// Updating seek Bar
				updateSeekBar();
			} else {
				Log.i("playsong", "song not found!!");

			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateSeekBar() {
		mHandler.postDelayed(mUpdateTimeTask, 100);
	}

	private Runnable mUpdateTimeTask = new Runnable() {
		public void run() {
			long totalDuration = mediaPlayer.getDuration();
			long currentDuration = mediaPlayer.getCurrentPosition();

			// Displaying Total Duration time
			// songTotalDurationLabel.setText(""+utils.milliSecondsToTimer(totalDuration));
			// Displaying time completed playing
			// songCurrentDurationLabel.setText(""+utils.milliSecondsToTimer(currentDuration));

			// Updating progress bar
			int progress = (int) (utilities.getProgressPercentage(
					currentDuration, totalDuration));
			// Log.d("Progress", ""+progress);
			musicSeekBar.setProgress(progress);

			// Running this thread after 100 milliseconds
			mHandler.postDelayed(this, 100);
		}
	};

	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		musicPlayButton.setImageResource(R.drawable.music_playbutton);
		// playSong("whatever");
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		System.out.println("yout touching seekbar");
		mHandler.removeCallbacks(mUpdateTimeTask);
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		mHandler.removeCallbacks(mUpdateTimeTask);
		int totalDuration = mediaPlayer.getDuration();
		int currentPosition = utilities.progressToTimer(seekBar.getProgress(),
				totalDuration);

		// forward or backward to certain seconds
		System.out.println(currentPosition);
		mediaPlayer.seekTo(currentPosition);

		// update timer progress again
		updateSeekBar();

	}

	public void questionButtonTapped(View v) {
		
		Log.i("qbtn", "complete: " + currentAnime.getComplete().toString() );

		Button qbutton = (Button) v;
		String qbtnText = qbutton.getText().toString();
		Log.i("qbtn", "btn: " + qbtnText + " answer:  "
				+ currentAnime.getAnswer().toString());

		if (qbtnText.equals(currentAnime.getAnswer().toString())) {
			Toast.makeText(this, "RIGHT!", Toast.LENGTH_SHORT).show();
			
			dataSource.updateAnime(currentAnime, "yes");

		} else {
			Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();

		}

	}

	@Override
	public void onBackPressed() {
		System.out.println("HELP!!!!!!");
		this.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
				KeyEvent.KEYCODE_BACK));

		finish();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mHandler.removeCallbacks(mUpdateTimeTask);
		mediaPlayer.release();
	}

}
