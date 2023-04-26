// Author: CyberPrudent AKA Andrew
// Description:
// 
// To use this program, simply run it and enter a message and a key of the same length.
// The program will then encrypt the message using XOR with the key and print out the encrypted message.
// It will then decrypt the encrypted message using the same key and print out the decrypted message.

import java.util.Scanner;

public class XorCrypt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the message to encrypt and the key from the user
        System.out.print("Enter a message to encrypt: ");
        String message = sc.nextLine();
        System.out.print("Enter a key (must be the same length as the message): ");
        String key = sc.nextLine();

        // Encrypt the message using XOR with the key
        String encrypted = encrypt(message, key);
        System.out.println("Encrypted message: " + encrypted);

        // Decrypt the encrypted message using XOR with the same key
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted message: " + decrypted);
    }

    // Encrypts the given message using XOR with the given key
    public static String encrypt(String message, String key) {
        // Convert the message and key to byte arrays
        byte[] messageBytes = message.getBytes();
        byte[] keyBytes = key.getBytes();

        // Create a byte array to hold the encrypted message
        byte[] encryptedBytes = new byte[messageBytes.length];

        // Perform XOR on each byte of the message and key and store the result in the encrypted message array
        for (int i = 0; i < messageBytes.length; i++) {
            encryptedBytes[i] = (byte) (messageBytes[i] ^ keyBytes[i]);
        }

        // Convert the encrypted message byte array back to a string and return it
        return new String(encryptedBytes);
    }

    // Decrypts the given encrypted message using XOR with the given key
    public static String decrypt(String encrypted, String key) {
        // Convert the encrypted message and key to byte arrays
        byte[] encryptedBytes = encrypted.getBytes();
        byte[] keyBytes = key.getBytes();

        // Create a byte array to hold the decrypted message
        byte[] decryptedBytes = new byte[encryptedBytes.length];

        // Perform XOR on each byte of the encrypted message and key and store the result in the decrypted message array
        for (int i = 0; i < encryptedBytes.length; i++) {
            decryptedBytes[i] = (byte) (encryptedBytes[i] ^ keyBytes[i]);
        }

        // Convert the decrypted message byte array back to a string and return it
        return new String(decryptedBytes);
    }
}
