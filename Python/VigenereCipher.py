# Author: Andrew AKA CyberPrudent
# Description:
#
# The VigenereCipher class has two methods: encrypt() and decrypt(). The main() method defines the plaintext message and
# the key, encrypts the plaintext using the key, prints the ciphertext and key, decrypts the ciphertext using the key,
# and prints the decrypted plaintext message.
#
# The encrypt() method takes two parameters: the plaintext message and the key. It converts the plaintext and key to uppercase,
# and then iterates over each character of the plaintext message. If the character is not a letter, it skips it. Otherwise, it
# calculates the shift amount by adding the corresponding letter of the key to the ASCII code of the plaintext character, subtracting
# twice the ASCII code of 'A', and taking the result modulo 26. This ensures that the shifted character remains within the range of
# capital letters. The shifted character is then converted back to a letter and added to the ciphertext.
#
# The decrypt() method takes two parameters: the ciphertext message and the key. It converts the ciphertext and key to uppercase,
# and then iterates over each character of the ciphertext message. If the character is not a letter, it skips it. Otherwise, it
# calculates the shift amount by subtracting the corresponding letter of the key from the ASCII code of the ciphertext character,
# adding 26 to ensure that the result is non-negative, and taking the result modulo 26. This recovers the original plaintext character,
# which is then added to the plaintext.

class VigenereCipher:
    
    def main():
        # Define the key and plaintext message
        key = "SECRET"
        plaintext = "THIS IS A SECRET MESSAGE"
        
        # Encrypt the plaintext message using the key
        ciphertext = encrypt(plaintext, key)
        
        # Print the ciphertext and the key
        print("Ciphertext:", ciphertext)
        print("Key:", key)
        
        # Decrypt the ciphertext message using the key
        decrypted_text = decrypt(ciphertext, key)
        
        # Print the decrypted plaintext message
        print("Decrypted Text:", decrypted_text)

    # Method to encrypt a plaintext message using a key
    def encrypt(plaintext, key):
        ciphertext = ""
        plaintext = plaintext.upper()
        key = key.upper()
        for i in range(len(plaintext)):
            c = plaintext[i]
            if c < 'A' or c > 'Z': 
                continue
            # Shift the character by the corresponding letter of the key
            ciphertext += chr((ord(c) + ord(key[i % len(key)]) - 2 * ord('A')) % 26 + ord('A'))
        return ciphertext
    
    # Method to decrypt a ciphertext message using a key
    def decrypt(ciphertext, key):
        plaintext = ""
        ciphertext = ciphertext.upper()
        key = key.upper()
        for i in range(len(ciphertext)):
            c = ciphertext[i]
            if c < 'A' or c > 'Z':
                continue
            # Shift the character back by the corresponding letter of the key
            plaintext += chr((ord(c) - ord(key[i % len(key)]) + 26) % 26 + ord('A'))
        return plaintext
