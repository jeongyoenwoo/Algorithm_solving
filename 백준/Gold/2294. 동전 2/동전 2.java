import java.util.*;
import java.io.*;

public class Main {

    public static int N, K;
    public static int[] coins;
    public static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        dp = new int[K + 1];

        dp[0] = 0;
        for (int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[K] == Integer.MAX_VALUE-1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }

}
