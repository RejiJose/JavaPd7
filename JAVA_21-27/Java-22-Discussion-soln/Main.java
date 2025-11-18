/* Arrays: special variable to store multiple values, identified by their index (position) which starts at zero.
Note: In Java: 
- arrays must declare a data type. 
- All elements must be of the same data type (cannot mix data types). 
- Elements are enclosed between curly braces. 
- The size of an array cannot be changed once declared. 
- An empty array stores (0s as elements if type is int; null if type is String, etc.)  
*/
class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // Define (or create) an array with known values
    int[] nums = {2,3,4,5,6};

    // Accessing array elements
     print(nums[0]); // 1st element
     print(nums[2]); // 3rd element

    // Size of an array (number of elements in it). 
    // Note: length is a variable, not a function (i.e., no parentheses )
     print(nums.length);
    
    // Last element of an array
     print(nums[ nums.length-1]);

    
    // Function to list all the elements of an array received by it
     showArray(nums);

    // Create a new array of size 10 and then display the elements
     int[] arr10 = createArrayOf10();
     showArray(arr10);

    // Create a new array that stores the squares of the elements of an existing array and display the new elements.
    int[] numSquares = squaresArray(nums);
    showArray(numSquares);    
 
  }

  // Function to print all the elements of an array (use a 'for' loop to traverse the array)
  void showArray(int[] a){
    for(int x=0; x <= a.length-1; x++){      
      printt(a[x] +", "); // print(a[x]);
    }
  }

  // Function to create an array of 10 elements and return the array
  int[] createArrayOf10(){    
    int[] arr = new int[10]; // uses 'new' to create an empty integer array of size 10
    showArray(arr); //Note that a new array is populated with zero as values
    for(int x=0; x<= arr.length-1; x++){
      arr[x] = randInt(-100,100);
    }
    return arr;
  }

  // Function that accepts an array and returns a new array of the squares of each element of the array passed to it.
  int[] squaresArray(int[] a){    
    int[] sqrs = new int[a.length];
    
    for(int x=0; x <= a.length-1; x++){
      sqrs[x] = (int)(Math.pow(a[x],2)); // cast as integer because of Math.pow
    }
    return sqrs;    
  }

  // random integer generator
  int randInt(int lower, int upper){
    int range = upper - lower + 1;
    return (int)(Math.random()*range) +lower;
  }

}