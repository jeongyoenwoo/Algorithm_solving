import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, H;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][1001];
        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= H; j++) {
                for (Integer integer : list[i]) {
                    if (j >= integer) {
                        dp[i][j] += dp[i - 1][j - integer];
                        dp[i][j] %= 10007;
                    }
                }

                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[N][H]);
    }

}
