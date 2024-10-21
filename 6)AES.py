from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

def generate_key():
    return get_random_bytes(32)  # 32 bytes for AES-256

def encrypt(plain_text, key):
    cipher = AES.new(key, AES.MODE_CBC)
    return cipher.iv, cipher.encrypt(pad(plain_text.encode(), AES.block_size))

def decrypt(cipher_text, key, iv):
    cipher = AES.new(key, AES.MODE_CBC, iv)
    return unpad(cipher.decrypt(cipher_text), AES.block_size).decode()

# Example usage:
key = generate_key()
iv, encrypted_text = encrypt("Hello AES", key)
decrypted_text = decrypt(encrypted_text, key, iv)

print(f"Encrypted: {encrypted_text}")
print(f"Decrypted: {decrypted_text}")
