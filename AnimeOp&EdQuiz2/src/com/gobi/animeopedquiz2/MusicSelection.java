package com.gobi.animeopedquiz2;



import com.gobi.animeopedquiz2.R;

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

		dataSource = new AnimeOpandEdDataSource(this);
		dataSource.open();

		String[] parts = level.split("_");
		// String levelString = parts[0]; // level
		String levelNum = parts[1]; // 1
		int levelInt = Integer.parseInt(levelNum);
		insertLevel(levelInt);

		GridView gridView = (GridView) findViewById(R.id.gridView1);

		// Instance of ImageAdapter Class and Send Level
		gridView.setAdapter(new ImageGridAdapter(this, levelInt));
	
		        
	
		
		}
  
  
  public void gridItemtapped(View v) {
		System.out.println(v.getContentDescription());
		 //  Toast.makeText(getApplicationContext(),v.getId(), Toast.LENGTH_SHORT).show();
			String name = (String) v.getContentDescription();
		  changeAct(name);
	Log.i("ridItemtapped", "GRID ITEM TAPPED");
	  
}
  
  public void insertLevel(int level){
	//  Log.e("insertLevel", "LEVEL CHOOSEN: " + level);
	
	  switch (level) {
	case 1:
		Log.e("insertLevel", "LEVEL 1!!!!");
		String[] bylevel = {Integer.toString(level)};
				 
				  if(dataSource.getCountByLevel(bylevel) == 0){
					  
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));

					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Berserk",
							  "Tell Me Why", "PENPALS", "berserkop1tellmewhy",
							  "berserk opening", "Berserk", "Gungrave", "Claymore",
							  "Fist of the North Star", "Berserk", "berserk_img", 1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Btooom!",
							  "No pain, No game", "Nano", "btooom_op1_nopainnogame",
							  "btooom opening 1", "Btooom!", "Mirai Nikki", "Gantz",
							  "Btooom!", "Rozen Maiden", "btooom_img", 1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Black Lagoon",
							  "Red Fraction", "MELL", "blacklagoon_op1_redfraction",
							  " black lagoon opening 1", "Black Lagoon",
							  "Jormungand", "Michiko & Hatchin", "Canaan",
							  "Black Lagoon", "blacklagoon_img", 1,"no"));
					  
					  
					  
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData( "Planetes", "Dive in the Sky", "Mikio Sakai", "planetes_op1_diveinthesky", "planetes opening", "Planetes"
							  , "Rocket Girls", "Planetes", "Space Brothers", "Freedom", "planetes_img",1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData( "Gankutsuou", "You Won't see me coming", "Jean-Jacques Burnel", "gankutsuou_ed1_youwontseemecoming", "gankutsuou ending", "Gankutsuou"
							  , "Mononoke", "Gankutsuou", "Gungrave", "Monster", "gankutsuou_img",1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));
					  
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Berserk",
							  "Tell Me Why", "PENPALS", "berserkop1tellmewhy",
							  "berserk opening", "Berserk", "Gungrave", "Claymore",
							  "Fist of the North Star", "Berserk", "berserk_img", 1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Btooom!",
							  "No pain, No game", "Nano", "btooom_op1_nopainnogame",
							  "btooom opening 1", "Btooom!", "Mirai Nikki", "Gantz",
							  "Btooom!", "Rozen Maiden", "btooom_img", 1,"yes"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Black Lagoon",
							  "Red Fraction", "MELL", "blacklagoon_op1_redfraction",
							  " black lagoon opening 1", "Black Lagoon",
							  "Jormungand", "Michiko & Hatchin", "Canaan",
							  "Black Lagoon", "blacklagoon_img", 1,"no"));
					  
					  
					  
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData( "Planetes", "Dive in the Sky", "Mikio Sakai", "planetes_op1_diveinthesky", "planetes opening", "Planetes"
							  , "Rocket Girls", "Planetes", "Space Brothers", "Freedom", "planetes_img",1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData( "Gankutsuou", "You Won't see me coming", "Jean-Jacques Burnel", "gankutsuou_ed1_youwontseemecoming", "gankutsuou ending", "Gankutsuou"
							  , "Mononoke", "Gankutsuou", "Gungrave", "Monster", "gankutsuou_img",1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));
					  

					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Berserk",
							  "Tell Me Why", "PENPALS", "berserkop1tellmewhy",
							  "berserk opening", "Berserk", "Gungrave", "Claymore",
							  "Fist of the North Star", "Berserk", "berserk_img", 1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Btooom!",
							  "No pain, No game", "Nano", "btooom_op1_nopainnogame",
							  "btooom opening 1", "Btooom!", "Mirai Nikki", "Gantz",
							  "Btooom!", "Rozen Maiden", "btooom_img", 1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Black Lagoon",
							  "Red Fraction", "MELL", "blacklagoon_op1_redfraction",
							  " black lagoon opening 1", "Black Lagoon",
							  "Jormungand", "Michiko & Hatchin", "Canaan",
							  "Black Lagoon", "blacklagoon_img", 1,"no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));
					  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Haruka Kanata", "Asian Kung-Fu Generation", "naruto_op2_haruka_kanata", "naruto op 2 haruka kanata", "Naruto", "Shaman King", "Naruto", "Saint Seiya", "Ninku", "naruto", 1, "no"));

				  }else{
				      Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

					  
				  }
		
				 
				  

	break;
	
	case 2:
	    Log.e("insertLevel", "LEVEL 2!!!!");
	    String[] bylevel2 = {Integer.toString(level)};
		 
		  if(dataSource.getCountByLevel(bylevel2) == 0){
			  Log.e("getCountByLevel", "ADDING LEVEL 1");
		
		      
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",2,"no"));
		      
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",2,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "naruto",2,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",2,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "naruto",2,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",2,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "level4",2,"no"));
		      
			  
		  }else{
		      Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

			  
		  }

    break;
			
    case 3:
		
    	Log.e("insertLevel", "LEVEL 3!!!!");
    	 String[] bylevel3 = {Integer.toString(level)};
		 
		  if(dataSource.getCountByLevel(bylevel3) == 0){
			  Log.e("getCountByLevel", "ADDING LEVEL 1");
		
		      
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",3,"no"));
		      
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",3,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "naruto",3,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",3,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "naruto",3,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "imagefun",3,"no"));
		      dataSource.addAnimeOPandED(new AnimeOpAndEdData( "naruto", "go", "artist", "music", "youtube", "answer"
		              , "question1", "question2", "question3", "question4", "level4",3,"no"));
			  
		  }else{
		      Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

			  
		  }


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
