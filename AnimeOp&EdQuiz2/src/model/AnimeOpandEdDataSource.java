package model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class AnimeOpandEdDataSource {
	
	DatabaseHandler dbHelper;
	SQLiteDatabase dataBase;
	Context mContext; 
	
	public AnimeOpandEdDataSource(Context context){
		mContext = context;
		dbHelper = new DatabaseHandler(context);

	}
   
	public void open() {
			Log.i("DataSource", "Database Opened");
			dataBase = dbHelper.getWritableDatabase();
			
	}
	
     public void close() {
		Log.i("DataSource", "Database Closed");
		dbHelper.close();
	}
     
     public static final  String[] allcolumns = {
 
 		DatabaseHandler.KEY_ID,
 		DatabaseHandler.KEY_NAME,
 		DatabaseHandler.KEY_Song,
 		DatabaseHandler.KEY_Artist,
 		DatabaseHandler.KEY_Music,
 		DatabaseHandler.KEY_Youtube,
 		DatabaseHandler.KEY_Answer,
 		DatabaseHandler.KEY_Question1,
 		DatabaseHandler.KEY_Question2,
 		DatabaseHandler.KEY_Question3,
 		DatabaseHandler.KEY_Question4,
 		DatabaseHandler.KEY_Image,
 		DatabaseHandler.KEY_Level
 		
     };
 		



     
     
     
     
     
     
     
     

 	// Adding new Anime music
 	public AnimeOpAndEdData addAnimeOPandED(AnimeOpAndEdData opandEd) {
 		//SQLiteDatabase db = this.getWritableDatabase();

 		ContentValues values = new ContentValues();
 		values.put(DatabaseHandler.KEY_NAME, opandEd.getName()); // anime Name
 		values.put(DatabaseHandler.KEY_Song, opandEd.getSong()); // anime song

 		values.put(DatabaseHandler.KEY_Artist, opandEd.getArtist());
 		values.put(DatabaseHandler.KEY_Music, opandEd.getMusic());

 		values.put(DatabaseHandler.KEY_Youtube, opandEd.getYoutube());
 		values.put(DatabaseHandler.KEY_Answer, opandEd.getAnswer());

 		values.put(DatabaseHandler.KEY_Question1, opandEd.getQuestion1());
 		values.put(DatabaseHandler.KEY_Question2, opandEd.getQuestion1());
 		values.put(DatabaseHandler.KEY_Question3, opandEd.getQuestion1());
 		values.put(DatabaseHandler.KEY_Question4, opandEd.getQuestion1());

 		values.put(DatabaseHandler.KEY_Image, opandEd.getImage());
 		values.put(DatabaseHandler.KEY_Level, opandEd.getLevel());

 		// Inserting Row
 		long insertid = dataBase.insert(DatabaseHandler.TABLE_AnimeOPandEd, null, values);
 		
 	opandEd.setID(insertid);
 	//	ddbHelperb.close(); // Closing database connection
 return opandEd;
 	}
 	
 // Getting All anime
 	public List<AnimeOpAndEdData> getAllAnimeOpAndEd() {

 		List<AnimeOpAndEdData> animeOpandEdList = new ArrayList<AnimeOpAndEdData>();
 		// Select All Query
 		//String selectQuery = "SELECT  * FROM " + TABLE_AnimeOPandEd;

 		//SQLiteDatabase db = this.getWritableDatabase();
		 Toast.makeText(mContext,"list animeOP WORKING", Toast.LENGTH_LONG).show();

 		
 		
 		Cursor cursor = dataBase.query(DatabaseHandler.TABLE_AnimeOPandEd, allcolumns, null, null, null, null, null);

 		Log.i("getAllAnimeOpandEd", "Found" + cursor.getCount() + "Songs");
 		// looping through all rows and adding to list
 		if (cursor.moveToFirst()) {
 			do {

 				AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();
 				animeOpandEd.setID(cursor.getLong(cursor.getColumnIndex(DatabaseHandler.KEY_ID)));
 				animeOpandEd.setName(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_NAME)));
 				animeOpandEd.setSong(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Song)));
 				animeOpandEd.setArtist(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Artist)));
 				animeOpandEd.setMusic(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Music)));
 				animeOpandEd.setYoutube(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Youtube)));
 				animeOpandEd.setAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Answer)));
 				animeOpandEd.setQuestion1(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Question1)));
 				animeOpandEd.setQuestion2(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Question2)));
 				animeOpandEd.setQuestion3(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Question3)));
 				animeOpandEd.setQuestion4(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Question4)));
 				animeOpandEd.SetImage((cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Image))));
 				animeOpandEd.SetLevel(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Level)));

 				// Adding contact to list
 				animeOpandEdList.add(animeOpandEd);
 			} while (cursor.moveToNext());
 		}
 		
 		// return contact list
 		return animeOpandEdList;

 	}
 	
 	
 	
 	
 	
}
