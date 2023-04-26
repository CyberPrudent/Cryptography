// Author: CyberPrudent AKA Andrew
// Description:
// 
// In this program, the encrypt() method takes in a message and a key (an integer value) as input and returns the encrypted message.
// The decrypt() method takes in an encrypted message and the same key used for encryption and returns the decrypted message.
//
// The program uses the Caesar Cipher algorithm, which shifts each letter in the message by the key number of positions in the alphabet.
// For example, if the key is 3, 'A' becomes 'D', 'B' becomes 'E', and so on.
//
// The isLetter() method is used to check if a character is a letter. If it is, then the character is shifted by the key value.
// If it's not a letter, it remains unchanged.
//
// In the main() method, the program encrypts the message "HELLO WORLD" with a key of 3 and then decrypts the encrypted message using the same key.
// The output shows the original message, encrypted message, and decrypted message.

public class CaesarCipher {
    
    // Encrypts the message using the Caesar Cipher algorithm
    public static String encrypt(String message, int key) {
        String encrypted = "";
        // Iterate through each character in the message
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            // If the character is a letter, shift it by the key value
            if (Character.isLetter(ch)) {
                // Convert the character to uppercase and shift it by the key value
                ch = (char) (((ch - 'A' + key) % 26) + 'A');
            }
            // Add the shifted character to the encrypted message
            encrypted += ch;
        }
        // Return the encrypted message
        return encrypted;
    }
    
    // Decrypts the message using the Caesar Cipher algorithm
    public static String decrypt(String message, int key) {
        String decrypted = "";
        // Iterate through each character in the message
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            // If the character is a letter, shift it back by the key value
            if (Character.isLetter(ch)) {
                // Convert the character to uppercase and shift it back by the key value
                ch = (char) (((ch - 'A' - key + 26) % 26) + 'A');
            }
            // Add the shifted character to the decrypted message
            decrypted += ch;
        }
        // Return the decrypted message
        return decrypted;
    }
    
    public static void main(String[] args) {
        // Define the message and key values
        String message = "HELLO WORLD";
        int key = 3;
        // Encrypt the message using the key value
        String encryptedMessage = encrypt(message, key);
        // Decrypt the encrypted message using the same key value
        String decryptedMessage = decrypt(encryptedMessage, key);
        
        // Print the original message, encrypted message, and decrypted message
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
