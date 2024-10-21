import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1HashExample {

    public static String getSHA1(String input) {
        try {
            // Create a MessageDigest instance for SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Compute the hash
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Append leading zero if needed
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Example input text
        String input = "Hello SHA-1!";

        // Get the SHA-1 hash of the input text
        String sha1Hash = getSHA1(input);

        // Print the SHA-1 hash
        System.out.println("Original Text: " + input);
        System.out.println("SHA-1 Hash: " + sha1Hash);
    }
}
