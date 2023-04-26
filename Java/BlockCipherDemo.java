// Author: CyberPrudent AKA Andrew
// Description:
//
// This program demonstrates the use of a Block Cipher by encrypting a plaintext message using the Advanced Encryption
// Standard (AES) with a randomly generated key, and then decrypting the resulting ciphertext to recover the original
// plaintext message.
//
// The program first generates a random 128-bit AES key using the KeyGenerator class. Then, an AES cipher object is
// created using the Cipher class with Cipher Block Chaining (CBC) mode and PKCS5 padding. A random 16-byte initialization
// vector is also generated using the SecureRandom class and used to initialize the cipher object.
//
// Next, a plaintext message is defined as a String object and converted to a byte array using UTF-8 encoding. The cipher
// object is then initialized for encryption mode with the randomly generated key and initialization vector. The plaintext
// message is encrypted using the doFinal() method of the cipher object, which returns a byte array of ciphertext.
//
// The ciphertext is then printed to the console as a hexadecimal string using a helper method called bytesToHex(), which
// converts a byte array to a string of hexadecimal digits.
//
// To decrypt the ciphertext, the cipher object is re-initialized for decryption mode with the same key and initialization
// vector. The ciphertext is then decrypted using the doFinal() method of the cipher object, which returns a byte array of
// decrypted plaintext. The decrypted plaintext is then converted back to a String object using UTF-8 encoding and printed
// to the console.

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class BlockCipherDemo {
    public static void main(String[] args) throws Exception {
        // Generate a random 128-bit AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

        // Create an AES cipher object
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Generate a random 16-byte initialization vector
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Encrypt the plaintext message
        String plaintext = "Hello, world!";
        byte[] plaintextBytes = plaintext.getBytes("UTF-8");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] ciphertextBytes = cipher.doFinal(plaintextBytes);

        // Print the ciphertext as a hexadecimal string
        String ciphertext = bytesToHex(ciphertextBytes);
        System.out.println("Ciphertext: " + ciphertext);

        // Decrypt the ciphertext to recover the plaintext message
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedBytes = cipher.doFinal(ciphertextBytes);
        String decrypted = new String(decryptedBytes, "UTF-8");
        System.out.println("Decrypted: " + decrypted);
    }

    // Helper method to convert a byte array to a hexadecimal string
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
