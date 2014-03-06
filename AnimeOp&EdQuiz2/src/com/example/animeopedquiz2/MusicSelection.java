package com.example.animeopedquiz2;



import model.AnimeOpAndEdData;
import model.AnimeOpandEdDataSource;
import model.BaseActivity;
import model.ImageGridAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class MusicSelection extends BaseActivity  {
	public final static String EXTRA_MESSAGE = "com.example.animeopedquiz2.MESSAGE";

	GridView gridView;
	public String levelname; 
	AnimeOpandEdDataSource dataSource;
	
	 
	public  String[] numbers;
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.music_selection);
	        // Get the level from the intent
		    Intent intent = getIntent();
		    String level = intent.getStringExtra("levelId");
		 
            System.out.println("here is the level the user clicked " + level);
		  levelname = level;
	      //  db = new DatabaseHandler(getApplicationContext())  ;
	     dataSource =  new AnimeOpandEdDataSource(this);
	 	 dataSource.open();
         insertLevel(level);
         // List<AnimeOpAndEdData> animeOPandEd =  dataSource.getAllAnimeOpAndEd();
       // Log.i("MUISCSELECTION",animeOPandEd.toString());
          
         
	     GridView gridView = (GridView) findViewById(R.id.gridView1);
	    /// final ArrayList<String>  gridItems = new ArrayList<String>();
	        
	        // Instance of ImageAdapter Class and  Send Level 
	        gridView.setAdapter(new  ImageGridAdapter(this,level));
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
	    	// System.out.println("ABOUT TO COMPARE " + level + " with level1" );
	  AnimeOpAndEdData naruto ;
      naruto = dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go", "artist", "music", "youtube", "answer", "s", "sd","sd", "sd", "imagefun", 1));
      Log.i("InsertLevel", "aNIME added id " + naruto.getID());
     


      AnimeOpAndEdData naruto2 ;
      naruto2 = dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "naruto",1));
      Log.i("InsertLevel", "aNIME added id " + naruto2.getID());

      
      
      AnimeOpAndEdData naruto3 ;
      naruto3 = dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun3",1));
      Log.i("InsertLevel", "aNIME added id " + naruto3.getID());
      
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun3",1));
      
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun3",1));
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun3",1));
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun3",1));
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "naruto",1));
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun",1));
      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
              , "question1", "question2", "question3", "question4", "imagefun3",1));
      dataSource.addAnimeOPandED(new AnimeOpAndEdData("name", "song", "artist", "music", "youtube", "answer", "question1", "question2", "question3", "question4", "image", 3) );
      dataSource.addAnimeOPandED(new AnimeOpAndEdData("THANK GOD", "BESTEVER", "GOBI", "LIFE", "youtube", "answer", "question1", "question2", "question3", "question4", "image", 5) );

	
	    	
	    	
	    }

	  private void changeAct(String message){
		  Intent intent = new Intent(this, MusicPlayActivity.class);
		  intent.putExtra(EXTRA_MESSAGE, message);
	   	  startActivity(intent); 	
	        
	  }
	  
	  
	  @Override
	protected void onResume() {
		super.onResume();
	    dataSource.open();
	}
	  
	  @Override
	protected void onPause() {
	super.onPause();
		dataSource.close();
	}
	  
}
