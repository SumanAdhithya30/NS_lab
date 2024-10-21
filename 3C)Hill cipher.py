import numpy as np

# Function to convert a message (string) to a numerical vector
def message_to_vector(message):
    return np.array([[ord(char) - 97] for char in message])

# Function to convert a numerical vector back to a message (string)
def vector_to_message(vector):
    return ''.join([chr(int(num) + 97) for num in vector.flatten()])

# Function to encrypt the message using the key matrix
def encrypt(key_matrix, message):
    message_vector = message_to_vector(message)
    encrypted_vector = np.dot(key_matrix, message_vector) % 26  # Matrix multiplication mod 26
    return vector_to_message(encrypted_vector)

# Function to decrypt the encrypted message using the inverse key matrix
def decrypt(key_matrix, encrypted_message):
    inverse_key_matrix = find_inverse_key(key_matrix)
    encrypted_vector = message_to_vector(encrypted_message)
    decrypted_vector = np.dot(inverse_key_matrix, encrypted_vector) % 26  # Decrypt using inverse key matrix
    return vector_to_message(decrypted_vector)

# Function to find the inverse of the key matrix mod 26
def find_inverse_key(matrix):
    det = int(np.round(np.linalg.det(matrix)))  # Determinant of the matrix
    det_inv = pow(det, -1, 26)  # Modular inverse of determinant under mod 26
    matrix_mod_inv = (det_inv * np.round(np.linalg.inv(matrix) * det).astype(int) % 26)  # Inverse matrix mod 26
    return matrix_mod_inv

# Function to get the key matrix and message from the user
def get_key_and_message():
    print("Enter a 3x3 key matrix (integers):")
    key_matrix = [[int(input()) for _ in range(3)] for _ in range(3)]  # Input 3x3 matrix
    print("Enter a 3-letter message:")
    message = input().strip()
    return key_matrix, message

# Main program
key_matrix, message = get_key_and_message()

# Encrypt the message
encrypted_message = encrypt(key_matrix, message)
print("Encrypted message:", encrypted_message)

# Decrypt the encrypted message
decrypted_message = decrypt(key_matrix, encrypted_message)
print("Decrypted message:", decrypted_message)
