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
public enum Levels {level1,level2,level3,level4};

	GridView gridView;
	public String levelname; 
	AnimeOpandEdDataSource dataSource;
	Levels levels;
	public static String shareLevelnum;
	 
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
	    
	     dataSource =  new AnimeOpandEdDataSource(this);
	 	 dataSource.open();
	 	 
	 	String[] parts = level.split("_");
	 //	String levelString = parts[0]; // level
	 	String levelNum = parts[1]; // 1
	 	int levelInt = Integer.parseInt(levelNum);
        insertLevel(levelInt);
	 	
  
          
         
	     GridView gridView = (GridView) findViewById(R.id.gridView1);
	        
	        // Instance of ImageAdapter Class and  Send Level 
	        gridView.setAdapter(new  ImageGridAdapter(this,levelInt));
	        
	
		        
	 
	 
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
  
  
  public void insertLevel(int level){
	//  Log.e("insertLevel", "LEVEL CHOOSEN: " + level);
	
	  switch (level) {
	case 1:
		Log.e("insertLevel", "LEVEL 1!!!!");
		String[] bylevel = {Integer.toString(level)};
				 shareLevelnum = bylevel.toString();
				 
				  if(dataSource.getCountByLevel(bylevel) == 0){
					  Log.e("getCountByLevel", "ADDING LEVEL 1");
					  AnimeOpAndEdData naruto ;
				      naruto = dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go", "artist", "music", "youtube", "answer", "s", "sd","sd", "sd", "imagefun", 1));
				      Log.i("InsertLevel", "aNIME added id " + naruto.getID());
				     


				      AnimeOpAndEdData naruto2 ;
				      naruto2 = dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "naruto",1));
				      Log.i("InsertLevel", "aNIME added id " + naruto2.getID());

				      
				      
				      AnimeOpAndEdData naruto3 ;
				      naruto3 = dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "imagefun",1));
				      Log.i("InsertLevel", "aNIME added id " + naruto3.getID());
				      
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "imagefun",1));
				      
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "imagefun",1));
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "naruto",1));
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "imagefun",1));
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "naruto",1));
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "imagefun",1));
				      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
				              , "question1", "question2", "question3", "question4", "level4",1));
					  
				  }else{
				      Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

					  
				  }
		
				 
				  

	break;
	
	case 2:
	    Log.e("insertLevel", "LEVEL 2!!!!");

    break;
			
    case 3:
		
    	Log.e("insertLevel", "LEVEL 3!!!!");

	break;
	
    case 4:
	   
    	Log.e("insertLevel", "LEVEL 4!!!!");

	break;
	
	default:
		break;
	}
	  
	  
	  
	  
	 
	 
	    	
	    	
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
