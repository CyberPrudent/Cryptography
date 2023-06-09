// Author: Andrew AKA CyberPrudent
// Description:
//
// The program implements a simple Stream Cipher using the XOR operation. The cipher works by taking
// the bytes of the message to be encrypted and XORing them with corresponding bytes of a secret key
// and a stream of random bytes. The resulting encrypted message can then be decrypted by XORing it with
// the same key and stream of random bytes.
//
// First, a secret key is defined as a constant KEY. This key will be used to encrypt and decrypt the message.
// The main method of the program initializes a message to be encrypted as a string "Hello, world!". This message
// is then converted into a byte array using the getBytes() method.
//
// The encrypt() method is called with the message byte array as an argument. This method takes each byte of
// the message, XORs it with the corresponding byte of the secret key and a random byte generated by a Random
// object, and stores the result in a new byte array representing the encrypted message.
//
// The decrypt() method is called with the encrypted message byte array as an argument. This method simply calls
// the encrypt() method again, which reverses the encryption process and produces the original message byte array.
//
// Finally, the original message, encrypted message, and decrypted message are printed to the console.

import java.util.Random;

public class StreamCipher {
    
    private static final String KEY = "mySecretKey"; // Secret key for the cipher
    
    public static void main(String[] args) {
        String message = "Hello, world!"; // The message to be encrypted
        byte[] encryptedMessage = encrypt(message.getBytes()); // Encrypt the message
        String decryptedMessage = new String(decrypt(encryptedMessage)); // Decrypt the encrypted message
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + new String(encryptedMessage));
        System.out.println("Decrypted message: " + decryptedMessage);
    }
    
    /**
     * Encrypts a byte array using a stream cipher.
     * 
     * @param message the message to be encrypted
     * @return the encrypted message
     */
    public static byte[] encrypt(byte[] message) {
        byte[] keyBytes = KEY.getBytes(); // Get the bytes of the secret key
        byte[] encrypted = new byte[message.length]; // Initialize the encrypted message
        Random rand = new Random(KEY.hashCode()); // Create a new random number generator with the hash code of the secret key as the seed
        for (int i = 0; i < message.length; i++) {
            // XOR the message byte with the corresponding key byte and a random byte, and store the result in the encrypted message
            encrypted[i] = (byte) (message[i] ^ keyBytes[i % keyBytes.length] ^ rand.nextInt());
        }
        return encrypted;
    }
    
    /**
     * Decrypts a byte array using a stream cipher.
     * 
     * @param encrypted the encrypted message
     * @return the decrypted message
     */
    public static byte[] decrypt(byte[] encrypted) {
        return encrypt(encrypted); // XOR is symmetric, so encryption and decryption are the same
    }
    
}
