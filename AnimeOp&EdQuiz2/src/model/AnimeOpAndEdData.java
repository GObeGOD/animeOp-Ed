package model;

public class AnimeOpAndEdData {
	int id;
    String name;
    String song;
    String artist;
    String music;
    String youtube;
    String answer;
    String question1;
    String question2;
    String question3;
    String question4;
    String image;
    String level;

    
    public AnimeOpAndEdData(){
    	
    }
    
    public AnimeOpAndEdData(String name, String song){
        this.name = name;
        this.song = song;
    }
    
   // making new animeOpandEd entry 
    //to0 much args 
    public AnimeOpAndEdData(int id, String name, String song, String artist
    							, String music, String youtube, String answer, String question1
    							, String question2,String question3,String question4,String image,String level){
    	this.id = id;
        this.name = name;
        this.artist = artist;
        this.music = music;
        this.youtube = youtube;
        this.answer = answer;
        
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.image = image;
        this.level = level;
        
    }
 
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getName(){
    	  return this.name;
    }
    
    public void setName(String name){
  	   this.name = name;
  }
    public String getSong(){
    	  return this.song;
    }
    
    public void setSong(String song){
  	   this.song = song;
  }
  
    
    public String getArtist(){
    	return this.answer;
    }
    
    public void setArtist(String artist){
   	   this.artist = artist;
   }
    
    public String getMusic(){
    	return this.answer;
    }
    public void setMusic(String music){
    	 this.music = music;
    }
    
    
    public String getYoutube(){
    	return this.answer;
    }
    
    public void setYoutube(String youtube){
    	 this.youtube = youtube;
    }
    
    public String getAnswer(){
    	return this.answer;
    }
    
    public void setAnswer(String answer){
    	 this.answer = answer;
    }
    
    
    public String getQuestion1(){
    	return this.question1;
    }
    public void setQuestion1(String question1){
    	this.question1 = question1;
    }
    
    public String getQuestion2(){
    	return this.question2;
    }
    
    public void setQuestion2(String question2){
    	this.question2 = question2;
    }
    public String getQuestion3(){
    	return this.question3;
    }
    public void setQuestion3(String question3){
    	this.question3 = question3;
    }
    public String getQuestion4(){
    	return this.question4;
    }
    
    public void setQuestion4(String question4){
    	this.question4 = question4;
    }
    public String getImage(){
    	return this.image;
    }
    
    public void SetImage(String image){
    	 this.image = image;
    }
    
    public String getLevel(){
    	return this.image;
    }
    
    public void SetLevel(String level){
    	 this.level = level;
    }

}
