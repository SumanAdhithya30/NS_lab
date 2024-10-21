import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Input two prime numbers from the user
        System.out.print("Enter a Prime number: ");
        BigInteger p = sc.nextBigInteger(); // First prime number

        System.out.print("Enter another Prime number: ");
        BigInteger q = sc.nextBigInteger(); // Second prime number

        // Calculate n = p * q (modulus for both keys)
        BigInteger n = p.multiply(q);

        // Calculate ?(n) = (p - 1) * (q - 1)
        BigInteger n2 = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Generate encryption key 'e'
        BigInteger e = generateE(n2);

        // Generate decryption key 'd' (modular inverse of e)
        BigInteger d = e.modInverse(n2);

        // Display the generated keys
        System.out.println("Encryption keys are: " + e + ", " + n);
        System.out.println("Decryption keys are: " + d + ", " + n);
    }

    public static BigInteger generateE(BigInteger fiofn) {
        int y, intGCD;
        BigInteger e;
        BigInteger gcd;
        Random x = new Random();

        // Generate 'e' such that gcd(e, ?(n)) = 1 and 1 < e < ?(n)
        do {
            y = x.nextInt(fiofn.intValue() - 1); // Random value less than ?(n)
            String z = Integer.toString(y);
            e = new BigInteger(z);
            gcd = fiofn.gcd(e); // Find gcd(e, ?(n))
            intGCD = gcd.intValue();
        } while (y <= 2 || intGCD != 1); // Ensure e is coprime with ?(n)

        return e;
    }
}