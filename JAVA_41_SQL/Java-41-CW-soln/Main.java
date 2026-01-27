import java.io.IOException;
import java.sql.*;
//For compiling on the shell on repl: Same on mac
//javac -cp sqlite-jdbc-3.23.1.jar: Main.java

//Use for windows
//javac -cp sqlite-jdbc-3.23.1.jar; ServerExample.java
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() {
           
      String sql = "";
      String queryResult="";
     
		  Database db = new Database("jdbc:sqlite:cr101.db");	

    // TASK 1: Change Mr. Porchetta’s 10th period room to 323
    sql = " Update cr101 "  +
          " Set room = 323 " +
          " Where teacher1 = 'PORCHETTA' and period = 10; " ;

    db.runSQL(sql);

    // TASK 2: Remove Mr. Castro's (“CASTRO R”) 2nd period class records.
    sql = " Delete From cr101 "  +
          " Where teacher1 = 'CASTRO R' and period = 2; " ;

    db.runSQL(sql);

    // NOTE: You must do a query retrieval before and after the tasks to confirm the effect on the data. 
  }    
}