class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){System.out.println(o);}

  void init(){
      eachChar("Hello");
      print("-------- * --------");
	  
	  print(countChar("Hello","l"));
	  
	  // Count number of occurences of a character within a text file
      String file = Input.readFile("article.txt");      
      print(countChar(file,"o"));
	  
      print("Binary to decimal conversion \n-------- * --------");    
      print(binaryToDecimal("1001"));
  }

  // Display each character of a string
  void eachChar(String s){
    for(int x=0; x<=s.length()-1; x++)
      print(s.substring(x, x+1));
  }

  // Count number of occurences of a character within a string
  int countChar(String s, String ch){    
    int count=0;
    String letter=""; 
    
    for(int x=0; x<=s.length()-1; x++){
      letter = s.substring(x, x+1);
      if(letter.equals(ch) )
         count++;
    }
    return count;
  }

  // Binary to decimal conversion 
  int binaryToDecimal(String s){    
    int sum=0;
    
    // Method 1:
        int exp=s.length()-1;

        for(int x=0; x<=s.length()-1; x++){
          String digit = s.substring(x, x+1);
          if(digit.equals("1")){
            sum += Math.pow(2,exp);
          }
          exp--;
        }  // end of method 1
        
    
    // Method 2:
      /*  int exp=0;

          for(int x=s.length()-1; x>=0; x--){
            String digit = s.substring(x, x+1);
            if(digit.equals("1")){
              sum += Math.pow(2,exp);
            }
            exp++;
          } */  // end of method 2
    return sum;
  }
}