import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] imp = new int[K + 1];
        int[] time = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            imp[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j - time[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - time[i]] + imp[i]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[K][i]);
        }

        System.out.println(max);
    }

}
