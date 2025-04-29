public class Main {
    // Define the function
    public static int square(int number) {
        return number * number;
    }
  
    public static void main(String[] args) {
        // Declare and initialize a variable
        int myNumber = 7;

        // Call the function using the variable
        int result = square(myNumber);

        // Print the result
        System.out.println("The square of " + myNumber + " is: " + result);
    }
}
