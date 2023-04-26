# Author: Andrew AKA CyberPrudent
# Description:
#
# The program generates a public and private key pair for encrypting and decrypting messages. It generates two
# random prime numbers p and q of size N/2 bits, where N is the key size in bits (in this case, N is set to 128).
# It then calculates the Euler's totient function of p and q and uses it to calculate the private and public keys.
# The public key consists of a modulus n and an exponent e, while the private key consists of the same modulus n
# and an exponent d.
#
# To encrypt a message, the program takes the message as an integer and raises it to the power of the public exponent e
# modulo n. The resulting value is the ciphertext. To decrypt the ciphertext, the program takes the ciphertext as an
# integer and raises it to the power of the private exponent d modulo n. The resulting value is the original plaintext.
#
# The program generates a random message m that is smaller than the modulus n and encrypts and decrypts it to demonstrate
# the encryption and decryption process. Finally, it prints the original message, the encrypted message, and the decrypted
# message to the console. To handle large integers, Python's pow() function can be used for modular exponentiation, and the
# pycryptodome or gmpy2 packages can be used to generate random large primes.

import random
from math import gcd

class RSA:
    # define constant of 1
    one = 1
    
    # define SecureRandom instance
    random_generator = random.SystemRandom()
    
    def __init__(self, n):
        # generate a prime number p of size N/2 bits
        p = self.generate_prime_number(n)
        # generate a prime number q of size N/2 bits
        q = self.generate_prime_number(n)
        # calculate Euler's totient function of p and q
        phi = (p - self.one) * (q - self.one)
        # calculate the modulus
        self.modulus = p * q
        # choose a public exponent (often 65537 = 2^16+1)
        self.public_key = 65537
        # calculate the private key
        self.private_key = self.mod_inverse(self.public_key, phi)

    def generate_prime_number(self, n):
        """Generates a prime number of n bits using the random number generator"""
        while True:
            num = self.random_generator.getrandbits(n)
            if self.is_prime(num):
                return num

    def is_prime(self, num):
        """Checks whether a given number is prime"""
        if num <= 3:
            return num > 1
        elif num % 2 == 0 or num % 3 == 0:
            return False
        i = 5
        while i * i <= num:
            if num % i == 0 or num % (i + 2) == 0:
                return False
            i += 6
        return True

    def mod_inverse(self, a, m):
        """Calculates the modular inverse of a mod m"""
        g, x, y = self.extended_gcd(a, m)
        if g != 1:
            raise ValueError('Modular inverse does not exist')
        return x % m

    def extended_gcd(self, a, b):
        """Calculates the greatest common divisor (gcd) of a and b, as well as their Bezout coefficients x and y"""
        x, y = 0, 1
        last_x, last_y = 1, 0
        while b != 0:
            quotient = a // b
            a, b = b, a % b
            x, last_x = last_x - quotient * x, x
            y, last_y = last_y - quotient * y, y
        return a, last_x, last_y

    def encrypt(self, message):
        """Encrypts the message using the public key"""
        return pow(message, self.public_key, self.modulus)

    def decrypt(self, encrypted):
        """Decrypts the ciphertext using the private key"""
        return pow(encrypted, self.private_key, self.modulus)

if __name__ == '__main__':
    # choose a key size
    N = 128
    # create an RSA object with a public and private key of N bits
    rsa = RSA(N)
    # generate a random number smaller than the modulus
    message = random.randint(0, rsa.modulus - 1)
    # encrypt the message using the RSA public key
    encrypted = rsa.encrypt(message)
    # decrypt the ciphertext using the RSA private key
    decrypted = rsa.decrypt(encrypted)
    # print results
    print(f'Original message: {message}')
    print(f'Encrypted message: {encrypted}')
    print(f'Decrypted message: {decrypted}')
