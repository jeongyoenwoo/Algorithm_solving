import java.io.*;
import java.util.*;

public class Main {

    static int MOD = 1000000003;
    public static int N, K;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= (i + 1) / 2; j++) {

                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;

            }
        }

        System.out.println((dp[N - 3][K - 1] + dp[N - 1][K]) % MOD);
    }
}
