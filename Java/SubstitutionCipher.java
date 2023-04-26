// Author: CyberPrudent AKA Andrew
// Description:
//
// A Substitution Cipher is a type of cipher in which each letter in the plaintext is replaced by another letter based on a fixed mapping.
// In this program, the substitution key is defined as a Map from plaintext characters to ciphertext characters. For example, the letter 'a' 
// is mapped to the letter 'm', 'b' to 'n', and so on.
//
// The program provides two methods for encrypting and decrypting messages using the substitution cipher: encrypt and decrypt.
// The encrypt method takes a plaintext message as input and returns the corresponding ciphertext message by substituting each letter in the
// plaintext message with the corresponding ciphertext character from the substitution key. The decrypt method takes a ciphertext message as
// input and returns the corresponding plaintext message by substituting each letter in the ciphertext message with the corresponding plaintext
// character from the substitution key.
//
// The program also includes a main method for testing the encrypt and decrypt methods. When the program is run, it prompts the user to enter a
// message to encrypt, then prints the encrypted message and the decrypted message for verification.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubstitutionCipher {
    
    // Define the substitution key as a map from plaintext characters to ciphertext characters
    private static final Map<Character, Character> SUBSTITUTION_KEY = new HashMap<>();
    static {
        SUBSTITUTION_KEY.put('a', 'm');
        SUBSTITUTION_KEY.put('b', 'n');
        SUBSTITUTION_KEY.put('c', 'o');
        SUBSTITUTION_KEY.put('d', 'p');
        SUBSTITUTION_KEY.put('e', 'q');
        SUBSTITUTION_KEY.put('f', 'r');
        SUBSTITUTION_KEY.put('g', 's');
        SUBSTITUTION_KEY.put('h', 't');
        SUBSTITUTION_KEY.put('i', 'u');
        SUBSTITUTION_KEY.put('j', 'v');
        SUBSTITUTION_KEY.put('k', 'w');
        SUBSTITUTION_KEY.put('l', 'x');
        SUBSTITUTION_KEY.put('m', 'y');
        SUBSTITUTION_KEY.put('n', 'z');
        SUBSTITUTION_KEY.put('o', 'a');
        SUBSTITUTION_KEY.put('p', 'b');
        SUBSTITUTION_KEY.put('q', 'c');
        SUBSTITUTION_KEY.put('r', 'd');
        SUBSTITUTION_KEY.put('s', 'e');
        SUBSTITUTION_KEY.put('t', 'f');
        SUBSTITUTION_KEY.put('u', 'g');
        SUBSTITUTION_KEY.put('v', 'h');
        SUBSTITUTION_KEY.put('w', 'i');
        SUBSTITUTION_KEY.put('x', 'j');
        SUBSTITUTION_KEY.put('y', 'k');
        SUBSTITUTION_KEY.put('z', 'l');
    }
    
    // Encrypt a message using the substitution cipher
    public static String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            // If the character is a letter, substitute it with the corresponding ciphertext character
            if (Character.isLetter(c)) {
                result.append(SUBSTITUTION_KEY.get(Character.toLowerCase(c)));
            }
            // If the character is not a letter, leave it unchanged
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    // Decrypt a message using the substitution cipher
    public static String decrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            // If the character is a letter, substitute it with the corresponding plaintext character
            if (Character.isLetter(c)) {
                for (Map.Entry<Character, Character> entry : SUBSTITUTION_KEY.entrySet()) {
                    if (entry.getValue().equals(Character.toLowerCase(c))) {
                        result.append(entry.getKey());
                    }
                }
            }
            // If the character is not a letter, leave it unchanged
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();
        String encryptedMessage = encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
