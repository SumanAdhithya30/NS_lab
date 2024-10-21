def perform_operations(string):
    and_result = ""
    or_result = ""
    xor_result = ""
    
    for char in string:
        # AND operation with 127
        and_result += chr(ord(char) & 127)
        
        # OR operation with 127
        or_result += chr(ord(char) | 127)
        
        # XOR operation with 127
        xor_result += chr(ord(char) ^ 127)

    return and_result, or_result, xor_result

def main():
    input_string = "Hello World"
    
    # Perform AND, OR, and XOR operations
    and_res, or_res, xor_res = perform_operations(input_string)
    
    # Print results
    print(f"Original String: {input_string}")
    print(f"AND with 127: {and_res}")
    print(f"OR with 127: {or_res}")
    print(f"XOR with 127: {xor_res}")

if __name__ == "__main__":
    main()

