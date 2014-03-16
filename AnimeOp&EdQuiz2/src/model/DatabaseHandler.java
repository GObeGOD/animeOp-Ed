package model;

import java.io.File;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	public static final String DATABASE_NAME = "AnimeOpandEdManager";

	// Contacts table name
	public static final String TABLE_AnimeOPandEd = "AnimeOPandEd";

	// Contacts Table Columns names
	public static final String KEY_ID = "id";
	public static final String KEY_NAME = "name";
	public static final String KEY_SONG = "song";
	public static final String KEY_ARTIST = "artist";
	public static final String KEY_MUSIC = "music";
	public static final String KEY_YOUTUBE = "youtube";
	public static final String KEY_ANSWER = "answer";
	public static final String KEY_QUESTION1 = "Question1";
	public static final String KEY_QUESTION2 = "Question2";
	public static final String KEY_QUESTION3 = "Question3";
	public static final String KEY_QUESTION4 = "Question4";
	public static final String KEY_IMAGE = "image";
	public static final String KEY_LEVEL = "level";
	public static final String KEY_COMPLETE = "complete";

	
	private static final String CREAT_ANIMEOPANDED_TABLE = 
			"CREATE TABLE " + TABLE_AnimeOPandEd + "(" + 
	         KEY_ID + " INTEGER PRIMARY KEY," + 
		     KEY_NAME + " TEXT," + 
	         KEY_SONG + " TEXT," + 
		     KEY_ARTIST + " TEXT," + 
	         KEY_MUSIC + " TEXT," + 
		     KEY_YOUTUBE + " TEXT," + 
	         KEY_ANSWER + " TEXT," + 
		     KEY_QUESTION1 + " TEXT," + 
	         KEY_QUESTION2 + " TEXT," + 
		     KEY_QUESTION3 + " TEXT," + 
	         KEY_QUESTION4 + " TEXT," + 
		     KEY_IMAGE + " TEXT," + 
	         KEY_LEVEL + " NUMERIC," + 
		     KEY_COMPLETE + " TEXT"+
		     ")";
	
	
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("creating DB");
		


		db.execSQL(CREAT_ANIMEOPANDED_TABLE);
		Log.i("DB created: ", CREAT_ANIMEOPANDED_TABLE);

	}




	public  boolean doesDatabaseExist(ContextWrapper context, String dbName) {
	    File dbFile=context.getDatabasePath(dbName);
	    return dbFile.exists();
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
