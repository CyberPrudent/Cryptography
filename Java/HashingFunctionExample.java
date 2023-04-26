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


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashingFunctionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to hash: ");
        String input = scanner.nextLine();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(input.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(hex);
            }

            String hashedString = stringBuilder.toString();
            System.out.println("Hashed String: " + hashedString);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
