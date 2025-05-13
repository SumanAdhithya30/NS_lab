using System;

class HillCipher
{
    // Key matrix (2x2)
    static int[,] keyMatrix = {
        { 3, 3 },
        { 2, 5 }
    };

    static int Modulo26(int x)
    {
        return (x % 26 + 26) % 26;
    }

    static string Encrypt(string message)
    {
        message = message.ToUpper().Replace(" ", "");
        if (message.Length % 2 != 0)
            message += "X"; // padding

        char[] encrypted = new char[message.Length];

        for (int i = 0; i < message.Length; i += 2)
        {
            int[] pair = {
                message[i] - 'A',
                message[i + 1] - 'A'
            };

            encrypted[i] = (char)(Modulo26(pair[0] * keyMatrix[0, 0] + pair[1] * keyMatrix[0, 1]) + 'A');
            encrypted[i + 1] = (char)(Modulo26(pair[0] * keyMatrix[1, 0] + pair[1] * keyMatrix[1, 1]) + 'A');
        }

        return new string(encrypted);
    }

    static void Main()
    {
        Console.WriteLine("Enter message to encrypt (letters only):");
        string message = Console.ReadLine();
        string encrypted = Encrypt(message);
        Console.WriteLine("Encrypted Message: " + encrypted);
    }
}
