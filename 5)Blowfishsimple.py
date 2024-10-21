from Crypto.Cipher import Blowfish
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

def generate_key():
    # Generate a 16-byte random key for Blowfish
    return get_random_bytes(16)

def encrypt(plain_text, key):
    # Encrypt the text using Blowfish
    cipher = Blowfish.new(key, Blowfish.MODE_ECB)
    padded_text = pad(plain_text.encode('utf-8'), Blowfish.block_size)  # Use inbuilt pad
    return cipher.encrypt(padded_text)

def decrypt(cipher_text, key):
    # Decrypt the text using Blowfish
    cipher = Blowfish.new(key, Blowfish.MODE_ECB)
    decrypted_padded_text = cipher.decrypt(cipher_text)
    return unpad(decrypted_padded_text, Blowfish.block_size).decode('utf-8')  # Use inbuilt unpad

# Example usage:
if __name__ == "__main__":
    key = generate_key()
    plain_text = "Hello Blowfish"
    
    encrypted = encrypt(plain_text, key)
    print(f"Encrypted: {encrypted}")

    decrypted = decrypt(encrypted, key)
    print(f"Decrypted: {decrypted}")
