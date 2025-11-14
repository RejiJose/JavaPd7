class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){   
    // Game version 1
    // guessingGame1();
    
    // Game version 2
    // 3: Include loop for user to play again
    char playAgain = 'y';
    while( playAgain == 'y') {
      guessingGame2();
      print("Enter \"y\" to play again..");
      playAgain = Input.readChar();        
    }
    
  }

  // Game version 1 (SIMPLE): max 3 guessing tries
  void guessingGame1(){
    int num = randInt(1,10);
    print("Secret Number: " + num);
    print("Guess a number from 1 to 10");
    int guess = Input.readInt();
    int tries = 1;
      
    while(guess != num && tries < 3){  // while( !(guess == num || tries >= 3) ){
      print("Incorrect..try again..");
      guess = Input.readInt();
      tries++;
    }
    if(guess == num){
      print("Correct! You used " +tries+ " tries.");
    }
    else{
      print("Sorry, no more tries.");
    }
  }   // end of version 1
  
  
     
  // Game version 2 (ADVANCED)
  void guessingGame2(){
    int num = randInt(1,10);
    print("\n\nSecret Number: " + num);
    int guess = 0;
    int tries = 0;
    
    // 1: add a limit of 3 guesses per game
    while( guess != num && tries < 3){
      print("Guess a number from 1 to 10");
      guess = Input.readInt();
      tries++;
      // 2: prompt to go higher or lower
      if(tries < 3){ 
          if(guess < num){
            print("Guess higher");
          }
          else if(guess > num){
            print("Guess lower");
          }
          else{
            print("Correct! You used " +tries+ " tries.");
          }
      }
      else if (tries == 3){
          if(guess != num){
            print("Sorry, no more tries.");
          }
          else{
            print("Correct! You used 3 tries.");
          }
      }
      else{
        print("Sorry, no more tries.");
      }
    }   
  } // end of version 2
  
  int randInt(int a, int b){
    return (int)(Math.random()*(b-a+1))+a;
  }
}