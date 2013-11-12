package com.example.animeopedquiz2;



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
	
	 
	public  String[] numbers;
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.music_selection);
	    	
		/*	  // Get the message from the intent
		    Intent intent = getIntent();
		    String message = intent.getStringExtra("levelId");
		    numbers = new String[]{"asdas","asdasd",message,"im in a grid","GRID","qwe","435","34534","bleach"};

		    // Create the text view
		    TextView textView = new TextView(this);
		    textView.setTextSize(40);
		    textView.setText(message);
		        // Set the text view as the activity layout
		   // setContentView(textView);
*/
			
	        
	        GridView gridView = (GridView) findViewById(R.id.gridView1);
	      //  final ArrayList<String>  gridItems = new ArrayList<String>();
	        
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
	    
	  private void changeAct(String message){
		  Intent intent = new Intent(this, MusicPlayActivity.class);
		  intent.putExtra(EXTRA_MESSAGE, message);
	   	  startActivity(intent); 	
	        
	  }
	  
}
