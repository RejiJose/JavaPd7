import java.io.IOException;
import java.sql.*;
// To Compile on the Replit shell use: (same as for mac)
// javac -cp sqlite-jdbc-3.23.1.jar: Main.java

// To compile in Windows use:
// javac -cp sqlite-jdbc-3.23.1.jar

// To execute(run) use:
// java -cp sqlite-jdbc-3.23.1.jar: Main

class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() {
      // Review the database class and its constructor (how a DB object is instantiated)
    
      // Discuss the jar file (library of classes)
      // Note: The database (say, cr101.db) must be one of the files within your project.

      String sql =""; // variable to store the SQL query
      String queryResult=""; // variable to store result of the query (from DB)
    
      // Instantiate(create) a Database object needed to connect with the DB
		  Database db =  new Database("jdbc:sqlite:cr101.db");
    
      // 1) Display all records for a student with ID Student51
      sql = "SELECT * FROM cr101 WHERE studentId='STUDENT51';";	
      queryResult = db.runSQL(sql,"table-auto");// 'table-auto' will adjust the table column widths automatically; table-10 means column width set to 10 characters
      print(queryResult);
      print("*************************");

    
      // 2) Display the first 5 records only
      // sql = "select * from cr101 where studentId='STUDENT1' Limit 5;";	// Limit 5 means first 5 rows(records) only
      // queryResult = db.runSQL(sql,"table-auto");
      // print(queryResult);
      // print("*************************");

    
      // 3) Display records of Teacher, Course and Period in Room 108 for pds 2 and 3
      // sql = "SELECT teacher1, course, period From cr101 Where room=108 and period in (2,3);";	
      // queryResult = db.runSQL(sql,"table-auto");
      // print(queryResult);

      // 4) Display only unique records of Teacher, Course and Period in Room 108 for pds 2 and 3
      // sql = "SELECT DISTINCT teacher1, course, period From cr101 Where room=108 and period in (2,3);";	
      // queryResult = db.runSQL(sql,"table-auto");
      // print(queryResult);
    
  }// end init
  
}// end Main