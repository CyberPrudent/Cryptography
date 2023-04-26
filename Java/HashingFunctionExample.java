// Author: CyberPrudent AKA Andrew
// Description:
//
// This program demonstrates the use of hashing functions in cryptography. The program prompts the user to
// enter a string to hash, which is then processed using the SHA-256 hashing algorithm. The program first creates
// an instance of the MessageDigest class with the SHA-256 algorithm specified. It then applies the hashing function
// to the user input string and stores the resulting hash in a byte array. Next, the program converts the byte array to
// a string representation using hexadecimal notation. Finally, the program outputs the hashed string to the console.
// If the specified algorithm is not available, the program catches the NoSuchAlgorithmException exception and outputs
// an error message.
//
// If you're interested in learning about more advanced hashing algorithms, check out the Central-Dogma-Hash-Algorithm.
// This algorithm was developed as part of a team project and is significantly more complicated than this example as we made
// sure to create a hashing algorithm from scratch that is one-way and with a low probability of collision. You can try out the 
// Central-Dogma-Hash-Algorithm for yourself on our project website at https://andrew-musa.github.io/cpsc329/.


import java.security.MessageDigest; // Import the MessageDigest class for hashing
import java.security.NoSuchAlgorithmException; // Import the exception class for handling algorithm errors
import java.util.Scanner; // Import the Scanner class for reading user input

public class HashingFunctionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        System.out.println("Enter a string to hash: "); // Prompt the user to enter a string to hash
        String input = scanner.nextLine(); // Read the user input string

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // Create a MessageDigest object with the SHA-256 algorithm
            byte[] hash = messageDigest.digest(input.getBytes()); // Compute the hash value of the input string

            StringBuilder stringBuilder = new StringBuilder(); // Create a StringBuilder object for constructing the hashed string
            for (int i = 0; i < hash.length; i++) { // Iterate over the bytes in the hash value
                String hex = Integer.toHexString(0xff & hash[i]); // Convert the byte to a hexadecimal string
                if (hex.length() == 1) { // If the string is only one character long, append a leading 0 to make it two characters
                    stringBuilder.append('0');
                }
                stringBuilder.append(hex); // Append the hexadecimal string to the StringBuilder object
            }

            String hashedString = stringBuilder.toString(); // Convert the StringBuilder object to a string
            System.out.println("Hashed String: " + hashedString); // Print the hashed string
        } catch (NoSuchAlgorithmException e) { // Catch any errors related to the hashing algorithm
            System.out.println("Error: " + e.getMessage()); // Print an error message
        }
    }
}
