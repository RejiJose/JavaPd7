import java.io.IOException;
import java.sql.*;
// SQL Inner Join syntax:
/*
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;
*/

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

      // What do we get when we join two tables: 'artists' and 'albums'?
      // GET ONLY the first 5 records (use LIMIT)
      // sql  = " SELECT * FROM artists ";
      // sql += " INNER JOIN albums ON artists.artistid = albums.artistid ";
      // sql += " LIMIT 5";
      // result = db.runSQL(sql,"table-auto");
      // print(result);
    
      //  Q1: How do you find all the Invoice IDs for customer 'Astrid Gruber' ?
      // sql  = " Select invoices.invoiceid From invoices ";
      // sql += " Inner Join customers On customers.customerid = invoices.customerid ";
      // sql += " Where customers.firstname='Astrid' and customers.Lastname='Gruber' ";
      // result = db.runSQL(sql,"table-auto");
      // print(result);
    
      // Q2: How do you find the album names for the artist 'Audioslave' ?
      // sql  = " Select albums.title From albums ";
      // sql += " Inner Join artists On artists.artistid = albums.artistid ";
      // sql += " Where artists.name='Audioslave' ";
      // result = db.runSQL(sql,"table-auto");
      // print(result);
    
      // Q3: How do you find the artist names from the playlist 'Brazilian Music' ?
      // There are duplicates, so use SELECT DISTINCT
      sql  = " Select Distinct artists.name From artists ";
      sql += " Inner Join albums On artists.artistid = albums.artistid ";
      sql += " Inner Join tracks On albums.albumid = tracks.albumid ";
      sql += " Inner Join playlist_track On tracks.trackid = playlist_track.trackid ";
      sql += " Inner Join playlists On playlists.playlistid = playlist_track.playlistid ";
      sql += " Where playlists.name='Brazilian Music' ";
      result = db.runSQL(sql,"table-auto");
      print(result);

      // Alternate SQL syntax for Q3
      // sql  = " Select Distinct artists.name  ";
      // sql += " From artists, albums, tracks, playlists, playlist_track ";
      // sql += " Where artists.artistid = albums.artistid ";
      // sql += " And albums.albumid = tracks.albumid ";
      // sql += " And tracks.trackid = playlist_track.trackid ";
      // sql += " And playlists.playlistid = playlist_track.playlistid ";
      // sql += " And playlists.name='Brazilian Music' ";
    
      // result = db.runSQL(sql,"table-auto");
      // print(result);
      
  }    
}