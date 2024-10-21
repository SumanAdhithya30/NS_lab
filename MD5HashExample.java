import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class MD5HashExample {

    // Method to generate MD5 hash for the given input
    public static String getMD5(String input) {
        try {
            // Create an instance of the MessageDigest class with MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Pass the input string's bytes to the digest method and calculate the hash
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert the byte array into a BigInteger (positive)
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert the BigInteger into a hexadecimal string
            String hashtext = no.toString(16);

            // Ensure that the hash is 32 characters long by padding with leading zeros
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Example input text
        String input = "Hello MD5!";

        // Get the MD5 hash of the input text
        String md5Hash = getMD5(input);

        // Print the original text and its MD5 hash
        System.out.println("Original Text: " + input);
        System.out.println("MD5 Hash: " + md5Hash);
    }
}
