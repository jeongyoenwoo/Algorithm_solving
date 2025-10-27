namespace c_;

using System;
using System.Text;
class Program
{

    static int cal(int N, int K)
    {
        return factorial(N) / (factorial(N - K) * factorial(K));
    }

    static int factorial(int i)
    {
        if (i <= 0)
        {
            return 1;
        }

        return i * factorial(i - 1);
    }
    static void Main(string[] args)
    {
        string[] s = Console.ReadLine().Split();

        int N = int.Parse(s[0]);
        int K = int.Parse(s[1]);

        int answer = cal(N, K);

        Console.WriteLine(answer);
    }
}
