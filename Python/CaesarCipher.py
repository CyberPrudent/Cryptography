# Author: CyberPrudent AKA Andrew
# Description:
#
# The encrypt() method takes in a string message and an integer key, and returns the encrypted message.
# It loops through each character in the message and checks if it is a letter. If it is, it converts the character to uppercase,
# shifts it by the key value, and adds the shifted character to the encrypted message. It returns the encrypted message.
#
# The decrypt() method takes in a string message and an integer key, and returns the decrypted message.
# It loops through each character in the message and checks if it is a letter. If it is, it converts the character to uppercase,
# shifts it back by the key value, and adds the shifted character to the decrypted message. It returns the decrypted message.
#
# The main() method defines the message and key values, encrypts the message using the key value, and decrypts the encrypted 
# message using the same key value. It then prints out the original message, encrypted message, and decrypted message.

class CaesarCipher:
    
    @staticmethod
    def encrypt(message: str, key: int) -> str:
        encrypted = ""
        # Iterate through each character in the message
        for ch in message:
            # If the character is a letter, shift it by the key value
            if ch.isalpha():
                # Convert the character to uppercase and shift it by the key value
                ch = chr(((ord(ch.upper()) - ord('A') + key) % 26) + ord('A'))
            # Add the shifted character to the encrypted message
            encrypted += ch
        # Return the encrypted message
        return encrypted
    
    @staticmethod
    def decrypt(message: str, key: int) -> str:
        decrypted = ""
        # Iterate through each character in the message
        for ch in message:
            # If the character is a letter, shift it back by the key value
            if ch.isalpha():
                # Convert the character to uppercase and shift it back by the key value
                ch = chr(((ord(ch.upper()) - ord('A') - key + 26) % 26) + ord('A'))
            # Add the shifted character to the decrypted message
            decrypted += ch
        # Return the decrypted message
        return decrypted
    
    @staticmethod
    def main():
        # Define the message and key values
        message = "HELLO WORLD"
        key = 3
        # Encrypt the message using the key value
        encrypted_message = CaesarCipher.encrypt(message, key)
        # Decrypt the encrypted message using the same key value
        decrypted_message = CaesarCipher.decrypt(encrypted_message, key)
        
        # Print the original message, encrypted message, and decrypted message
        print("Original message: " + message)
        print("Encrypted message: " + encrypted_message)
        print("Decrypted message: " + decrypted_message)

# Call the main function
CaesarCipher.main()
