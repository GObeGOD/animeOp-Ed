package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	public static final String DATABASE_NAME = "AnimeOpandEdManager";

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
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("creating DB");
		String CREAT_ANIMEOPANDED_TABLE = "CREATE TABLE " + TABLE_AnimeOPandEd
				+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_Song + " TEXT," + KEY_Artist + " TEXT," + KEY_Music
				+ " TEXT," + KEY_Youtube + " TEXT," + KEY_Answer + " TEXT,"
				+ KEY_Question1 + " TEXT," + KEY_Question2 + " TEXT,"
				+ KEY_Question3 + " TEXT," + KEY_Question4 + " TEXT,"
				+ KEY_Image + " TEXT," + KEY_Level + " TEXT" + ")";

		Log.d("DB creating: ", CREAT_ANIMEOPANDED_TABLE);

		db.execSQL(CREAT_ANIMEOPANDED_TABLE);

	}

	// Adding new Anime music
	public void addAnimeOPandED(AnimeOpAndEdData opandEd) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, opandEd.getName()); // anime Name
		values.put(KEY_Song, opandEd.getSong()); // anime song

		values.put(KEY_Artist, opandEd.getArtist());
		values.put(KEY_Music, opandEd.getMusic());

		values.put(KEY_Youtube, opandEd.getYoutube());
		values.put(KEY_Answer, opandEd.getAnswer());

		values.put(KEY_Question1, opandEd.getQuestion1());
		values.put(KEY_Question2, opandEd.getQuestion1());
		values.put(KEY_Question3, opandEd.getQuestion1());
		values.put(KEY_Question4, opandEd.getQuestion1());

		values.put(KEY_Image, opandEd.getImage());
		values.put(KEY_Level, opandEd.getLevel());

		// Inserting Row
		db.insert(TABLE_AnimeOPandEd, null, values);
		db.close(); // Closing database connection

	}

	// Getting single Anime music
	/*
	 * public AnimeOpAndEdData getAnimeOPandEnd(int id) { SQLiteDatabase db =
	 * this.getReadableDatabase();
	 * 
	 * Cursor cursor = db.query(TABLE_AnimeOPandEd, new String[] { KEY_ID,
	 * KEY_NAME, KEY_Song }, KEY_ID + "=?", new String[] { String.valueOf(id) },
	 * null, null, null, null); if (cursor != null) cursor.moveToFirst();
	 * 
	 * // AnimeOpAndEdData animeOpandEd = new
	 * AnimeOpAndEdData(Integer.parseInt(cursor.getString(0)), //
	 * cursor.getString(1), cursor.getString(2)); // return contact return
	 * animeOpandEd; }
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
				animeOpandEd.setArtist((cursor.getString(3)));
				animeOpandEd.setMusic((cursor.getString(4)));
				animeOpandEd.setYoutube((cursor.getString(5)));
				animeOpandEd.setAnswer((cursor.getString(6)));
				animeOpandEd.setQuestion1((cursor.getString(7)));
				animeOpandEd.setQuestion2((cursor.getString(8)));
				animeOpandEd.setQuestion3((cursor.getString(9)));
				animeOpandEd.setQuestion4((cursor.getString(10)));
				animeOpandEd.SetImage((cursor.getString(11)));
				animeOpandEd.SetLevel((cursor.getString(12)));

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
		String selectQuery = "SELECT  * FROM  " + TABLE_AnimeOPandEd + " WHERE "
				+ KEY_NAME + " = " + "naruto";
		
		Log.d("getting all anime from level",  selectQuery);
		// String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "
		// + KEY_ID + " = " + todo_id;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();
				animeOpandEd.setID(Integer.parseInt(cursor.getString(0)));
				animeOpandEd.setName(cursor.getString(1));
				animeOpandEd.setSong(cursor.getString(2));
				animeOpandEd.setArtist((cursor.getString(3)));
				animeOpandEd.setMusic((cursor.getString(4)));
				animeOpandEd.setYoutube((cursor.getString(5)));
				animeOpandEd.setAnswer((cursor.getString(6)));
				animeOpandEd.setQuestion1((cursor.getString(7)));
				animeOpandEd.setQuestion2((cursor.getString(8)));
				animeOpandEd.setQuestion3((cursor.getString(9)));
				animeOpandEd.setQuestion4((cursor.getString(10)));
				animeOpandEd.SetImage((cursor.getString(11)));
				animeOpandEd.SetLevel((cursor.getString(12)));
				// Adding contact to list
				animeOpandEdList.add(animeOpandEd);
			} while (cursor.moveToNext());
		}

		// return contact list
		return animeOpandEdList;

	}

	// Getting AnimeOPandEd level count Count
	public int getAnimeOpandEDCount(String level) {
		
		
		String countQuery = "SELECT  * FROM " + TABLE_AnimeOPandEd;
		

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
		values.put(KEY_Artist, animeOpandED.getArtist());

		values.put(KEY_Music, animeOpandED.getMusic());

		values.put(KEY_Youtube, animeOpandED.getYoutube());
		values.put(KEY_Answer, animeOpandED.getAnswer());

		values.put(KEY_Question1, animeOpandED.getQuestion1());
		values.put(KEY_Question2, animeOpandED.getQuestion1());
		values.put(KEY_Question3, animeOpandED.getQuestion1());
		values.put(KEY_Question4, animeOpandED.getQuestion1());

		values.put(KEY_Image, animeOpandED.getImage());
		values.put(KEY_Level, animeOpandED.getLevel());

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
