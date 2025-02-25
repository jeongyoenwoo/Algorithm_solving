import java.io.*;
import java.util.*;

public class Main {

    public static int T, W;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[] jadu = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[T + 1][W + 1][3];

        if (jadu[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][0] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int i = 2; i <= T; i++) {
            if (jadu[i] == 1) {
                dp[i][0][1] = dp[i - 1][0][1] + 1;
                dp[i][0][2] = dp[i - 1][0][2];

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                }
            }

            else if (jadu[i] == 2) {
                dp[i][0][1] = dp[i - 1][0][1];
                dp[i][0][2] = dp[i - 1][0][2] + 1;

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }

        }

        int max = 0;

        for (int w = 0; w <= W; w++) {
            max = Math.max(max, Math.max(dp[T][w][1], dp[T][w][2]));
        }

        System.out.print(max);
    }

}
