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
	 int i =0 ;
	   public Integer[] mThumbIds = new Integer[30];
	   public String[] cThumbIds = new String[30];
	   
	   
	   public ImageGridAdapter(Context c){
	        mContext = c;
	       
	       
	        for (int i = 0; i < mThumbIds.length; i++) {
	       // System.out.println("loop that worked:" + i);
	        }
	        
	        DatabaseHandler db = new DatabaseHandler(c);
	         
	        /**
	         * CRUD Operations
	         * */
	        // Inserting Contacts
	     
	      //  db.addContact(new Contact("Srinivas", "9199999999"));
	      
	         
	        // Reading all contacts
	        Log.d("Reading: ", "Reading all contacts.."); 
	        List<AnimeOpAndEdData> animeOPandEd = db.getAllAnimeOpAndEd();       
	         
	        for (AnimeOpAndEdData cn : animeOPandEd) {
	        
	        if(i < mThumbIds.length){
	        	//String name = cn.getName().toString();
	        //	int NameINT = Integer.parseInt(cn.getName());
	       	    mThumbIds[i] = R.drawable.imagefun;
	       	 System.out.println("putting on images!");
	       	    cThumbIds[i] = cn.getName();
	       	
	       	 System.out.println("LOOP STRING:"+ cThumbIds[i]);
	        	// System.out.println("LOOP:"+ i);
	        	    
	       	 if ( animeOPandEd.get(i).getName().equals("naruto")){
	       		 System.out.println("FUCK! YEAH");
	       	//	 String imageUri = cn.getName();
	       		int imagelink = mContext.getResources().getIdentifier("naruto", "drawable", mContext.getPackageName());

	       		System.out.println("my imageResource: "+ imagelink +" real imageResource"+ R.drawable.imagefun3 );
	       		 mThumbIds[i] = imagelink;
	       	 }
	       		
	     
		      
	        i++;
	        
	        
	        }
	       
	        	
	    //        String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Song: " + cn.getSong();
	                // Writing Contacts to log
	    //    Log.d("Name: ", log);
	        
	      
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
