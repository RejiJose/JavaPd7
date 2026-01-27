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
    
      String sql = "";
      String queryResult = "";
          
		  Database db = new Database("jdbc:sqlite:cr101.db");	

      // 1) Add course SLF43, section 5, period 5 in room 341 with teacher1 as WILLIAMS, for student with ID of STUDENT1000 who is in grade 10 and has an official class 2Y0.
    
      sql = "Insert into cr101 "   +
        "(StudentId, Offclass, Grade, Course, Section, Teacher1, Teacher2, Period, Room) "+
        " Values ('STUDENT1000', '2Y0', 10, 'SLF43', 5, 'WILLIAMS', '', 5, 341 ) ";

      db.runSQL(sql);


      // 2) Check that the update took place
      sql = "Select * from cr101 "  +
            " Where studentID = 'STUDENT1000' ";

      queryResult = db.runSQL(sql,"table-auto");
      print(queryResult);
      
  }    
}