# Author: Andrew AKA CyberPrudent
# Description:
#
# The program is a demonstration of AES encryption using the Cipher Block Chaining (CBC) mode of operation
# with PKCS5 padding. The program first generates a random 128-bit key using get_random_bytes() function from the
# Crypto.Random module. It then creates an AES cipher object in CBC mode with the specified key using the AES.new() 
# function from the Crypto.Cipher module. The program generates a random 16-byte initialization vector (IV) using 
# get_random_bytes(), and then encrypts the plaintext message "Hello, world!" by calling the encrypt() method of the
# cipher object with the plaintext message padded to a multiple of the block size with null bytes. The program then
# converts the resulting ciphertext to a hexadecimal string using the binascii.hexlify() function. Next, the program
# decrypts the ciphertext to recover the original plaintext message by calling the decrypt() method of the cipher object
# with the ciphertext as input. Finally, the program removes the padding from the decrypted plaintext message and
# prints it to the console.

from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
import binascii

# Generate a random 128-bit AES key
key = get_random_bytes(16)

# Create an AES cipher object
cipher = AES.new(key, AES.MODE_CBC)

# Generate a random 16-byte initialization vector
iv = get_random_bytes(16)

# Encrypt the plaintext message
plaintext = b"Hello, world!"
plaintext_padded = plaintext + (16 - len(plaintext) % 16) * b"\0"
ciphertext = cipher.encrypt(plaintext_padded)

# Print the ciphertext as a hexadecimal string
ciphertext_hex = binascii.hexlify(ciphertext).decode('utf-8')
print("Ciphertext: " + ciphertext_hex)

# Decrypt the ciphertext to recover the plaintext message
cipher = AES.new(key, AES.MODE_CBC, iv)
decrypted_padded = cipher.decrypt(ciphertext)
decrypted = decrypted_padded.rstrip(b"\0").decode('utf-8')
print("Decrypted: " + decrypted)
