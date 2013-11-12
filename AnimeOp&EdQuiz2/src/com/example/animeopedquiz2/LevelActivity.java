package com.example.animeopedquiz2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LevelActivity extends Activity{

	
	
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.levels);
	        
	        
	    }
	  
	  
 public void handleImageButton(View v){
		String name = getResources().getResourceEntryName(v.getId());
	  
		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, MusicSelection.class);
		
		    intent.putExtra("levelId", name);
		    startActivity(intent);

	}

	
}
