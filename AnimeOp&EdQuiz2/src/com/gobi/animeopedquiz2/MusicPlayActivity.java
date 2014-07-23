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
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MusicPlayActivity extends BaseActivity implements
		OnCompletionListener, SeekBar.OnSeekBarChangeListener, AnimationListener {

	private ImageButton musicPlayButton;
	private MediaPlayer mediaPlayer;
	private Utilities utilities;
	private SeekBar musicSeekBar;
	List<AnimeOpAndEdData> animeOPandEd;

	AnimeOpandEdDataSource dataSource;
	AnimeOpAndEdData currentAnime;
	
	Button question1_Button;
	Button question2_Button;
	Button question3_Button;
	Button question4_Button;
	Button youtubebtn;
	Button nextAnimebtn;
	Button backtolistbtn;
	TextView animeArtistTextv;
	TextView animeNameTextv;
	TextView animeSongTextv;
	TextView animeAnswerTextv;
	LinearLayout animeAnswersgroup;
	ImageView animeimageView;
	Animation animFlipin;
	Animation animCrossFade;
	





	ScrollView scrollview_buttons;
	ScrollView scrollview_animeAnswersView;

	

	private Handler mHandler = new Handler();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_play);

	   // View view = this.getWindow().getDecorView();
	    //view.setBackgroundColor(Color.);
		Intent intent = getIntent();
		
		String animeSongName = intent
				.getStringExtra("com.example.animeopedquiz2.MESSAGE");
		Log.i("intent", "animesongName: " + animeSongName);
		
		int levelnum = intent.getIntExtra("levelNum", 0);
		String[] bylevel = { Integer.toString(levelnum) };

		
		dataSource = new AnimeOpandEdDataSource(this);
		dataSource.open();
	Log.i("sdf", "level level velv e" + levelnum);
	
	//	animeOPandEd.clear();
/*	if (!animeOPandEd.isEmpty()) {
		Log.i("animeOPandEd ",  " animeOPandEd NOT EMPTY ");

	}*/
	

	
 	if (animeOPandEd == null) {
		String[] bysongname = { animeSongName };

		animeOPandEd = dataSource.listByLevel(bylevel);
		Log.i("index ",  "animeOPandEd  assigned ");
	/*	for (int i = 0; i < animeOPandEd.size(); i++){
			Log.i("index ", "index of " +  animeOPandEd.get(i).getAnswer());

			Log.i("index ", "index of " +  animeOPandEd.get(i).getID());

			
		}*/
		AnimeOpAndEdData ani = dataSource.getAnimeBYSongName(bysongname);
		//int index = animeOPandEd.indexOf(animeOPandEd.get(1));
		//int index2 = animeOPandEd.indexOf(ani);

		
		//Log.i("index ", "index of " +  animeOPandEd.);
		Log.i("index ", "index of " +  ani.getName());
		
		}else{
			//animeOPandEd.clear();
			Log.i("index ",  "animeOPandEd cleared");

		}

		String[] songName = { animeSongName };

		currentAnime = dataSource.getAnimeBYSongName(songName);
		Log.i("ANIME CHOOSEN", "NAME: " + currentAnime.getName() + "song: "
				+ currentAnime.getSong() + "MUSIC: " + currentAnime.getMusic() + "ATTEMPTS:" +currentAnime.getAttempts());

		musicPlayButton = (ImageButton) findViewById(R.id.musicPlayButton);
		musicSeekBar = (SeekBar) findViewById(R.id.musicSeekBar);
		scrollview_buttons = (ScrollView) findViewById(R.id.Scrollview_buttons);
		scrollview_animeAnswersView = (ScrollView) findViewById(R.id.Scrollview_animeAnswersView);

		question1_Button = (Button) findViewById(R.id.question1_Button);
		question2_Button = (Button) findViewById(R.id.question2_Button);
		question3_Button = (Button) findViewById(R.id.question3_Button);
		question4_Button = (Button) findViewById(R.id.question4_Button);
		youtubebtn    =  (Button) findViewById(R.id.youtubebtn);
		nextAnimebtn    =  (Button) findViewById(R.id.nextAnimebtn);
		backtolistbtn    =  (Button) findViewById(R.id.backtolistbtn);
		animeNameTextv    =  (TextView) findViewById(R.id.animeNameTextv);
		animeArtistTextv  =  (TextView) findViewById(R.id.animeArtistTextv);
		animeSongTextv  =  (TextView) findViewById(R.id.animeSongTextv);
		animeAnswerTextv  =  (TextView) findViewById(R.id.animeAnswerTextv);
		animeAnswersgroup = (LinearLayout) findViewById(R.id.animeAnswersgroup);
		
		animeimageView = (ImageView) findViewById(R.id.animeimageView);

		animFlipin = AnimationUtils.loadAnimation(this,
				R.drawable.zoom_in);

		animFlipin.setAnimationListener(this);
		
		animCrossFade = AnimationUtils.loadAnimation(this,
				R.drawable.cross_fade);

		
		animCrossFade.setAnimationListener(this);
	

		// Creating a Mediaplayer
		mediaPlayer = new MediaPlayer();
		utilities = new Utilities();
		musicSeekBar.setOnSeekBarChangeListener(this);
		mediaPlayer.setOnCompletionListener(this);

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
		
		makequizQ(currentAnime);
			
			if (currentAnime.getComplete().toString().equals("yes")) 
			{
				Log.i("32", "YES CURRENT COMPLETE");
				scrollview_buttons.setVisibility(View.GONE);
				//question12_Button.setVisibility(View.VISIBLE);
				youtubebtn.setVisibility(View.VISIBLE);
				nextAnimebtn.setVisibility(View.VISIBLE);
				backtolistbtn.setVisibility(View.VISIBLE);

				animeAnswersgroup.setVisibility(View.VISIBLE);
				scrollview_animeAnswersView.setVisibility(View.VISIBLE);
				

			}else{
				Log.i("32", "NOT  COMPLETE");
				scrollview_buttons.setVisibility(View.VISIBLE);

				youtubebtn.setVisibility(View.GONE);
				nextAnimebtn.setVisibility(View.GONE);
				backtolistbtn.setVisibility(View.GONE);
				animeAnswersgroup.setVisibility(View.GONE);
				scrollview_animeAnswersView.setVisibility(View.GONE);




				
			
			}
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
				musicSeekBar.setMax(93);
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
		Log.i("asd", "SONG DONE YOOUOO");
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
		//qbutton.setTextColor(R);

		String qbtnText = qbutton.getText().toString();
		Log.i("qbtn", "btn: " + qbtnText + " answer:  "
				+ currentAnime.getAnswer().toString());

		if (qbtnText.equals(currentAnime.getAnswer().toString())) {
			Toast.makeText(this, "RIGHT!", Toast.LENGTH_SHORT).show();
			
			dataSource.updateAnime(currentAnime, "yes");
			animeimageView.startAnimation(animFlipin);


			
		gotItRight();
			

		} else {
			Log.i("attempts", "before: " + currentAnime.getAttempts());
			Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
			dataSource.updateAnime(currentAnime, "no");
			
			dataSource.updateAnimeAttempts(currentAnime, currentAnime.getAttempts() + 1);
			Log.i("attempts", "after: " + currentAnime.getAttempts());

			
			finish();
			qbutton.setTextColor(Color.RED);
			

		}

	}

	
