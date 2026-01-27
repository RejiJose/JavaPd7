
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

    // Challenge 1:
    For student with ID of STUDENT1001, change room to 122 for period 3 class.
    sql =  " Update cr101 ";
    sql += " set room = 122 ";
    sql += " Where studentid='STUDENT1001' AND period=3 ";

    db.runSQL(sql);
    //Check    
    sql  = " Select * From cr101 ";
    sql += " Where studentid='STUDENT1001' AND period=3 ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    
    // Challenge 2:
    // Remove course “ZQCTEDA” for student with id STUDENT1200 
    sql =  " Delete From cr101 ";
    sql += " Where studentid='STUDENT1200' AND course='ZQCTEDA' ";

    db.runSQL(sql);
    Check    
    sql  = " Select * From cr101 ";
    sql += " Where studentid='STUDENT1200' AND course='ZQCTEDA' ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    
    // Challenge 3:
    // Change the room number of teacher1 DOYLE for periods 4 and 5 to room 213.
    sql =  " Update cr101 ";
    sql += " set room = 213 ";
    sql += " Where teacher1='DOYLE' AND period in (4,5)  ";

    db.runSQL(sql);
    // Check    
    sql  = " Select * From cr101 ";
    sql += " Where teacher1='DOYLE' AND period in (4,5)  ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    
    // Challenge 4:
    // Mr. ROFFLER will be replacing Mr. ARCHETTI for course “MQF44QGF” section 1. Update all records to reflect this change.
    sql =  " Update cr101 ";
    sql += " set teacher1 = 'ARCHETTI' ";
    sql += " Where teacher1='ROFFLER' AND course='MQF44QGF' ";
    sql += " AND section=1 ";

    db.runSQL(sql);

    
    // Challenge 5:
    // Change the grade for STUDENT999 to 11 and the student's offclass to a junior status.

    // Need to find the official class first
    sql  = " Select * From cr101 ";
    sql += " Where studentid='STUDENT999' ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    sql =  " Update cr101 ";
    sql += " set grade = '11', offclass = '3C8' ";
    sql += " Where studentid='STUDENT999' ";

    db.runSQL(sql);

    
    // Challenge 6:
    // Add a course MKUFTC6 with a section 1. CASTRO R will be teaching this course period 9 in room 322 for student1231.
    sql =  " Insert Into cr101 ";
    sql += " (course, section, teacher1, period, room, studentid) ";
    sql += " values ('MKUFTC6', 1, 'CASTRO R', 9, 322, 'STUDENT1231')";

    db.runSQL(sql);

     
  }    
}