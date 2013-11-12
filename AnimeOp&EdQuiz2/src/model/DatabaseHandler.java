package model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	 // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "AnimeOpandEdManager";
 
    // Contacts table name
    private static final String TABLE_AnimeOPandEd = "AnimeOPandEd";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_Song = "song";
    private static final String KEY_Artist = "artist";
    private static final String KEY_Music = "music";
    private static final String KEY_Youtube = "youtube";
    private static final String KEY_Answer = "answer";
    private static final String KEY_Question1 = "Question1";
    private static final String KEY_Question2 = "Question2";
    private static final String KEY_Question3 = "Question3";
    private static final String KEY_Question4 = "Question4";
    private static final String KEY_Image = "image";
    private static final String KEY_Level = "level";
    
    
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION );
		// TODO Auto-generated constructor stub
		 
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("creating DB");
		String CREAT_ANIMEOPANDED_TABLE = "CREATE TABLE " + TABLE_AnimeOPandEd + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," 
		                                                                             + KEY_Song + " TEXT" + KEY_Artist + " TEXT" + KEY_Music + " TEXT"
		                                                                             + KEY_Youtube + " TEXT" + KEY_Answer + " TEXT" + KEY_Question1 + " TEXT" 
		                                                                             + KEY_Question2 + " TEXT" +KEY_Question3 + " TEXT" + KEY_Question4 + " TEXT"
		                                                                             + KEY_Image + " TEXT" + KEY_Level + " TEXT" +")";          
		
        db.execSQL(CREAT_ANIMEOPANDED_TABLE);
        
		
	}
	
	// Adding new Anime music
	public void addAnimeOPandED( AnimeOpAndEdData opandEd) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NAME, opandEd.getName()); // anime Name
	    values.put(KEY_Song, opandEd.getSong()); // anime song
	    
	 
	    // Inserting Row
	    db.insert(TABLE_AnimeOPandEd, null, values);
	    db.close(); // Closing database connection
		
	}
	 
	// Getting single Anime music
	/*public AnimeOpAndEdData  getAnimeOPandEnd(int id) {
		 SQLiteDatabase db = this.getReadableDatabase();
		 
		    Cursor cursor = db.query(TABLE_AnimeOPandEd, new String[] { KEY_ID, KEY_NAME, KEY_Song }, KEY_ID + "=?",  new String[] { String.valueOf(id) }, null, null, null, null);
		    if (cursor != null)
		        cursor.moveToFirst();
		 
		//    AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData(Integer.parseInt(cursor.getString(0)),
		 //           cursor.getString(1), cursor.getString(2));
		    // return contact
		return animeOpandEd;
	}
	 */
	// Getting All anime 
	public List<AnimeOpAndEdData> getAllAnimeOpAndEd() {
		
		 List<AnimeOpAndEdData> animeOpandEdList = new ArrayList<AnimeOpAndEdData>();
		    // Select All Query
		    String selectQuery = "SELECT  * FROM " + TABLE_AnimeOPandEd;
		 
		    SQLiteDatabase db = this.getWritableDatabase();
		    Cursor cursor = db.rawQuery(selectQuery, null);
		 
		    // looping through all rows and adding to list
		    if (cursor.moveToFirst()) {
		        do {
		        	AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();
		        	animeOpandEd.setID(Integer.parseInt(cursor.getString(0)));
		        	animeOpandEd.setName(cursor.getString(1));
		        	animeOpandEd.setSong(cursor.getString(2));
		            // Adding contact to list
		            animeOpandEdList.add(animeOpandEd);
		        } while (cursor.moveToNext());
		    }
		 
		    // return contact list
		    return animeOpandEdList;
		
		
	}
	
	// Getting All Anime from level
		public List<AnimeOpAndEdData> getAnimeOpAndEdlevel(String level) {
			
			 List<AnimeOpAndEdData> animeOpandEdList = new ArrayList<AnimeOpAndEdData>();
			    // Select All Query
			    String selectQuery = "SELECT  * FROM  " + TABLE_AnimeOPandEd + "WHERE" + KEY_NAME + "="+ level ;
			 //   String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "
			//            + KEY_ID + " = " + todo_id;
			    SQLiteDatabase db = this.getWritableDatabase();
			    Cursor cursor = db.rawQuery(selectQuery, null);
			 
			    // looping through all rows and adding to list
			    if (cursor.moveToFirst()) {
			        do {
			        	AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();
			        	animeOpandEd.setID(Integer.parseInt(cursor.getString(0)));
			        	animeOpandEd.setName(cursor.getString(1));
			        	animeOpandEd.setSong(cursor.getString(2));
			            // Adding contact to list
			            animeOpandEdList.add(animeOpandEd);
			        } while (cursor.moveToNext());
			    }
			 
			    // return contact list
			    return animeOpandEdList;
			
			
		}
	 
	// Getting AnimeOPandEd  level count Count
	public int getAnimeOpandEDCount(String level ) {
		   String countQuery = "SELECT  * FROM " + TABLE_AnimeOPandEd ;
       System.out.println(countQuery);
	      // String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE " + KEY_ID + " = " + todo_id;
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.rawQuery(countQuery, null);
	        cursor.close();
	 
	        // return count
	        return cursor.getCount();
		
	}
	// Updating single anime op/ed
	public int updateContact(AnimeOpAndEdData animeOpandED) {
		  SQLiteDatabase db = this.getWritableDatabase();
		  
		    ContentValues values = new ContentValues();
		    values.put(KEY_NAME, animeOpandED.getName());
		    values.put(KEY_Song, animeOpandED.getSong());
		 
		    // updating row
		    return db.update(TABLE_AnimeOPandEd, values, KEY_ID + " = ?",
		            new String[] { String.valueOf(animeOpandED.getID()) });
		
		
		
	}
	 
	// Deleting single contact
	public void deleteContact(AnimeOpAndEdData animeOpandED) {
		 SQLiteDatabase db = this.getWritableDatabase();
		    db.delete(TABLE_AnimeOPandEd, KEY_ID + " = ?",
		            new String[] { String.valueOf(animeOpandED.getID()) });
		    db.close();
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AnimeOPandEd);
 
        // Create tables again
        onCreate(db);
	}

}
