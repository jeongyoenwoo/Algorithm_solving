import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] memory;
    public static int[] cost;
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N + 1];
        cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][10001];

        for (int i = 1; i <= N; i++) {
            int m = memory[i];
            int c = cost[i];

            for (int j = 0; j <= 10000; j++) {
                if (i == 1) {
                    if (j >= c)
                        dp[i][j] = m;
                } else {
                    if (j >= c)
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + m);
                    else
                        dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] >= M)
                    min = Math.min(min, j);
            }
        }

        System.out.println(min);
    }

}
