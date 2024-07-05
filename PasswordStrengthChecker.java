// Package declaration
package Level2;

// Import necessary classes for scanning user input and working with regular expressions
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Main class for checking password strength
public class PasswordStrengthChecker {
    
    // Compile a regular expression pattern for password strength criteria
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
    
    // Main method where the program starts execution
    public static void main(String[] args) {
        
        // Initialize a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter their password
        System.out.print("Enter your password :: ");
        
        // Read the user's input as a string
        String password = scanner.nextLine();
        
        // Determine the strength of the entered password
        String strength = getPasswordStrength(password);
        
        // Print the determined strength level to the console
        System.out.print("Your password is :: " + strength);
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
    
    // Method to determine the strength of a given password
    private static String getPasswordStrength(String password) {
        // Create a Matcher object to match the password against the compiled pattern
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        
        // If the password matches the pattern, it is considered Strong
        if (matcher.matches()) {
            return "Strong";
        } 
        // If the password is at least 6 characters long but doesn't match the pattern, it is Moderate
        else if (password.length() >= 6) {
            return "Moderate";
        } 
        // Otherwise, the password is Weak
        else {
            return "Weak";
        }
    }   
}