public void gotItRight(){
	
	//long nextAnime = currentAnime.getID() ;
	//Integer presentanime = (int) (long)  currentAnime.getID() -1;
	scrollview_buttons.setVisibility(View.GONE);
	youtubebtn.setVisibility(View.VISIBLE);
	nextAnimebtn.setVisibility(View.VISIBLE);
	backtolistbtn.setVisibility(View.VISIBLE);

	animeAnswersgroup.setVisibility(View.VISIBLE);
	scrollview_animeAnswersView.setVisibility(View.VISIBLE);
	scrollview_animeAnswersView.scrollTo(0, 100);

	


	
}

public void backtolistbtnpressed(View v){
 finish();
	
}

public void nextbtnpressed(View v){
	
int nextAnime;
nextAnime = 0;

	Log.i("sdds", "next clicked yo");
	//int nextAnime = (int) (long) currentAnime.getID();
	
	nextAnime = 0;
	
	 for (int i = 0; i < animeOPandEd.size(); i++)
	    {
	        if (animeOPandEd.get(i).getID() ==  currentAnime.getID() )
	        {
	        	Log.i("99999", "NEXT = " + i);
	        	nextAnime = i + 1;

	        }
	    } 

	  

	 
	
	Log.i("sajkksa",  ""+ nextAnime );

	
	Log.i("nextAnime", "NOW IN ARRAY: " + (nextAnime -1));

	Log.i("nextAnime", "NEXT IN ARRAY : " + nextAnime);
	
	Log.i("nextAnime", "NOW NON ARRAY: " + nextAnime);

	Log.i("nextAnime", "NEXT NON ARRAY : " + (nextAnime +1));
	
	int limit = animeOPandEd.size();
	//int limit = 50;


	if (nextAnime <  limit) {
		Log.i("nextAnime", "NEXT IN ARRAY : " + nextAnime);
		scrollview_animeAnswersView.scrollTo(0, 200);

		makequizQ(animeOPandEd.get(nextAnime));
		//scrollview_animeAnswersView.startAnimation(animCrossFade);
		animeimageView.startAnimation(animFlipin);

		Log.i("nextAnime", "ARRAY SIZE :" + animeOPandEd.size());

	}else{
		Log.i("nextAnime", "TOO LARGE level complete  : " + (nextAnime));
		nextAnimebtn.setVisibility(View.GONE);



		
		
	}
	
	
}

