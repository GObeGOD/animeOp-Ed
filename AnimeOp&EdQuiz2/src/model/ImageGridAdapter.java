package model;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.animeopedquiz2.LevelActivity;
import com.example.animeopedquiz2.MusicSelection;
import com.example.animeopedquiz2.R;

public class ImageGridAdapter extends BaseAdapter implements AnimationListener {
	 private Context mContext;
	 public  String[] numbers;
	 Animation animFadein;
	 int i = 0 ;
	 public Integer[] animeImageArray ;
	 public String[] animeNameArray ;
	  List<AnimeOpAndEdData>  animeOPandEd;
 	AnimeOpandEdDataSource dataSource;
 	MusicSelection musicSelec; 
	   
	   public ImageGridAdapter(Context c,int level){
	         mContext = c;
	        
		     dataSource =  new AnimeOpandEdDataSource(c);
		     musicSelec = new MusicSelection();
			String[] bylevel = {Integer.toString(level)};
			
		     if(animeOPandEd == null){
			     dataSource.open();
                 Log.e("ImageGridAdapter", "ANIME SONG LIST NULL ADDING!!");

				   animeOPandEd = dataSource.listByLevel(bylevel);  

		     }else{
                 Log.e("ImageGridAdapter", "LIST EXCITES");


		     }
	       
		     

	        // Reading all Songs
		        if (animeOPandEd.isEmpty()) {
			        Log.e("ImageGirdAdapter: ", "Found NOTHING at level: " + level ); 
			    	animeImageArray =  new Integer[0];
					animeNameArray = new String[0];
					
					AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
					// Add the buttons
					builder.setTitle("No Songs Found :(").setMessage("Click Okay to go back");
					

					builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					               // User clicked OK button
					        	   Log.i("alertDialog", "OKAY cLICKED");
					        	backActivity();
					           }
					       });
					builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					               // User cancelled the dialog
					        	   Log.i("alertDialog", "CANCEL cLICKED");
                      
					           }
					       });
					// Set other dialog properties
					
					// Create the AlertDialog
					AlertDialog alertDialog = builder.create();
					alertDialog.show();

					
			    
				}else {
					
					int numofSongs  =  animeOPandEd.size();
					

					Log.i("HEY the # of Songs FOUND" , "again FOUND - " + animeOPandEd.size());
					
					//set Num of Songs going to be displayed 
					animeImageArray =  new Integer[numofSongs];
					animeNameArray = new String[numofSongs];
				    
				    
				       for (AnimeOpAndEdData aOP : animeOPandEd) {
				        if(i < animeImageArray.length){
				        
				        	//if(animeImageArray == null & animeNameArray  == null){
				        	//	animeImageArray[i] = R.drawable.imagefun;
					       	    animeNameArray[i] = aOP.getName();
					       	//    Log.i("animeImage and name array", "NULL values for IMAGE AND NAME ARRAY");
					       	// log all songs in loop
						       	String log1 = "Id: " + aOP.getID() + " LOOP: " + i+  " Name: "+ aOP.getName() + "\n"+ 
						       	"Song:"  + aOP.getSong() +"\n"+
						       	"Level: " + aOP.level + " Music: " + aOP.getMusic()+
						        "youtube: " + aOP.getYoutube() ;
						       	
						       	
						       	Log.i("FOR loop", log1);
						        	   // looking for image Resources 
						       	
						       //	 if ( animeOPandEd.get(i).getName().equals("naruto")){
					 
						       		String imageUri = aOP.getImage();
						       		System.out.println("YEAH" + "getImage() = " + imageUri + aOP.getName() + aOP.id + aOP.getMusic() +  aOP.getYoutube());
						       		
						       		int imagelink = mContext.getResources().getIdentifier(imageUri, "drawable", mContext.getPackageName());
						       		

						       		System.out.println("my imageResource: "+ imagelink +" real imageResource"+ R.drawable.imagefun3 );
						       		animeImageArray[i] = imagelink;
						     //  	 }
					       	 
				        		
				        	//}
				        	
				         	
					       		
					        

					        i++;
				     
   
				      } //END of if # 1 
				       
			
				        
			        }
					
				}

	    
	   
	        
	        
	    }
	   
	   
	   
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(animeImageArray.length < 1){
			return 0;

			
		}else {
			return animeImageArray.length;
			
		}
		 
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
	//	 return animeImageArray[position];
		if(animeImageArray.length < 1){
			return 0;

			
		}else {
			return animeImageArray[position];
			
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("getView", "getView called IMAGEARRAY: " + animeImageArray.length);
	
				Log.i("getView", "position: " + position);

		 

			if(animeImageArray != null){
				Log.i("GETVIEW ", "image and name not NUll");
				 ImageView imageView = new ImageView(mContext);

					 imageView.setImageResource(animeImageArray[position]);
					 imageView.setId(animeImageArray[position]);
				   //  imageView.setContentDescription(String.valueOf(cThumbIds[position]));
					 
					 ///ADD Animations 
					  animFadein = AnimationUtils.loadAnimation(mContext,
				                R.drawable.zoom_in);
					   imageView.setContentDescription(animeNameArray[position]);
					   animFadein.setAnimationListener(this);
					   
					   
					 imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
					 imageView.setPadding(10, 5, 10, 5);
					 imageView.startAnimation(animFadein);
					 imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
				     
					 return imageView;

	           }else{
	        	   
	        	   Log.i("GETVIEW ", "null image and name ");
					 ImageView imageView2 = new ImageView(mContext);
                     imageView2.setImageResource(R.drawable.imagefun);
                     imageView2.setId(404);
	        	  return imageView2;
	           }
		
				
		
			
			

	}

public void backActivity(){
	   //Intent intent = new Intent(mContext, LevelActivity.class);
		//  ((Object) mContext).finishActivity();
	Activity activity = (Activity) mContext;
	activity.finish();

}

	@Override
	public void onAnimationEnd(Animation arg0) {
		// TODO Auto-generated method stub
	}



	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	
	

}
