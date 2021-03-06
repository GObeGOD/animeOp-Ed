package model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AnimeOpandEdDataSource {

	DatabaseHandler dbHelper;
	SQLiteDatabase dataBase;
	Context mContext;
	String userGrade;

	public AnimeOpandEdDataSource(Context context) {
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

	public static final String[] allcolumns = {

	DatabaseHandler.KEY_ID, DatabaseHandler.KEY_NAME, DatabaseHandler.KEY_SONG,
			DatabaseHandler.KEY_ARTIST, DatabaseHandler.KEY_MUSIC,
			DatabaseHandler.KEY_YOUTUBE, DatabaseHandler.KEY_ANSWER,
			DatabaseHandler.KEY_QUESTION1, DatabaseHandler.KEY_QUESTION2,
			DatabaseHandler.KEY_QUESTION3, DatabaseHandler.KEY_QUESTION4,
			DatabaseHandler.KEY_IMAGE, DatabaseHandler.KEY_LEVEL,
			DatabaseHandler.KEY_COMPLETE,DatabaseHandler.KEY_ATTEMPTS

	};

	// Adding new Anime music
	public AnimeOpAndEdData addAnimeOPandED(AnimeOpAndEdData opandEd) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DatabaseHandler.KEY_NAME, opandEd.getName()); // anime Name
		values.put(DatabaseHandler.KEY_SONG, opandEd.getSong()); // anime song

		values.put(DatabaseHandler.KEY_ARTIST, opandEd.getArtist());
		values.put(DatabaseHandler.KEY_MUSIC, opandEd.getMusic());

		values.put(DatabaseHandler.KEY_YOUTUBE, opandEd.getYoutube());
		values.put(DatabaseHandler.KEY_ANSWER, opandEd.getAnswer());

		values.put(DatabaseHandler.KEY_QUESTION1, opandEd.getQuestion1());
		values.put(DatabaseHandler.KEY_QUESTION2, opandEd.getQuestion2());
		values.put(DatabaseHandler.KEY_QUESTION3, opandEd.getQuestion3());
		values.put(DatabaseHandler.KEY_QUESTION4, opandEd.getQuestion4());

		values.put(DatabaseHandler.KEY_IMAGE, opandEd.getImage());
		values.put(DatabaseHandler.KEY_LEVEL, opandEd.getLevel());
		values.put(DatabaseHandler.KEY_COMPLETE, opandEd.getComplete());
		values.put(DatabaseHandler.KEY_ATTEMPTS, opandEd.getAttempts());


		Log.i("you you ", "art :" + opandEd.getArtist() );
		// Inserting Row
		long insertid = dataBase.insert(DatabaseHandler.TABLE_AnimeOPandEd,
				null, values);

		opandEd.setID(insertid);
		// ddbHelperb.close(); // Closing database connection
		return opandEd;
	}

	public List<AnimeOpAndEdData> getAllAnimeOpAndEd() {

		// Toast.makeText(mContext,"list animeOP WORKING",
		// Toast.LENGTH_LONG).show();

		Cursor cursor = dataBase.query(DatabaseHandler.TABLE_AnimeOPandEd,
				allcolumns, null, null, null, null, null);
		Log.i("getAllAnimeOpandEd", "Found" + cursor.getCount() + "Songs");

		List<AnimeOpAndEdData> animeOpandEdList = cursorToList(cursor);

		// return contact list
		return animeOpandEdList;

	}

	// Getting All anime
	public int getCountByLevel(String[] levelSelection) {

		// Toast.makeText(mContext,"list animeOP WORKING",
		// Toast.LENGTH_LONG).show();

		Cursor cursor = dataBase.query(DatabaseHandler.TABLE_AnimeOPandEd,
				allcolumns, "level = ?", levelSelection, null, null, null);
		Log.i("getAllAnimeOpandEd", "Found" + cursor.getCount() + "Songs");

		// return contact list
		return cursor.getCount();

	}

	public List<AnimeOpAndEdData> listByLevel(String[] levelSelection) {

		// Toast.makeText(mContext,"listByLevel animeOP WORKING",
		// Toast.LENGTH_LONG).show();

		Cursor cursor = dataBase.query(DatabaseHandler.TABLE_AnimeOPandEd,
				allcolumns, "level = ?", levelSelection, null, null, null);
		Log.i("LISTBYLEVEL", "Found " + cursor.getCount() + " Songs");
		List<AnimeOpAndEdData> animeOpandEdList = cursorToList(cursor);

		// return contact list
		return animeOpandEdList;

	}
	
	

	public AnimeOpAndEdData getAnimeBYSongName(String[] songName) {

		Cursor cursor = dataBase.query(DatabaseHandler.TABLE_AnimeOPandEd,
				allcolumns, "song = ?", songName, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();

		animeOpandEd.setID(cursor.getLong(cursor
				.getColumnIndex(DatabaseHandler.KEY_ID)));
		animeOpandEd.setName(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_NAME)));
		animeOpandEd.setSong(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_SONG)));
		animeOpandEd.setArtist(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_ARTIST)));
		animeOpandEd.setMusic(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_MUSIC)));
		animeOpandEd.setYoutube(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_YOUTUBE)));
		animeOpandEd.setAnswer(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_ANSWER)));
		animeOpandEd.setQuestion1(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION1)));
		animeOpandEd.setQuestion2(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION2)));
		animeOpandEd.setQuestion3(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION3)));
		animeOpandEd.setQuestion4(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION4)));
		animeOpandEd.SetImage((cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_IMAGE))));
		animeOpandEd.SetLevel(cursor.getInt(cursor
				.getColumnIndex(DatabaseHandler.KEY_LEVEL)));
		animeOpandEd.SetComplete(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_COMPLETE)));
		animeOpandEd.SetAttempts(cursor.getInt(cursor
				.getColumnIndex(DatabaseHandler.KEY_ATTEMPTS)));
		

		Log.i("anime datasource", "aritist yo" + animeOpandEd.getArtist() );
		return animeOpandEd;

	}
	
	public AnimeOpAndEdData getAnimeBYID(int id) {

		Cursor cursor = dataBase.query(DatabaseHandler.TABLE_AnimeOPandEd,
				allcolumns, "id = ?", new String[] { String.valueOf(id) } , null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();

		animeOpandEd.setID(cursor.getLong(cursor
				.getColumnIndex(DatabaseHandler.KEY_ID)));
		animeOpandEd.setName(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_NAME)));
		animeOpandEd.setSong(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_SONG)));
		animeOpandEd.setArtist(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_ARTIST)));
		animeOpandEd.setMusic(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_MUSIC)));
		animeOpandEd.setYoutube(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_YOUTUBE)));
		animeOpandEd.setAnswer(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_ANSWER)));
		animeOpandEd.setQuestion1(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION1)));
		animeOpandEd.setQuestion2(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION2)));
		animeOpandEd.setQuestion3(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION3)));
		animeOpandEd.setQuestion4(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_QUESTION4)));
		animeOpandEd.SetImage((cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_IMAGE))));
		animeOpandEd.SetLevel(cursor.getInt(cursor
				.getColumnIndex(DatabaseHandler.KEY_LEVEL)));
		animeOpandEd.SetComplete(cursor.getString(cursor
				.getColumnIndex(DatabaseHandler.KEY_COMPLETE)));
		animeOpandEd.SetAttempts(cursor.getInt(cursor
				.getColumnIndex(DatabaseHandler.KEY_ATTEMPTS)));

		return animeOpandEd;

	}

	public List<AnimeOpAndEdData> cursorToList(Cursor cursor) {
		List<AnimeOpAndEdData> animeOpandEdList = new ArrayList<AnimeOpAndEdData>();
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				AnimeOpAndEdData animeOpandEd = new AnimeOpAndEdData();
				animeOpandEd.setID(cursor.getLong(cursor
						.getColumnIndex(DatabaseHandler.KEY_ID)));
				animeOpandEd.setName(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_NAME)));
				animeOpandEd.setSong(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_SONG)));
				animeOpandEd.setArtist(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_ARTIST)));
				animeOpandEd.setMusic(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_MUSIC)));
				animeOpandEd.setYoutube(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_YOUTUBE)));
				animeOpandEd.setAnswer(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_ANSWER)));
				animeOpandEd.setQuestion1(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_QUESTION1)));
				animeOpandEd.setQuestion2(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_QUESTION2)));
				animeOpandEd.setQuestion3(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_QUESTION3)));
				animeOpandEd.setQuestion4(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_QUESTION4)));
				animeOpandEd.SetImage((cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_IMAGE))));
				animeOpandEd.SetLevel(cursor.getInt(cursor
						.getColumnIndex(DatabaseHandler.KEY_LEVEL)));
				animeOpandEd.SetComplete(cursor.getString(cursor
						.getColumnIndex(DatabaseHandler.KEY_COMPLETE)));
				animeOpandEd.SetAttempts(cursor.getInt(cursor
						.getColumnIndex(DatabaseHandler.KEY_ATTEMPTS)));

				// Adding contact to list
				animeOpandEdList.add(animeOpandEd);
			} while (cursor.moveToNext());
		}
		return animeOpandEdList;

	}

	/*public void updateAnime(AnimeOpAndEdData opandEd, String complete) {
		ContentValues values = new ContentValues();

		values.put(DatabaseHandler.KEY_COMPLETE, complete); // anime
															// Name
		dataBase.update(DatabaseHandler.TABLE_AnimeOPandEd, values,
				"complete = ?", new String[] { complete});
		Log.i("UpdateAnime", "complete: " + complete);


	}*/
	public void updateAnime(AnimeOpAndEdData opandEd, String complete) {
		long id = opandEd.getID();
		ContentValues contentVal = new ContentValues();
		contentVal.put("complete", complete);

		
		
		dataBase.update(DatabaseHandler.TABLE_AnimeOPandEd, contentVal, DatabaseHandler.KEY_ID + " = " + id, null);
		
		Log.i("updateTodo", "Updated Todo");

	}

	public void updateAnimeAttempts(AnimeOpAndEdData opandEd, int attempts) {
		long id = opandEd.getID();
		ContentValues contentVal = new ContentValues();
		contentVal.put("attempts", attempts);

		
		
		dataBase.update(DatabaseHandler.TABLE_AnimeOPandEd, contentVal, DatabaseHandler.KEY_ID + " = " + id, null);
		
		Log.i("updateTodo", "Updated Todo");

	}

	public String userGrade(int Attempts) {
	
		if (Attempts == 0)
			userGrade = "S";

		else if (Attempts <= 4)
			userGrade = "A";

		else if (Attempts <= 8)
			userGrade = "B";
		
		else if (Attempts <= 12)
			userGrade = "C";
		
		else if (Attempts <= 16)
			userGrade = "D";
		
		else
			userGrade = "F";

		return userGrade;
		
		
	}

}
