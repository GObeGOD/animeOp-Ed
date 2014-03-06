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
	 public Integer[] mThumbIds = new Integer[1];
	 public String[] cThumbIds = new String[1];
 	AnimeOpandEdDataSource dataSource;

	   
	   public ImageGridAdapter(Context c,String level){
	        mContext = c;
		     dataSource =  new AnimeOpandEdDataSource(c);
		     dataSource.open();

	       
	       for (int i = 0; i < mThumbIds.length; i++) {
	        System.out.println("loop that worked:" + i);
	        }
	        

	   
	      //   List<AnimeOpAndEdData> animeOPandEd = dataSource.getAllAnimeOpAndEd(); 
	     String[] bylevel = {"1"};
	      List<AnimeOpAndEdData> animeOPandEd = dataSource.listByLevel(bylevel);    
       
	        // Reading all Songs
		        if (animeOPandEd.size() == 0) {
			        Log.d("ImageGirdAdapter: ", "Found NOTHING" + level ); 

				}else {
				      
				       for (AnimeOpAndEdData cn : animeOPandEd) {
				        if(i < mThumbIds.length){
				        	//String name = cn.getName().toString();
				        //	int NameINT = Integer.parseInt(cn.getName());
				       	    mThumbIds[i] = R.drawable.imagefun;
				       	 System.out.println("putting on images!" + i);
				       	    cThumbIds[i] = cn.getName();
				       	
				       	 System.out.println("LOOP STRING:"+ cThumbIds[i]);
				        	 System.out.println("LOOP:"+ i);
				        	    
				       	 if ( animeOPandEd.get(i).getName().equals("naruto")){
			 
				       		 String imageUri = cn.getImage();
				       		System.out.println("YEAH" + "getImage() = " + imageUri + cn.getName() + cn.id + cn.getMusic() +  cn.getYoutube());
				       		
				       		// find Image Resources 
				       		int imagelink = mContext.getResources().getIdentifier(imageUri, "drawable", mContext.getPackageName());

				       		System.out.println("my imageResource: "+ imagelink +" real imageResource"+ R.drawable.imagefun3 );
				       		 mThumbIds[i] = imagelink;
				       	 }
				       		
				        
			        	// Log.d("AnimeOpandEd list Loop: ", "listItem:" + cn.getID()); 

				        i++;
				        
				        
				        }
				       
				       
				           String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Song: " + cn.getSong() + " Level: " + cn.level + " Music: " + cn.getMusic()+
				        		   " youtube: " + cn.getYoutube() 
				        		   ;
				               
				       Log.d("Name: ", log);
				        
				      
				        }
					
				}

	    
	   
	        
	        
	    }
	   
	   
	   
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		 return mThumbIds[position];
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
		 imageView.setImageResource(mThumbIds[position]);
		 imageView.setId(mThumbIds[position]);
	   //  imageView.setContentDescription(String.valueOf(cThumbIds[position]));
		  animFadein = AnimationUtils.loadAnimation(mContext,
	                R.drawable.zoom_in);
		   imageView.setContentDescription(cThumbIds[position]);
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
