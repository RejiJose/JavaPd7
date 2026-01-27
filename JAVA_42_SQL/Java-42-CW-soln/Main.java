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
    // setup appropriate DB object to students.db
    Database db = new Database("jdbc:sqlite:students.db");

    // 1: Add the course “MCLUB1” section 3 during period 1, with teacher1 as “WHOKNOWS”, room is “ROOFTOP” for STUDENT2.
    sql = " Insert Into cr101 "  +
          " (course, section, period, teacher1, room,  studentid) " +
          " values ('MCLUB1', 3, 1, 'WHOKNOWS', 'ROOFTOP', 'STUDENT2') " ;

    db.runSQL(sql);
    

    // 2: For student with ID “STUDENT4”, add course “CN100” with a section 1, teacher1 as  “JOSEPH”, period 2 and room 108.
    sql = " Insert Into cr101 "  +
          " (studentid, course, section, teacher1, period, room) " +
          " values ('STUDENT4', 'CN100', 1, 'JOSEPH', 2, 108) " ;

    db.runSQL(sql);    
      
  }    
}