public void makequizQ(AnimeOpAndEdData currentAnimeQ){
	currentAnime = null;
	playSong(currentAnimeQ.getMusic());
currentAnime = currentAnimeQ;

if (currentAnime.getComplete().toString().equals("yes")) 
{
	Log.i("32", "YES CURRENT COMPLETE");
	scrollview_buttons.setVisibility(View.GONE);
	//question12_Button.setVisibility(View.VISIBLE);
	youtubebtn.setVisibility(View.VISIBLE);
	nextAnimebtn.setVisibility(View.VISIBLE);
	backtolistbtn.setVisibility(View.VISIBLE);

	animeAnswersgroup.setVisibility(View.VISIBLE);
	scrollview_animeAnswersView.setVisibility(View.VISIBLE);
//scrollview_animeAnswersView.startAnimation(animCrossFade);


}else{
	Log.i("32", "NOT  COMPLETE");
	scrollview_buttons.setVisibility(View.VISIBLE);

	youtubebtn.setVisibility(View.GONE);
	nextAnimebtn.setVisibility(View.GONE);
	backtolistbtn.setVisibility(View.GONE);
	animeAnswersgroup.setVisibility(View.GONE);
	scrollview_animeAnswersView.setVisibility(View.GONE);




	

}
	String[] animeQuestions = new String[4];
	animeQuestions[0] = currentAnimeQ.getQuestion1().toString();
	animeQuestions[1] = currentAnimeQ.getQuestion2().toString();
	animeQuestions[2] = currentAnimeQ.getQuestion3().toString();
	animeQuestions[3] = currentAnime.getQuestion4().toString();
	// int idx = new Random().nextInt(animeQuestions.length);

	List<String> ranQs = Arrays.asList(animeQuestions);

	Collections.shuffle(ranQs);

	question1_Button.setText(animeQuestions[0].toString());
	question2_Button.setText(animeQuestions[1].toString());
	question3_Button.setText(animeQuestions[2].toString());
	question4_Button.setText(animeQuestions[3].toString());

	// mContext.getResources().getIdentifier(
	//			animeImageArray[position].toString(), "drawable",
		//		mContext.getPackageName()
	animeimageView.setBackgroundResource(this.getResources().getIdentifier(currentAnimeQ.getImage(), "drawable", this.getPackageName()));
	//animeimageView
	  animeNameTextv.setText(" Anime:   " + currentAnimeQ.getName().toString());
	  animeSongTextv.setText(" Song:     " + currentAnimeQ.getSong().toString());
	animeArtistTextv.setText(" Artist:    " + currentAnimeQ.getArtist().toString());
	animeAnswerTextv.setText(" Answer: " + currentAnimeQ.getAnswer().toString());
	
	animeNameTextv.setTextColor(Color.BLACK);
	animeArtistTextv.setTextColor(Color.BLACK);
	animeSongTextv.setTextColor(Color.BLACK);
	animeAnswerTextv.setTextColor(Color.BLACK);
	
	animeNameTextv.setTextSize(17);
	animeArtistTextv.setTextSize(17);
	animeSongTextv.setTextSize(17);
	animeAnswerTextv.setTextSize(17);
	
	
	animeNameTextv.setTypeface(null, Typeface.BOLD);
	animeArtistTextv.setTypeface(null, Typeface.BOLD);
	animeSongTextv.setTypeface(null, Typeface.BOLD);
	animeAnswerTextv.setTypeface(null, Typeface.BOLD);
	
	
//animeAnswerTextv.setAnimation(animCrossFade);
//animeArtistTextv.setAnimation(animCrossFade);
//animeSongTextv.setAnimation(animCrossFade);
//animeNameTextv.setAnimation(animCrossFade);
	Log.i("Questionsz",
			" q1: " + animeQuestions[0].toString() + " q2: "
					+ animeQuestions[1].toString() + " q3: "
					+ animeQuestions[2].toString() + " q4: "
					+ animeQuestions[3].toString());

	
}


public void youtubebtnclick(View v){

  if (currentAnime.getYoutube().contains("https://www.youtube.com/watch?v")){

    	System.out.println("HASS WWWW");
    	
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(currentAnime.getYoutube())));

    } else{
        System.out.println("NO youtube link");
		Toast.makeText(this, "No youtube link", Toast.LENGTH_SHORT).show();


        
    }

	
}
	@Override
	public void onDestroy() {
		super.onDestroy();
		mHandler.removeCallbacks(mUpdateTimeTask);
		mediaPlayer.release();
		dataSource.close();
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	
	

}
