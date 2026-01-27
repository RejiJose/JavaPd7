import java.io.IOException;
import java.sql.*;
/*
Use the chinook database to write the SQL statements to produce the info asked (using chinookDBdiagram.jpg to decide which tables contain the required info and their relationships)
*/
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() {

    String sql = "";
    String result ="";     
    Database db = new Database("jdbc:sqlite:chinook.db");		

    // Problem 1:
    // List the first 20 album titles with the name of the artist who produced the album.
    sql  = " Select albums.title, artists.name from albums ";
    sql += " Inner Join artists ";
    sql += " On albums.artistid = artists.artistid " ;
    sql += " Limit 20 ";
    
    result = db.runSQL(sql,"table-auto");
    // print(result);
    
    // Problem 2:
    // List the first 20 song(track) names that are of the following genres: Blues, Latin, Pop, Classical.
    sql  = " Select tracks.name from tracks ";
    sql += " Inner Join genres ";
    sql += " On tracks.genreId = genres.genreId ";
    sql += " Where genres.name in ('Blues', 'Latin', 'Pop','Classical') ";
    sql += " Limit 20 ";
    
    result = db.runSQL(sql,"table-auto");
    // print(result);
    
    // Problem 3:
    // List the first 20 song(track) names that are in the playlist 'Grunge'. 
    sql  = " Select tracks.name from tracks ";
    sql += " Inner Join playlist_track ";
    sql += " On playlist_track.trackId = tracks.trackId ";
    sql += " Inner Join playlists ";
    sql += " On playlist_track.playlistId = playlists.playlistId ";
    sql += " Where playlists.name = 'Grunge' ";
    sql += " Limit 20 ";
    
    result = db.runSQL(sql,"table-auto");
    // print(result);    

    // Alternate SQL syntax for #3
    sql  = " Select tracks.name  ";
    sql += " From tracks, playlist_track, playlists ";
    sql += " Where playlist_track.trackId = tracks.trackId ";
    sql += " And playlist_track.playlistId = playlists.playlistId ";
    sql += " And playlists.name = 'Grunge' ";    

    result = db.runSQL(sql,"table-auto");
    print(result);
      
  }    
}