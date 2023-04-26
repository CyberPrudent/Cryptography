// Author: CyberPrudent AKA Andrew
// Description:
//
// This program demonstrates how the RSA public-key cryptosystem can be implemented using Java's BigInteger and SecureRandom classes.
//
// The RSA algorithm works as follows:
//
// 1. Choose two large prime numbers p and q, and calculate their product n = p * q, which is the modulus for the RSA encryption.
//
// 2. Calculate Euler's totient function of n, φ(n) = (p - 1) * (q - 1).
//
// 3. Choose a public exponent e that is coprime to φ(n), i.e. gcd(e, φ(n)) = 1. The most common value for e is 65537, which is
//    a prime number that has a simple binary representation (10000000000000001).
//
// 4. Calculate the private exponent d such that d * e ≡ 1 (mod φ(n)), i.e. d is the modular multiplicative inverse of e modulo φ(n).
//    This can be done efficiently using the extended Euclidean algorithm.
//
// 5. The public key consists of the modulus n and the public exponent e. The private key consists of the modulus n and the private exponent d.
//
// To encrypt a message m using the RSA public key, one computes the ciphertext c as c = m^e mod n.
// To decrypt a ciphertext c using the RSA private key, one computes the plaintext m as m = c^d mod n.
//
// The RSA class in the program generates an RSA public and private key pair with a given key size N (in bits), using the probablePrime()
// method of the BigInteger class to generate random prime numbers of approximately N/2 bits. The public exponent is fixed to 65537, and the
// private key is computed using the modInverse() method of the BigInteger class.
//
// The encrypt() method of the RSA class takes a BigInteger message as input and returns its RSA encryption using the public key.
// The decrypt() method of the RSA class takes a BigInteger ciphertext as input and returns its RSA decryption using the private key.
//
// The main() method of the program generates a random BigInteger message of size N-1 bits (smaller than the modulus), encrypts it using
// the RSA public key, decrypts the resulting ciphertext using the RSA private key, and prints the original message, the ciphertext, and
// the decrypted message.

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private final static BigInteger one = new BigInteger("1"); // define constant BigInteger of 1
    private final static SecureRandom random = new SecureRandom(); // define SecureRandom instance

    private BigInteger privateKey; // the private key
    private BigInteger publicKey; // the public key
    private BigInteger modulus; // the modulus

    // Generate an N-bit (roughly) public and private key
    public RSA(int N) {
        BigInteger p = BigInteger.probablePrime(N / 2, random); // generate a prime number p of size N/2 bits
        BigInteger q = BigInteger.probablePrime(N / 2, random); // generate a prime number q of size N/2 bits
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one)); // calculate Euler's totient function of p and q

        modulus = p.multiply(q); // calculate the modulus
        publicKey = new BigInteger("65537"); // choose a public exponent (often 65537 = 2^16+1)
        privateKey = publicKey.modInverse(phi); // calculate the private key
    }

    // Encrypt the message using the public key
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus); // perform the encryption and return the ciphertext
    }

    // Decrypt the ciphertext using the private key
    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus); // perform the decryption and return the plaintext
    }

    public static void main(String[] args) {
        int N = 128; // choose a key size
        RSA rsa = new RSA(N); // create an RSA object with a public and private key of N bits

        // create a message to be encrypted
        BigInteger message = new BigInteger(N - 1, random); // generate a random number smaller than the modulus

        // encrypt and decrypt message
        BigInteger encrypted = rsa.encrypt(message); // encrypt the message using the RSA public key
        BigInteger decrypted = rsa.decrypt(encrypted); // decrypt the ciphertext using the RSA private key

        // print results
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Decrypted message: " + decrypted);
    }
}
