// Author: CyberPrudent AKA Andrew
// Description:
//
// The encrypt method takes in a plaintext message and a key as parameters and returns the encrypted ciphertext message.
// It first converts both the plaintext message and key to uppercase to simplify the encryption process. It then loops through
// each character in the plaintext message and checks if it is a letter or not. If it is not a letter, the program skips the
// character and continues to the next one. If it is a letter, it performs the encryption process using the Vigenere Cipher
// algorithm, which involves adding the ASCII values of the plaintext character and the key character, subtracting the ASCII
// value of 'A', taking the modulo of 26, and adding the ASCII value of 'A' again to get the encrypted character. The key is
// repeated as necessary to encrypt the entire plaintext message.
//
// The decrypt method takes in a ciphertext message and a key as parameters and returns the decrypted plaintext message.
// It follows a similar process as the encrypt method, but instead of adding the ASCII values of the plaintext character and the
// key character, it subtracts them, adds 26, takes the modulo of 26, and adds the ASCII value of 'A' again to get the decrypted
// character. Again, the key is repeated as necessary to decrypt the entire ciphertext message.
//
// The main method of the program defines a key and a plaintext message, calls the encrypt method to encrypt the message using
// the key, prints the resulting ciphertext and key, calls the decrypt method to decrypt the ciphertext message using the key,
// and prints the resulting plaintext message. This demonstrates how the Vigenere Cipher can be used to securely encrypt and
// decrypt messages, as long as the key is kept secret.

public class VigenereCipher {

    public static void main(String[] args) {
        
        // Define the key and plaintext message
        String key = "SECRET";
        String plaintext = "THIS IS A SECRET MESSAGE";
        
        // Encrypt the plaintext message using the key
        String ciphertext = encrypt(plaintext, key);
        
        // Print the ciphertext and the key
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Key: " + key);
        
        // Decrypt the ciphertext message using the key
        String decryptedText = decrypt(ciphertext, key);
        
        // Print the decrypted plaintext message
        System.out.println("Decrypted Text: " + decryptedText);
    }
    
    // Method to encrypt a plaintext message using a key
    public static String encrypt(String plaintext, String key) {
        String ciphertext = "";
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            ciphertext += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return ciphertext;
    }
    
    // Method to decrypt a ciphertext message using a key
    public static String decrypt(String ciphertext, String key) {
        String plaintext = "";
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            plaintext += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return plaintext;
    }
}
