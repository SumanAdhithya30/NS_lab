import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

public class BlowFishCipher {
    public static void main(String[] args) throws Exception {
        // 1. Generate a Blowfish key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        SecretKey secretKey = keyGenerator.generateKey();

        // 2. Create a Blowfish Cipher
        Cipher cipher = Cipher.getInstance("Blowfish");

        // 3. Encrypt the message
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String inputText = JOptionPane.showInputDialog("Enter a message: ");
        byte[] encrypted = cipher.doFinal(inputText.getBytes());

        // 4. Decrypt the message
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);

        // 5. Show encrypted and decrypted message
        JOptionPane.showMessageDialog(null, 
            "Encrypted Text: " + new String(encrypted) + "\nDecrypted Text: " + new String(decrypted));

        System.exit(0);
    }
}
