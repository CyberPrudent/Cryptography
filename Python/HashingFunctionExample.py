# Author: CyberPrudent AKA Andrew
# Description:
#
# If you're interested in learning about more advanced hashing algorithms, check out the Central-Dogma-Hash-Algorithm.
# This algorithm was developed as part of a team project and is significantly more complicated than this example as we made
# sure to create a hashing algorithm from scratch that is one-way and with a low probability of collision. You can try out the 
# Central-Dogma-Hash-Algorithm for yourself on our project website at https://andrew-musa.github.io/cpsc329/.
#
# This program prompts the user to enter a string to hash and computes the SHA-256 hash value of the input string.
# It then converts the hash value to a hexadecimal string and prints the resulting hashed string to the console.
#
# The program uses the hashlib module to compute the SHA-256 hash value of the input string. The input() function is used to
# read the user's input string, which is then encoded as a byte string using the .encode() method. The hashlib.sha256() function
# is called with this byte string to create a hash object, and the digest() method is called on the hash object to compute the
# hash value as a byte string.
#
# The program then iterates over each byte in the hash value byte string and converts it to a two-character hexadecimal string
# using the format() method with the "x" format code. It appends each resulting two-character hexadecimal string to a hex_hash
# string, which represents the hexadecimal hash string.
#
# Finally, the program prints the resulting hashed string to the console using the print() function and the hex_hash string.
# If there is an error while hashing the input string, the program prints an error message using the except block.


import hashlib # Import the hashlib module for hashing

print("Enter a string to hash: ") # Prompt the user to enter a string to hash
input_string = input() # Read the user input string

try:
    hash_object = hashlib.sha256(input_string.encode()) # Create a hash object with the SHA-256 algorithm and compute the hash value of the input string
    hash_value = hash_object.digest() # Get the hash value as a byte string

    hex_hash = "" # Create an empty string for constructing the hexadecimal hash string
    for byte in hash_value: # Iterate over the bytes in the hash value
        hex_byte = format(byte, "x") # Convert the byte to a two-character hexadecimal string
        if len(hex_byte) == 1: # If the string is only one character long, append a leading 0 to make it two characters
            hex_byte = "0" + hex_byte
        hex_hash += hex_byte # Append the hexadecimal string to the hash string

    print("Hashed String: " + hex_hash) # Print the hexadecimal hash string
except:
    print("Error: Unable to hash input string") # Print an error message if there was an error hashing the input string
