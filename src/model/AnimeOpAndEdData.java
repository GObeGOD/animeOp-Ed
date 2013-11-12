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

    
    public AnimeOpAndEdData(){
    	
    }
    public AnimeOpAndEdData(int id, String name, String song){
    	this.id = id;
        this.name = name;
        this.song = song;
    }
    public AnimeOpAndEdData(String name, String song){
        this.name = name;
        this.song = song;
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

}
