def caesar_cipher_encrypt(text, shift):
    result = ""

    # Loop through each character in the text
    for char in text:
        # Encrypt uppercase characters
        if char.isupper():
            result += chr((ord(char) + shift - 65) % 26 + 65)
        # Encrypt lowercase characters
        elif char.islower():
            result += chr((ord(char) + shift - 97) % 26 + 97)
        # Leave non-alphabetic characters unchanged
        else:
            result += char

    return result

def caesar_cipher_decrypt(text, shift):
    result = ""

    # Loop through each character in the text
    for char in text:
        # Decrypt uppercase characters
        if char.isupper():
            result += chr((ord(char) - shift - 65) % 26 + 65)
        # Decrypt lowercase characters
        elif char.islower():
            result += chr((ord(char) - shift - 97) % 26 + 97)
        # Leave non-alphabetic characters unchanged
        else:
            result += char

    return result

# Input
text = input("Enter the text: ")
shift = int(input("Enter the shift value: "))

# Encrypt the text
encrypted_text = caesar_cipher_encrypt(text, shift)
print(f"Encrypted text: {encrypted_text}")

# Decrypt the text
decrypted_text = caesar_cipher_decrypt(encrypted_text, shift)
print(f"Decrypted text: {decrypted_text}")

