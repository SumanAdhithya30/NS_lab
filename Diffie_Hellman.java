import java.util.Scanner;

class Diffie_Hellman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the prime number (p) and primitive root (g)
        System.out.println("Enter modulo (p):");
        int p = sc.nextInt();

        System.out.println("Enter primitive root of " + p + ":");
        int g = sc.nextInt();

        // Alice and Bob choose their secret numbers
        System.out.println("Choose 1st secret number (Alice):");
        int a = sc.nextInt();

        System.out.println("Choose 2nd secret number (Bob):");
        int b = sc.nextInt();

        // Calculate public keys
        int A = (int) Math.pow(g, a) % p; // Alice's public key
        int B = (int) Math.pow(g, b) % p; // Bob's public key

        // Each computes the shared secret key
        int S_A = (int) Math.pow(B, a) % p; // Alice's secret key
        int S_B = (int) Math.pow(A, b) % p; // Bob's secret key

        // Check if both have the same secret key
        if (S_A == S_B) {
            System.out.println("Alice and Bob can communicate with each other!");
            System.out.println("They share a secret number = " + S_A);
        } else {
            System.out.println("Error: The secret keys do not match.");
        }

        sc.close(); // Close the scanner
    }
}
