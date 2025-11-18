class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){System.out.println(o);}
  void printt(Object o){System.out.print(o);}

  void init(){
    // menu();
	// allowance1();
    // allowance2();
    addTwoNumbers();
    // printt( GCF(12,18) );
    // securityCode("ABCD");  
    
  }

  /* Challenge 1:  Allowance Plan A or B ?
    Plan A: You get $5 on day 1 and no more. 
    Plan B: You get a penny on day 1. On each following day thereafter, you double the value from the previous day. 
    How many days will it take for the amount in plan B to equal or exceed that of plan A?
    Write a function allowance1() that solves the problem.
  */
  void allowance1(){
    int day=1;
    int pennyPlan = 1;
    while (pennyPlan < 500){
      print("Day " + day + ": " + pennyPlan);
      pennyPlan *= 2;
      day++;
    }
    print("Penny plan exceeds $5 in "+day+ " days. Value is: "+ pennyPlan);
  }

    /* Challenge 2:  Allowance Plan 1 or 2 ?  
  Plan-1 : Start with $1000. Add $100 each day to the previous day's balance.
  Plan-2 : Start with 1 penny. Add double that the next day. For each day after that, the amount added the previous day is doubled and added to the balance.

  Write a function allowance2() that will display the daily value in each plan as you determine how many days it will take for Plan2 to be better than Plan1.
  */
    void allowance2(){
      int alw1 = 1000;
      double alw2 = 0.01;
      double amt = 0.01;
      int day = 1;
      print("Day   Plan-1      Plan-2");
      print("---  --------   ----------");
      print(day + "    $ "+alw1 + "      $ "+alw2);
      while (alw1 > alw2){
        //Plan 1
        alw1 += 100;

        //Plan 2
        amt *= 2;
        alw2 += amt;

        day++;

        print(day + "    $ "+alw1 + "      $ "+alw2);
      }
      print("\nPlan-2 exceeds Plan-1 on day "+day);
    }
  
  /*
    Challenge 3:
    Write a function addTwoNumbers() that generates two random integers (between -10 and 10), and then asks the user to enter the sum of those two numbers. Allow the user to keep trying until they get it correct.
  */
  void addTwoNumbers(){
    int n1 = randInt(-10,10);
    int n2 = randInt(-10,10);
    int ans = -50;
    print("What is "+n1+" + "+ n2+" = ?");
    while(n1+n2 != ans){
      ans = Input.readInt();
      if( n1+n2==ans)
        print("Correct!");
      else
        print("Incorrect, try again.");
    }
  }


  /*
    Challenge 4:
    Write a function GCF() that accepts two integers, calculates and returns the GCF (greatest common factor) of the two integers. (For e.g, GCF of 12 and 18 is 6.)
  */
  int GCF(int n1, int n2){    
    int divisor = Math.min(n1,n2);
    while( !(n1%divisor==0 && n2%divisor==0) ){
      divisor--;
    }
    printt("GCF of " +n1+" and "+n2+" is: ");
    return divisor;
  }
  
  /*
    Challenge 5:
    Write a function securityCode() that receives a security code. Ask the user to enter their code. Check to see if the user's entry matches the security code. If it does, display "Access granted!". If not, keep asking for the code.
  */
  void securityCode(String code){
    String userCode="";
    while( !userCode.equals(code) ){
      print("Enter your security code:");
      userCode=Input.readString();
    }
    print("Access granted!");
  }

  /*
    Challenge 6:
    Write a function menu() that allows a user to choose 1 of 5 functions present above. Also include a 6th choice to exit out of the menu.
    Example:
    Menu: make your choice
    1 - Allowance plan A or B ?
    2 - Allowance plan 1 or 2 ?
    3 - Addition game
    4 - GCF of two integers
    5 - Security Code
    6 - Exit Menu
  */
  void menu(){
    int choice = 0;
    while (choice != 6){
      print("\n\nMenu: make your choice");
      print("1 - Allowance plan A or B ?");
      print("2 - Allowance plan 1 or 2 ?");
      print("3 - Addition game");      
      print("4 - GCF of two integers");
      print("5 - Security Code");
      print("6 - Exit Menu");  
      choice = Input.readInt();
      
      if(choice == 1){
        allowance1();
      }
      else if(choice == 2){
        allowance2();
      }
      else if(choice == 3){
        addTwoNumbers();
      }
      else if(choice == 4){
        print("Enter first integer: ");
        int n1 = Input.readInt();
        print("Enter second integer: ");
        int n2 = Input.readInt();
        printt( GCF(n1,n2) );        
      }
      else if(choice == 5){
        print("Enter actual security code: ");
        String code = Input.readString();
        securityCode(code);        
      }
    }
  }
  
 
  int randInt(int lower, int upper){
    int range = upper - lower +1 ;
    return (int)(Math.random()*range) +lower;
  }

}