package com.gobi.animeopedquiz2;

import java.util.List;

import model.AnimeOpAndEdData;
import model.AnimeOpandEdDataSource;
import model.BaseActivity;
import model.ImageGridAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;


public class MusicSelection extends BaseActivity {
	public final static String EXTRA_MESSAGE = "com.example.animeopedquiz2.MESSAGE";

	public enum Levels {
		level1, level2, level3, level4
	};

	GridView gridView;
	public String levelname;
	AnimeOpandEdDataSource dataSource;
	Levels levels;
	ImageGridAdapter adapter;
	int levelInt;
	List<AnimeOpAndEdData> animeOPandEd;
	int totalLevelAttempts;
	String userGrade;



	public String[] numbers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_selection);
		// Get the level from the intent
		Intent intent = getIntent();
		String level = intent.getStringExtra("levelId");

		
		System.out.println("here is the level the user clicked " + level);
		levelname = level;
		//setTitle("My new title");
		//DatabaseHandler dbHelper =  new DatabaseHandler(this);

	/*	if(dbHelper.isTableExists(DatabaseHandler.TABLE_AnimeOPandEd)){
			Log.i("isTableExists ", "TABLE EXISTS!!!" );
		}else{
			Log.i("isTableExists ", "TABLE DOES NOT EXISTS!!!" );

			
		}*/
		dataSource = new AnimeOpandEdDataSource(this);
		dataSource.open();
		
 
		
		String[] parts = level.split("_");
		// String levelString = parts[0]; // level
		String levelNum = parts[1]; // 1
		levelInt = Integer.parseInt(levelNum);
		insertLevel(levelInt);
		String[] bylevel = { Integer.toString(levelInt) };

		animeOPandEd = dataSource.listByLevel(bylevel);
		 totalLevelAttempts = 0;

	for (int i = 0; i < animeOPandEd.size(); i++){
		totalLevelAttempts += animeOPandEd.get(i).getAttempts();
		Log.i("LLLLLL ", "index of " +  animeOPandEd.get(i).getAnswer());

		Log.i("LLLLLLL",""+ animeOPandEd.get(i).getAttempts());

		
	}
	Log.i("YOOOOOOOO",  "totalLevelAttempts: " + totalLevelAttempts);

	userGrade = dataSource.userGrade(totalLevelAttempts);
	setTitle("Level "+ levelInt );
		//Log.i("LLLLLL ", "index of " +  animeOPandEd.get(1).getAnswer());

	Log.i("USERGRADE",  "userGrade: " + userGrade );

		 gridView = (GridView) findViewById(R.id.gridView1);
		 adapter = new ImageGridAdapter(this, levelInt);
		// Instance of ImageAdapter Class and Send Level
		gridView.setAdapter(adapter);
		


	}
	
	
	@Override
	//menu item  for user grade
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		
		  int positionOfMenuItem = 0; 

		 
		   MenuItem item = menu.getItem(positionOfMenuItem);
	
		   if (userGrade == "S")
				item.setIcon(getResources().getDrawable(R.drawable.rank_s));
			else if (userGrade == "A")
				item.setIcon(getResources().getDrawable(R.drawable.rank_a));
			else if (userGrade == "B")
				item.setIcon(getResources().getDrawable(R.drawable.rank_b));
			else if (userGrade == "C")
				item.setIcon(getResources().getDrawable(R.drawable.rank_c));
			else if (userGrade == "D")
				item.setIcon(getResources().getDrawable(R.drawable.rank_d));
			else if (userGrade == "F")
				item.setIcon(getResources().getDrawable(R.drawable.rank_f));
		
		return super.onCreateOptionsMenu(menu);
		
	}
	
	
	
	@Override
	//menu item  for user grade refresh 
	public boolean onPrepareOptionsMenu(Menu menu) {
	    menu.clear();
	 //   menu.add(0, 2, 0, userGrade).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
	    int positionOfMenuItem = 0; 

    MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
	    MenuItem item = menu.getItem(positionOfMenuItem);

		   item.setIcon(getResources().getDrawable(R.drawable.rank_a));

		   if (userGrade == "S")
				item.setIcon(getResources().getDrawable(R.drawable.rank_s));
			else if (userGrade == "A")
				item.setIcon(getResources().getDrawable(R.drawable.rank_a));
			else if (userGrade == "B")
				item.setIcon(getResources().getDrawable(R.drawable.rank_b));
			else if (userGrade == "C")
				item.setIcon(getResources().getDrawable(R.drawable.rank_c));
			else if (userGrade == "D")
				item.setIcon(getResources().getDrawable(R.drawable.rank_d));
			else if (userGrade == "F")
			item.setIcon(getResources().getDrawable(R.drawable.rank_f));
			
			
	    return super.onPrepareOptionsMenu(menu);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	public void gridItemtapped(View v) {
		System.out.println(v.getContentDescription());
		// Toast.makeText(getApplicationContext(),v.getId(),
		// Toast.LENGTH_SHORT).show();
		String name = (String) v.getContentDescription();
		invalidateOptionsMenu();

		changeAct(name);
		Log.i("ridItemtapped", "GRID ITEM TAPPED ID: "+ v.getId() );

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void insertLevel(int level) {
		// Log.e("insertLevel", "LEVEL CHOOSEN: " + level);

		switch (level) {
		case 1:
			Log.e("insertLevel", "LEVEL 1!!!!");
			String[] bylevel = { Integer.toString(level) };

			if (dataSource.getCountByLevel(bylevel) == 0) {

	dataSource.addAnimeOPandED(new AnimeOpAndEdData("Fullmetal Alchemist: Brotherhood", "Period", "Chemistry", "fullmetalbrotherhood_op4_period", "https://www.youtube.com/watch?v=rrnoawLBidA", "Fullmetal Alchemist: Brotherhood", "Fullmetal Alchemist: Brotherhood", "D.Gray-man", "Blood+", "Claymore", "fullmetalalchemist_img", 1, "no",0));
	dataSource.addAnimeOPandED(new AnimeOpAndEdData("Bleach", "CHU-BURA", "Kelun", "bleach_op8_chubura", "https://www.youtube.com/watch?v=xno85wo43o8", "Bleach", "Bleach", "Gintama", "Naruto", "Hunter x Hunter", "bleach_img", 1, "no",0));
	dataSource.addAnimeOPandED(new AnimeOpAndEdData("Gatchaman Crowds", "Crowds", "WHITE ASH", "gatchamancrowds_op1_crowds", "https://www.youtube.com/watch?v=_rjgqU34B3s", "Gatchaman Crowds", "Gatchaman Crowds", "Tiger & Bunny", "Zetman", "Durarara!!", "gatchamancrowds_img", 1, "no",0));
	dataSource.addAnimeOPandED(new AnimeOpAndEdData("Psycho-Pass", "Out of Control", "Nothing's Carved in Stone", "pshychopass_op2_outofcontrol", "https://www.youtube.com/watch?v=U45g-XbI_qw", "Psycho-Pass", "Psycho-Pass", "Ergo Proxy", "Code:Breaker", "Fullmetal Alchemist: Brotherhood", "psychopass_img", 1, "no",0));
	dataSource.addAnimeOPandED(new AnimeOpAndEdData("Kuroko no Basket 2nd Season", "The Other self", "GRANRODEO", "kurokonobasket2nd_theotherself", "https://www.youtube.com/watch?v=qcF4Bjr-kIk", "Kuroko no Basket 2nd Season", "Kuroko no Basket 2nd Season", "Free!", "Tsuritama", "Prince of Tennis", "kurokonobasket_img", 1, "no",0));
	dataSource.addAnimeOPandED(new AnimeOpAndEdData("Kakumeiki Valvrave", "Preserved Roses", "T.M.Revolution", "kakumeikivalvrave_op1_preservedroses", "https://www.youtube.com/watch?v=n7QmXJ-gff0", "Kakumeiki Valvrave", "Kakumeiki Valvrave", "Mobile Suit Gundam Seed", "Suisei no Gargantia", "D.Gray-man", "kakumeikivalvrave_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Naruto", "Kanashimi wo Yasashisa ni", "little by little", "naruto_op3_kanashimiwoyasashisani", "https://www.youtube.com/watch?v=bAO8zTYhqsk", "Naruto", "Naruto", "InuYasha", "Ranma ½", "Fairy Tail", "naruto_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("InuYasha", "Fukai Mori", "Do As Infinity", "inuyasha_ed2_fukaimori", "https://www.youtube.com/watch?v=LBCljICdK-Q", "InuYasha", "InuYasha", "Rurouni Kenshin", "Trigun", "Trinity Blood", "inuyasha_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Attack on Titan", "great escape", "Cinema Staff", "attackontitan_ed2_greatescape", "https://www.youtube.com/watch?v=sjKxEpeew_c", "Attack on Titan", "Attack on Titan", "Claymore", "Fullmetal Alchemist: Brotherhood", "Highschool of the Dead", "attackontitan_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Fate/zero", "MEMORIA", "Aoi Eir", "fatezero_ed2_memoria", "https://www.youtube.com/watch?v=Tph0uWcjQNc", "Fate/zero", "Fate/zero", "Mahou Shoujo Madoka★Magica", "Magi: The Labyrinth of Magic", "Fullmetal Alchemist: Brotherhood", "fatezero_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Sword Art Online", "crossing field", "LiSA", "swordartonline_op1_crossingfield", "https://www.youtube.com/watch?v=LcIS91O7Joo", "Sword Art Online", "Sword Art Online", "Guilty Crown", "Fate/Zero", "Angel Beats!", "swordartonline_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Gintama’", "Tougenkyou Alien", "serial TV drama", "gintama_op1_tougenkyoualien", "https://www.youtube.com/watch?v=ICOL2whRTSM", "Gintama’", "Gintama’", "SKET Dance", "School Rumble", "Bleach", "gintama_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Mahou Shoujo Madoka★Magica", "Magia", "Kalafina", "mahoushoujomadoka_ed2_magia", "https://www.youtube.com/watch?v=_Eb4ONZw01Y", "Mahou Shoujo Madoka★Magica", "Mahou Shoujo Madoka★Magica", "Steins;Gate", "Higurashi no Naku Koro ni", "Mawaru Penguindrum", "mahoushoujomadoka_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Steins;Gate", "Hacking to the Gate", "Kanako Itou", "steinsgate_op1_hackingtothegate", "https://www.youtube.com/watch?v=sJEGb4MPV6I", "Steins;Gate", "Steins;Gate", "ChäoS;HEAd", "Another", "Kokoro Connect", "steinsgate_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Black Butler", "Kiss of Monochrome", "SID", "blackbutler_op1_kissofmonochrome", "https://www.youtube.com/watch?v=oihy_0oC-yE", "Black Butler", "Black Butler", "Code Geass: Lelouch of the Rebellion", "Gankutsuou", "Kaze no Stigma", "blackbutler_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("The Melancholy of Haruhi Suzumiya", "Bouken Desho Desho?", "Aya Hirano", "haruhisuzumiya_op1_bouken", "https://www.youtube.com/watch?v=WrMwo8PbjoE", "The Melancholy of Haruhi Suzumiya", "The Melancholy of Haruhi Suzumiya", "Lucky☆Star", "Nura: Rise of the Yokai Clan", "School Rumble", "haruhisuzumiya_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Great Teacher Onizuka", "Hitori no Yoru", "Porno Graffitti", "greatteacheronizuka_op2_hitorinoyoru", "https://www.youtube.com/watch?v=kDh3D2ewiNs", "Great Teacher Onizuka", "Great Teacher Onizuka", "Magi - The Labyrinth of Magic", "Bleach", "Hajime no Ippo", "greatteacheronizuka_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Nichijou", "Hyadain no Kakakata☆Kataomoi - C", "Hyadain (Kenichi Maeyamada)", "nichijou_op1_hyadain", "https://www.youtube.com/watch?v=YfF7HqZm_vA", "Nichijou", "Nichijou", "Lucky☆Star", "Paniponi Dash!", "Mitsudomoe", "nichijou_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Magi: The Labyrinth of Magic", "V.I.P", "SID", "magithelabyrinthofmagic_op1_vip", "https://www.youtube.com/watch?v=mvFov-2-ZMw", "Magi: The Labyrinth of Magic", "Magi: The Labyrinth of Magic", "Hunter x Hunter (2011)", "Fairy Tail", "Log Horizon", "magithelabyrinthofmagic_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Hajime no Ippo: New Challenger", "Hekireki", "Last Alliance", "hajimenoippo_op1_hekireki", "https://www.youtube.com/watch?v=baFzdQiv6Gs", "Hajime no Ippo: New Challenger", "Hajime no Ippo: New Challenger", "Slam Dunk", "Rainbow: Nisha Rokubou no Shichinin", "Full Metal Panic!", "hajimenoippo_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Code Geass: Lelouch of the Rebellion", "COLORS", "FLOW", "codegeass_op1_colors", "https://www.youtube.com/watch?v=lD4_2Dl4r2s", "Code Geass: Lelouch of the Rebellion", "Code Geass: Lelouch of the Rebellion", "Mobile Suit Gundam 00", "Tengen Toppa Gurren Lagann", "Eureka Seven", "codegeass_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Major S3", "Play The Game", "Road of Major", "majors3_op1_playthegame", "https://www.youtube.com/watch?v=si_CZAagNdA", "Major S3", "Major S3", "Prince of Tennis", "Cross Game", "Ookiku Furikabutte", "majors3_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Mushishi", "The Sore Feet Song", "Ally Kerr", "mushishi_op1_thesorefeetsong", "https://www.youtube.com/watch?v=AapZE-LHUdI", "Mushishi", "Mushishi", "Kino's Journey", "Hotarubi no Mori e", "Spice and Wolf", "mushishi_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Fairy Tail", "Snow fairy", "FUNKIST", "fairytail_op1_snowfairy", " https://www.youtube.com/watch?v=tdrGjixAtKU", "Fairy Tail", "Fairy Tail", "One Piece", "Naruto", "Bleach", "fairytail_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("One Piece", "Hands Up!", "Kouta Shinzato", "onepiece_op16_handsup", "https://www.youtube.com/watch?v=3wSvrBxzX4o", "One Piece", "One Piece", "Toriko", "The Law of Ueki", "Blue Exorcist", "onepiece_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("Jormungand", "Borderland", "Mami Kawada", "jormungand_op1_borderland", "https://www.youtube.com/watch?v=uDhEtUl7U-A", "Jormungand", "Jormungand", "Black Lagoon ", "Phantom: Requiem for the Phantom", "Canaan", "jormungand_img", 1, "no",0));
    dataSource.addAnimeOPandED(new AnimeOpAndEdData("K-On!", "Cagayake! GIRLS", "Sakurakou Keion-bu (Aki Toyosaki, Yoko Hisaka, Satomi Satou, Minako Kotobuki)", "kon_op1_cagayakegirls", "https://www.youtube.com/watch?v=gnd1wSIyN-g", "K-On!", "K-On!", "Yuru Yuri", "Lucky☆Star", "Tamako Market", "kon_img", 1, "no",0));
   // dataSource.addAnimeOPandED(new AnimeOpAndEdData(name, song, artist, music, youtube, answer, question1, question2, question3, question4, image, level, complete))
   // dataSource.addAnimeOPandED(new AnimeOpAndEdData(name, song, artist, music, youtube, answer, question1, question2, question3, question4, image, level, complete))

			} else {
				Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

			}

			break;

		case 2:
			Log.e("insertLevel", "LEVEL 2!!!!");
			String[] bylevel2 = { Integer.toString(level) };

			if (dataSource.getCountByLevel(bylevel2) == 0) {
				Log.e("getCountByLevel", "ADDING LEVEL 1");
				//   dataSource.addAnimeOPandED(new AnimeOpAndEdData(name, song, artist, music, youtube, answer, question1, question2, question3, question4, image, 2, "no",0));

	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Neon Genesis Evangelion", "A Cruel Angel's Thesis", "Yoko Takahashi", "evangelion_op1_acruelangelsthesis", "https://www.youtube.com/watch?v=3nQNSLB3Lpk", "Neon Genesis Evangelion", "Neon Genesis Evangelion", "Mahou Shoujo Madoka★Magica", "Serial Experiments Lain", "Bokurano", "evangelion_img",2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("D.N.Angel", "Byakuya ~ True Light", "Miyamoto Shunichi", "dnangel_op1_byakuyatruelight", "https://www.youtube.com/watch?v=FKgNPqojzlM", "D.N.Angel", "D.N.Angel", "Magic Kaito", "Black Butler", "Gosick", "dnangel_img", 2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Berserk", "Tell Me Why", "PENPALS", "berserk_op1_tellmewhy", "https://www.youtube.com/watch?v=ocQ6PDiP014", "Berserk", "Berserk", "Gungrave", "Claymore", "Fist of the North Star", "berserk_img", 2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Ghost in the Shell: Stand Alone Complex", "Lithium Flower", "Scott Matthew","ghostintheshell_ed1_lithiumflower", "https://www.youtube.com/watch?v=XESreJjGx-I", "Ghost in the Shell: Stand Alone Complex", "Ghost in the Shell: Stand Alone Complex", "Ergo Proxy", "Psycho-Pass", "Darker than Black", "ghostintheshell_img", 2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Chobits", "Let Me Be With You", "ROUND TABLE feat. Nino", "chobits_op1_letmebewithyou", "https://www.youtube.com/watch?v=nXNJ-6qpU6c", "Chobits", "Chobits", "Sora no Otoshimono", "Love Hina", "Toradora!", "chobits_img", 2, "no",0));

	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Toradora!", "Pre-Parade", "Rie Kugimiya, Eri Kitamura, and Yui Horie", "toradora_op1_preparade", "https://www.youtube.com/watch?v=jBup5tTEWAA", "Toradora!", "Toradora!", "Lucky☆Star", "Lovely★Complex", "MM!", "toradora_img", 2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Guilty Crown", "My Dearest", "supercell; performed by Koeda", "guiltycrown_op1_mydearest", "https://www.youtube.com/watch?v=DjUtmbZt8zc", "Guilty Crown", "Guilty Crown", "Code Geass", "D.Gray-man", "Mirai Nikki", "guiltycrown_img", 2, "no",0));
       dataSource.addAnimeOPandED(new AnimeOpAndEdData("Welcome to the NHK", "Odoru aka-chan Ningen", "Kenji Ohtsuki", "welcometothenhk_ed_odoruakachanningen", "https://www.youtube.com/watch?v=ikFGCQJbHoM", "Welcome to the NHK ", "Welcome to the NHK ", "Sayonara Zetsubou Sensei", "ChäoS;HEAd","Paranoia Agent", "welcometothenhk_img", 2, "no",0));
       dataSource.addAnimeOPandED(new AnimeOpAndEdData("Baccano!", "Gun's & Roses", "Paradise Lunch", "baccano_op1_gunsandroses", "https://www.youtube.com/watch?v=Msg8ypnLqaw", "Baccano!", "Durarara!!", "Cowboy Bebop", "Baccano!", "Boogiepop Phantom", "baccano_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Angel Beats!", "My Soul, Your Beats!", "Lia", "angelbeats_op1_mysoulyourbeats", "https://www.youtube.com/watch?v=Gqxm--Wq82Y", "Angel Beats!", "Clannad", "Ano Hi Mita Hana no Namae wo Bokutachi wa Mada Shiranai.", "Angel Beats!", "Air", "angelbeats_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Dragon Ball Kai", "Dragon Soul", "Tanimoto Takeyoshi", "dragonballkai_op1_dragonsoul", "https://www.youtube.com/watch?v=tVNEcQ86Ekw", "Dragon Ball Kai", "Blue Dragon", "One Piece", "Dragon Ball Kai", "Tiger & Bunny", "dragonball_img", 2, "no",0));
		  dataSource.addAnimeOPandED(new AnimeOpAndEdData("Watashi ga Motenai no wa Dou Kangaetemo Omaera ga Warui!", "Watashi ga Motenai no wa Dou Kangaetemo Omaera ga Warui", "Konomi Suzuki n' Kiba of Akiba", "watashigamotenai_op1_watashigamotenai", "https://www.youtube.com/watch?v=HAIAXFQ0T74", "Watashi ga Motenai no wa Dou Kangaetemo Omaera ga Warui!", "Watashi ga Motenai no wa Dou Kangaetemo Omaera ga Warui!", "Yahari Ore no Seishun Love Comedy wa Machigatteiru.", "Oreimo", "The World God Only Knows", "watashigamotenai_img", 2, "no",0));

		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Trigun", "H.T.", "Tsuneo Imahori", "trigun_op1_ht", "https://www.youtube.com/watch?v=NzHe4U5c5Oc", "Trigun", "Trigun", "Blood+", "Trinity Blood", "Cowboy Bebop", "trigun_img", 2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("No Game No Life", "This game", "Konomi Suzuki", "nogamenolife_op1_thisgame", "https://www.youtube.com/watch?v=jRd9g-Uw50M", "No Game No Life", "No Game No Life", "Mondaiji-tachi ga Isekai kara Kuru Sou Desu yo?", "Sword Art Online", "Log Horizon", "nogamenolife_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Mondaiji-tachi ga Isekai kara Kuru Sou Desu yo?", "Black † White", "Iori Nomizu", "mondaijitachi_op1_blackwhite", "https://www.youtube.com/watch?v=ySn55tUVfxM", "Mondaiji-tachi ga Isekai kara Kuru Sou Desu yo?", "Mondaiji-tachi ga Isekai kara Kuru Sou Desu yo?", "Sword Art Online", "Hagure Yuusha no Estetica", "Blast of Tempest", "mondaijitachi_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Zetsuen no Tempest", "Spirit Inspiration", "Nothing's Carved In Stone", "zetsuennotempest_op1_spiritinspiration", "https://www.youtube.com/watch?v=xDi0LU9kvSY", "Zetsuen no Tempest", "Zetsuen no Tempest", "No.6", "Mawaru Penguindrum", "Nisemonogatari", "zetsuennotempest_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Higurashi no Naku Koro ni", "Higurashi no Naku Koro ni", "Eiko Shimamiya", "higurashi_op1_higurashi", "https://www.youtube.com/watch?v=nRtsIJXrhqc", "Higurashi no Naku Koro ni", "Higurashi no Naku Koro ni", "ChäoS;HEAd", "Ano Hi Mita Hana no Namae wo Bokutachi wa Mada Shiranai.", "Another", "higurashi_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Phantom: Requiem for the Phantom", "Jigoku no Mon /Gates of Hell", "ALI PROJECT", "requiemforthephantom_gatesofhell", "https://www.youtube.com/watch?v=yHLdQFQQXJw", "Phantom: Requiem for the Phantom", "Phantom: Requiem for the Phantom", "Another", "Jormungand", "Darker than Black", "requiemforthephantom_img", 2, "no",0));
	   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Clannad: After Story", "TORCH", "Lia", "clannad_ed1_torch", "https://www.youtube.com/watch?v=ti1NzYN2Enc", "Clannad: After Story", "Clannad: After Story", "Ano Hi Mita Hana no Namae wo Bokutachi wa Mada Shiranai.", "Angel Beats!", "Kanon (2006)", "clannad_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Hunter x Hunter (2011)", "Hunting For Your Dream", "Galneryus", "hunterxhunter_ed2_hfyd", "https://www.youtube.com/watch?v=aAPNRqJV3B8", "Hunter x Hunter (2011)", "Hunter x Hunter (2011)", "Magi: The Labyrinth of Magic", "One Piece", "Shaman King", "hunterxhunter_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Mirai Nikki ", "Kuusou Mesorogiwi", "Yousei Teikoku", "mirainikki_op1_kuusou", "https://www.youtube.com/watch?v=ql0NtjXIv_s", "Mirai Nikki", "Deadman Wonderland", "Death Note", "Mirai Nikki", "Steins;Gate", "mirainikki_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Kids on the Slope", "Sakamichi no Melody", "YUKI", "kidsontheslop_op1_sakamichi", "https://www.youtube.com/watch?v=HloKLU1SRJQ", "Kids on the Slope", "Kids on the Slope", "Chihayafuru", "Nodame Cantabile", "Tari Tari", "kidsontheslope_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Space Brothers", "Feel So Moon", "Unicorn", "spacebros_op1_feelsomoon", "https://www.youtube.com/watch?v=nS4d-KQ2QvE", "Space Brothers", "Space Brothers", "Planetes", "Usagi Drop", "The Legend of Black Heaven", "spacebros_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Kill la Kill", "ambiguous", "GARNiDELiA", "killlakill_op2_ambiguous", "https://www.youtube.com/watch?v=Lje03iQS84A", "Kill la Kill", "Kill la Kill", "Tengen Toppa Gurren Lagann", "Top wo Nerae! Gunbuster", "Sengoku Basara", "killlakill_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Gurren Lagann", "Sorairo Days", "Shoko Nakagawa", "gurrenlagann_op1_sorairo", "https://www.youtube.com/watch?v=C_t47BVtPuE", "Gurren Lagann", "Gurren Lagann", "Eureka Seven", "Code Geass: Hangyaku no Lelouch", "Naruto", "gurren_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Beck", "hit in the usa", "beat crusaders", "beck_op1_hitintheusa", "https://www.youtube.com/watch?v=p1URzwlqOL0", "Beck", "Beck", "Kids on the Slope", "Tsuritama", "Detroit Metal City", "beck_img", 2, "no",0));
		   dataSource.addAnimeOPandED(new AnimeOpAndEdData("Nana", "Rose", "Anna inspi' Nana ~Black Stones~", "nana_op1_rose", "https://www.youtube.com/watch?v=5kCbwVFwjM8", "Nana", "Nana", "Peach Girl", "Lovely★Complex", "Skip Beat!", "nana_img", 2, "no",0));

				

			} else {
				Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

			}

			break;

		case 3:

			Log.e("insertLevel", "LEVEL 3!!!!");
			String[] bylevel3 = { Integer.toString(level) };

			if (dataSource.getCountByLevel(bylevel3) == 0) {
				Log.e("getCountByLevel", "ADDING LEVEL 1");

				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "imagefun", 3,
						"no",0));

				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "imagefun", 3,
						"no",0));
				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "naruto", 3,
						"no",0));
				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "imagefun", 3,
						"no",0));
				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "naruto", 3,
						"no",0));
				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "imagefun", 3,
						"no",0));
				dataSource.addAnimeOPandED(new AnimeOpAndEdData("naruto", "go",
						"artist", "music", "youtube", "answer", "question1",
						"question2", "question3", "question4", "level4", 3,
						"no",0));

			} else {
				Log.e("InsertLevel", "LEVEL ALREADY INSERTED");

			}

			break;

		case 4:

			Log.e("insertLevel", "LEVEL 4!!!!");

			break;

		default:
			break;
		}

	}

	
	
	
	

	private void changeAct(String message) {
		Intent intent = new Intent(this, MusicPlayActivity.class);
		intent.putExtra(EXTRA_MESSAGE, message);
		//String levelintstring =String.valueOf(levelInt);

		intent.putExtra("levelNum", levelInt);

	   // finish();

		startActivity(intent);

	}

	@Override
	protected void onResume() {
		super.onResume();
		dataSource.open();
		Log.i("onResume", "onResume!!");

		adapter.loadData(this, levelInt);
		adapter.notifyDataSetChanged();
		String[] bylevel = { Integer.toString(levelInt) };
		animeOPandEd = dataSource.listByLevel(bylevel);
		// Log.i("LLLLLL ", "index of " + animeOPandEd.get(1).getAnswer());
		totalLevelAttempts = 0;

		for (int i = 0; i < animeOPandEd.size(); i++) {
			totalLevelAttempts += animeOPandEd.get(i).getAttempts();
			Log.i("LLLLLL ", "index of " + animeOPandEd.get(i).getAnswer());

			Log.i("LLLLLLL", "" + animeOPandEd.get(i).getAttempts());

		}
		Log.i("YOOOOOOOO", "totalLevelAttempts: " + totalLevelAttempts);
		userGrade = dataSource.userGrade(totalLevelAttempts);
		Log.i("USERGRADE", "userGrade: " + userGrade);
		setTitle("Level " + levelInt);

		invalidateOptionsMenu();

	}

	@Override
	protected void onPause() {
		super.onPause();
		dataSource.close();
	}

	
}
