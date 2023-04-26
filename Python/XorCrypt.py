# Author: CyberPrudent AKA Andrew
# Description: To use this program, simply run it and enter a message and a key of the same length.
# The program will then encrypt the message using XOR with the key and print out the encrypted message.
# It will then decrypt the encrypted message using the same key and print out the decrypted message.
# I used Python's built-in bytearray type to represent the encrypted and decrypted messages as arrays of bytes.
# I also used Python's encode and decode methods to convert between strings and byte arrays.

def main():
    # Get the message to encrypt and the key from the user
    message = input("Enter a message to encrypt: ")
    key = input("Enter a key (must be the same length as the message): ")

    # Encrypt the message using XOR with the key
    encrypted = encrypt(message, key)
    print("Encrypted message:", encrypted)

    # Decrypt the encrypted message using XOR with the same key
    decrypted = decrypt(encrypted, key)
    print("Decrypted message:", decrypted)

def encrypt(message, key):
    # Convert the message and key to byte arrays
    message_bytes = message.encode('utf-8')
    key_bytes = key.encode('utf-8')

    # Create a byte array to hold the encrypted message
    encrypted_bytes = bytearray(len(message_bytes))

    # Perform XOR on each byte of the message and key and store the result in the encrypted message array
    for i in range(len(message_bytes)):
        encrypted_bytes[i] = message_bytes[i] ^ key_bytes[i]

    # Convert the encrypted message byte array back to a string and return it
    return encrypted_bytes.decode('utf-8')

def decrypt(encrypted, key):
    # Convert the encrypted message and key to byte arrays
    encrypted_bytes = encrypted.encode('utf-8')
    key_bytes = key.encode('utf-8')

    # Create a byte array to hold the decrypted message
    decrypted_bytes = bytearray(len(encrypted_bytes))

    # Perform XOR on each byte of the encrypted message and key and store the result in the decrypted message array
    for i in range(len(encrypted_bytes)):
        decrypted_bytes[i] = encrypted_bytes[i] ^ key_bytes[i]

    # Convert the decrypted message byte array back to a string and return it
    return decrypted_bytes.decode('utf-8')

if __name__ == '__main__':
    main()
