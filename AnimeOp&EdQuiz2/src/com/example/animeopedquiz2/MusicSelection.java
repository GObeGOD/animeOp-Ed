package com.example.animeopedquiz2;



import model.AnimeOpAndEdData;
import model.DatabaseHandler;
import model.ImageGridAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MusicSelection extends Activity  {
	public final static String EXTRA_MESSAGE = "com.example.animeopedquiz2.MESSAGE";

	GridView gridView;
	DatabaseHandler db;
	
	 
	public  String[] numbers;
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.music_selection);
	        
	        db = new DatabaseHandler(getApplicationContext())  ;
	        
		  // Get the level from the intent
		    Intent intent = getIntent();
		    String level = intent.getStringExtra("levelId");
		 
            System.out.println("here is the level the user clicked" + level);
		  
           insertLevel(level);
         
          
         
	        GridView gridView = (GridView) findViewById(R.id.gridView1);
	      /// final ArrayList<String>  gridItems = new ArrayList<String>();
	        
	        // Instance of ImageAdapter Class
	        gridView.setAdapter(new  ImageGridAdapter(this));
	      // ImageView view = (ImageView)findViewById(R.id.gridView1);
	        
	   
		        
	 
	 
     gridView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
					System.out.println(v.getContentDescription());
				 //  Toast.makeText(getApplicationContext(),v.getId(), Toast.LENGTH_SHORT).show();
					String name = (String) v.getContentDescription();
				  changeAct(name);
				
				   
				}
			});
		
		}
	    public void insertLevel(String level){
	    	 System.out.println("ABOUT TO COMPARE " + level + " with level1" );
	    	 
	    	if(level.equals("level1")){
	    		
           System.out.println("ITS A LEVEL 1");
        
           
     
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));
           db.addAnimeOPandED(new AnimeOpAndEdData(0, "naruto", "go", "artist", "music", "youtube", "answer"
                   , "question1", "question2", "question3", "question4", "image","level1"));

          // DatabaseHandler db = new DatabaseHandler(c);
	         
           
	        /**
	         * CRUD Operations
	         * */
	        // Inserting Contacts
	   
	      //  db.addContact(new Contact("Srinivas", "9199999999"));
	      
        //   System.out.println("count of db"+ db.getAnimeOpandEDCount("level1"));
           
           
           
           
 
	    	}
	    	
	    	
	    }
	  private void changeAct(String message){
		  Intent intent = new Intent(this, MusicPlayActivity.class);
		  intent.putExtra(EXTRA_MESSAGE, message);
	   	  startActivity(intent); 	
	        
	  }
	  
}
