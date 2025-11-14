class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}
  
  // function to generate random integers from a to b (inclusive)
  int randInt(int a, int b){
    return (int)(Math.random()*(b-a+1))+a;
  }

  
  void init(){
    // print( "First value of x where x^2 is atleast 10000 is: " + powerOf2() );
    
    // numOfDiceRolls();
    
    // print(isPrime(15));
    // print(isPrime(1001));

    // Show all prime #s below 50
    for(int i=2; i<50; i++){
      if( isPrime(i) )
      printt(i +" ");
    }
  }

   // #1: Function powerOf2() to determine the first value of x where x^2 is atleast 10000?
  int powerOf2( ){
    int x = 0;
    while( !(Math.pow(x,2) >= 10000) ){  // while (Math.pow(2,x) < 10000){ }
      x++;
    }
    return x;
  }
  
  // #2: Function numOfDiceRolls() to determine how many rolls of a die to get outcome of 4
  void numOfDiceRolls(){
    int roll = randInt(1,6);
    int count=1;
    printt(roll + " ");
    
    while( !(roll == 4) ){
      roll = randInt(1,6);
      printt(roll + " ");
      count++;
    }
    print("\n\n# of rolls to get outcome of 4 is: " + count);
  }
  
  // #3: Function isPrime() to check if a number is Prime. (Note: A prime number is one that can only be divided by itself and 1 without remainders. For e.g., 2,3,5,7,11,13,17,19, ...)
  boolean isPrime(int n){
    int divisor = 2;
    while( n % divisor != 0){
      divisor++;
    }
    if(divisor==n)
      return true;
    else
      return false;
  }
 
 
}