# Author: CyberPrudent AKA Andrew
# Description: This program implements a simple Substitution Cipher, which is a method of encryption that replaces each letter
# in the plaintext with a different letter in the ciphertext, according to a predefined substitution key. The program defines
# the substitution key as a dictionary from plaintext characters to ciphertext characters.
#
# The program includes three methods. The first method, encrypt(message), takes a plaintext message as input and returns the
# corresponding ciphertext message, by replacing each letter in the plaintext with the corresponding letter in the substitution key.
# Non-letter characters are left unchanged.
#
# The second method, decrypt(message), takes a ciphertext message as input and returns the corresponding plaintext message, by
# replacing each letter in the ciphertext with the corresponding letter in the inverse substitution key (i.e., by swapping the keys
# and values of the substitution key). Non-letter characters are left unchanged.
#
# The third method, main(), prompts the user to enter a message to encrypt, encrypts the message using the encrypt() method, prints the
# encrypted message, decrypts the encrypted message using the decrypt() method, and prints the decrypted message.

class SubstitutionCipher:
    # Define the substitution key as a dictionary from plaintext characters to ciphertext characters
    SUBSTITUTION_KEY = {
        'a': 'm', 'b': 'n', 'c': 'o', 'd': 'p', 'e': 'q', 'f': 'r', 'g': 's', 'h': 't',
        'i': 'u', 'j': 'v', 'k': 'w', 'l': 'x', 'm': 'y', 'n': 'z', 'o': 'a', 'p': 'b',
        'q': 'c', 'r': 'd', 's': 'e', 't': 'f', 'u': 'g', 'v': 'h', 'w': 'i', 'x': 'j',
        'y': 'k', 'z': 'l'
    }
    
    # Encrypt a message using the substitution cipher
    @staticmethod
    def encrypt(message):
        result = []
        for c in message:
            # If the character is a letter, substitute it with the corresponding ciphertext character
            if c.isalpha():
                result.append(SubstitutionCipher.SUBSTITUTION_KEY.get(c.lower(), c))
            # If the character is not a letter, leave it unchanged
            else:
                result.append(c)
        return ''.join(result)
    
    # Decrypt a message using the substitution cipher
    @staticmethod
    def decrypt(message):
        result = []
        for c in message:
            # If the character is a letter, substitute it with the corresponding plaintext character
            if c.isalpha():
                for key, value in SubstitutionCipher.SUBSTITUTION_KEY.items():
                    if value == c.lower():
                        result.append(key)
                        break
            # If the character is not a letter, leave it unchanged
            else:
                result.append(c)
        return ''.join(result)
    
    # Main method for testing
    @staticmethod
    def main():
        message = input("Enter a message to encrypt: ")
        encrypted_message = SubstitutionCipher.encrypt(message)
        print("Encrypted message: " + encrypted_message)
        decrypted_message = SubstitutionCipher.decrypt(encrypted_message)
        print("Decrypted message: " + decrypted_message)

if __name__ == '__main__':
    SubstitutionCipher.main()
