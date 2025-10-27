namespace c_;

using System;
using System.Text;
class Program
{
    static long Cal(long a, long b)
    {
        if (b == 0)
        {
            return a;
        }

        long temp = b;
        b = a % b;
        a = temp;
        return Cal(a, b);
    }
    static void Main(string[] args)
    {

        int n = int.Parse(Console.ReadLine());
        long[] num = new long[n];

        for (int k = 0; k < n; k++)
        {
            string[] s = Console.ReadLine().Split();

            long a = long.Parse(s[0]);
            long b = long.Parse(s[1]);

            long gcd = Cal(a, b);

            num[k] = (long)(a * b) / gcd;
        }

        for (int i = 0; i < n; i++)
        {
            Console.WriteLine(num[i]);
        }
    }
}
