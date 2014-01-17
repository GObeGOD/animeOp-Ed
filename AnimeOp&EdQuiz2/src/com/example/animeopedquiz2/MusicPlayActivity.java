package com.example.animeopedquiz2;



import java.io.IOException;

import model.BaseActivity;
import model.Utilities;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;


public class MusicPlayActivity extends BaseActivity implements OnCompletionListener,SeekBar.OnSeekBarChangeListener  {
	
	 private ImageButton musicPlayButton;
	 private  MediaPlayer mediaPlayer;
	 private Utilities utilities;
	 private SeekBar musicSeekBar;
	 private Handler mHandler = new Handler();;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_play);
        
        musicPlayButton = (ImageButton) findViewById(R.id.musicPlayButton);
        musicSeekBar  = (SeekBar) findViewById(R.id.musicSeekBar);
        
        // Creating a Mediaplayer
        mediaPlayer = new MediaPlayer();
       
        utilities = new Utilities();
        playSong("whatever");
        musicSeekBar.setOnSeekBarChangeListener(this); 
        musicPlayButton.setOnClickListener(new View.OnClickListener() {
        	 
            @Override
            public void onClick(View arg0) {
                // check for already playing
	 if(mediaPlayer.isPlaying()){
				 
                 if(mediaPlayer!=null){
                	 mediaPlayer.pause();
                     // Changing button image to play button
                	 musicPlayButton.setImageResource(R.drawable.music_playbutton);
                 }
             }else{
                 // Resume song
                 if(mediaPlayer!=null){
                	 mediaPlayer.start();
                     // Changing button image to pause button
                	 musicPlayButton.setImageResource(R.drawable.music_pausebutton);
                 }
             }
            }
        });
        
	}
	
	public void musicPlayClick(View view){

		 Intent intent = getIntent();
	        String message = intent.getStringExtra(MusicSelection.EXTRA_MESSAGE);
			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
			


         
			

	}
	public void  playSong(String path){
        // Play song
        try {
      ///  MediaPlayer.create(this, R.raw.beckophitintheusa);
        //	AssetFileDescriptor afd = getAssets().openFd("usa.mp3");
        	 String fileName = "android.resource://" + getPackageName() + "/" + R.raw.beckophitintheusa;

        	mediaPlayer.reset();
        ///  mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
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
       //  songTotalDurationLabel.setText(""+utils.milliSecondsToTimer(totalDuration));
            // Displaying time completed playing
        //    songCurrentDurationLabel.setText(""+utils.milliSecondsToTimer(currentDuration));

            // Updating progress bar
            int progress = (int)(utilities.getProgressPercentage(currentDuration, totalDuration));
            //Log.d("Progress", ""+progress);
            musicSeekBar.setProgress(progress);

            // Running this thread after 100 milliseconds
            mHandler.postDelayed(this, 100);
        }
     };
	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		 musicPlayButton.setImageResource(R.drawable.music_playbutton);
		//  playSong("whatever");
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
	        int currentPosition = utilities.progressToTimer(seekBar.getProgress(), totalDuration);
	 
	        // forward or backward to certain seconds
	        System.out.println(currentPosition);
	        mediaPlayer.seekTo(currentPosition);
	 
	        // update timer progress again
	        updateSeekBar();
		
	}
	

	
	 @Override
	 public void onBackPressed() {
		 System.out.println("HELP!!!!!!");
		 this.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK)); 

		 finish();
	 }
	
	 @Override
     public void onDestroy(){
     super.onDestroy();
     mHandler.removeCallbacks(mUpdateTimeTask);
     mediaPlayer.release();
     }
	 

						
	
}
