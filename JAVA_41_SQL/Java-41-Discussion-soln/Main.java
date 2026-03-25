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
      String queryResult="";
     
		Database db =  new Database("jdbc:sqlite:cr101.db");	
       
      // 1. Update the 2nd period room for student with ID STUDENT36 from 106 to 322.

      // a) First check that you are getting the correct records
		// sql = "Select * from cr101 " +
      //   "WHERE studentID = 'STUDENT36' AND period = 2;";

		// queryResult = db.runSQL(sql,"table-auto");
		// print(queryResult);

      // b) Update the record. (NOTE: you need to pass just the sql string when updating; No need of 'table-auto')
	   //  sql = "Update cr101 "  +
      //       "Set room = 322 "  +
      //       "Where studentID = 'STUDENT36' and period = 2;";

		// db.runSQL(sql);

      // c) Check that the update took place by displaying the query result
      // sql = "Select * from cr101 "  +
            // "Where studentID = 'STUDENT36' and period = 2;";

      // queryResult = db.runSQL(sql,"table-auto");
      // print(queryResult);

    
      //2. Remove the course ZLUN from the schedule of a student with an ID of STUDENT1270

      //a) Check to see that the WHERE clause gets the correct record
      // sql = "Select * from cr101 " ;
      // sql+=  "Where studentID = 'STUDENT1270' and course='ZLUN' ";

      // queryResult = db.runSQL(sql,"table-auto");
      // print(queryResult);


      //b) delete the record
      // sql  = " Delete From cr101 ";
      // sql +=  "Where studentID = 'STUDENT1270' and course='ZLUN' ";
    
      // db.runSQL(sql);

      //c) check to confirm that the record no longer exists
      // sql = "Select * from cr101 " ;
      // sql +=  "Where studentID = 'STUDENT1270' and course='ZLUN' ";

      // queryResult = db.runSQL(sql,"table-auto");
      // print(queryResult);	   
      
  }    
}