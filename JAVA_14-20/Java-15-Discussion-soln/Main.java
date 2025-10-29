class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    print(sumN(100));

    print(sumPowersOf2(4));

    print(factorial(5));

  }

  /* 1) Sum of the first N integers:
  Write a function that accepts an integer N and returns the sum of all consecutive integers from 1 through N.
  */
    int sumN(int N){
      int sum = 0; // initialize sum to 0 before the loop
      for(int x=1; x<=N;x++)
        sum+=x;

      return sum;
    }
  
  /* 2) Sum of the powers of 2 for the first N integers:
    Write a function that accepts an integer N and returns the sum of all powers of 2 from 2^1 through 2^N.
  */ 
    int sumPowersOf2(int N){
      int sum = 0;
      for(int x=1; x<=N; x++)
        sum += Math.pow(2,x);

      return sum;
    }

  /* 3) Factorial of N:
    Write a function that accepts an integer n and returns the Factorial of n (n!).
  */ 
  String factorial(int n){
    int result=1; // Note: do not start result at zero, since you will be multiplying
    for(int i=1; i<=n; i++)
      result *= i;

    return (n +"! = " + result);
  }

  
}