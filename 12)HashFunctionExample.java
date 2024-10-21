import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunctionExample {
    public static String calculateHash(String algorithm, String input) {
        try {
            // Create MessageDigest instance for the given algorithm
            MessageDigest md = MessageDigest.getInstance(algorithm);
            
            // Convert the input string to bytes and compute the hash
            byte[] hashBytes = md.digest(input.getBytes());
            
            // Convert byte array into hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convert byte to hexadecimal (00 to ff)
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Pad with leading zero if necessary
                }
                hexString.append(hex);
            }
            
            // Return the final hexadecimal hash value
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not found: " + algorithm, e);
        }
    }

    public static void main(String[] args) {
        // Input text to be hashed
        String inputText = "Hello, World!";
        
        // Calculate and print the hash for different algorithms
        System.out.println("Input Text: " + inputText);
        System.out.println("MD5 Hash: " + calculateHash("MD5", inputText));
        System.out.println("SHA-1 Hash: " + calculateHash("SHA-1", inputText));
        System.out.println("SHA-256 Hash: " + calculateHash("SHA-256", inputText));
    }
}
