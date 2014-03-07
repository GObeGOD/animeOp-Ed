package model;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.animeopedquiz2.R;

public class ImageGridAdapter extends BaseAdapter implements AnimationListener {
	 private Context mContext;
	 public  String[] numbers;
	 Animation animFadein;
	 int i = 0 ;
	 public Integer[] animeImageArray ;
	 public String[] animeNameArray ;;
	  List<AnimeOpAndEdData>  animeOPandEd;
 	AnimeOpandEdDataSource dataSource;

	   
	   public ImageGridAdapter(Context c,int level){
	         mContext = c;
	        
		     dataSource =  new AnimeOpandEdDataSource(c);
		    Log.e("sadasd", "MUSIC LEVEL SELECT " + level);
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
			       animeImageArray =  new Integer[1];
				animeNameArray = new String[1];
			//		animeImageArray[0] = R.drawable.imagefun;
			//		animeNameArray[1] = "SAD"; 				
			    
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
		 return animeImageArray.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		 return animeImageArray[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// System.out.println("getView");

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
		 imageView.setPadding(10, 10, 10, 10);
		 imageView.startAnimation(animFadein);
		 imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
	        return imageView;
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
