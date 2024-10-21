from Crypto.Cipher import DES
from Crypto.Util.Padding import pad, unpad
from secrets import token_bytes

def generate_key():
    """Generates a random 8-byte key for DES."""
    return token_bytes(8)

def encrypt(plain_text, key):
    """Encrypts the plaintext using DES encryption with PKCS5 padding."""
    des = DES.new(key, DES.MODE_ECB)  # Create DES cipher object in ECB mode
    padded_text = pad(plain_text.encode('utf-8'), DES.block_size)  # PKCS5/7 padding
    cipher_text = des.encrypt(padded_text)  # Encrypt the padded text
    return cipher_text

def decrypt(cipher_text, key):
    """Decrypts the ciphertext using DES decryption and unpads the result."""
    des = DES.new(key, DES.MODE_ECB)  # Create DES cipher object in ECB mode
    decrypted_padded_text = des.decrypt(cipher_text)  # Decrypt the ciphertext
    decrypted_text = unpad(decrypted_padded_text, DES.block_size).decode('utf-8')  # Unpad and decode
    return decrypted_text

if __name__ == '__main__':
    # Input from the user
    plain_text = input("Enter the string to encrypt: ")

    # Generate key
    key = generate_key()

    # Encrypt the plain text
    encrypted_text = encrypt(plain_text, key)
    print(f"Encrypted Value: {encrypted_text}")

    # Decrypt the encrypted text
    decrypted_text = decrypt(encrypted_text, key)
    print(f"Decrypted Value: {decrypted_text}")
