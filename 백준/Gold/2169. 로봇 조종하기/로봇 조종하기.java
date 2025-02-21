import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static int[][] dp;
    public static int[][] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        temp = new int[2][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int j = 1; j <= M; j++) {
            dp[1][j] = dp[1][j - 1] + map[1][j];
        }

        for (int i = 2; i <= N; i++) {

            // 위쪽과 왼쪽 비교
            temp[0][1] = dp[i - 1][1] + map[i][1];
            for (int j = 2; j <= M; j++) {
                temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + map[i][j];
            }

            // 위쪽과 오른쪽 비교
            temp[1][M] = dp[i - 1][M] + map[i][M];
            for (int j = M - 1; j >= 1; j--) {
                temp[1][j] = Math.max(dp[i - 1][j], temp[1][j + 1]) + map[i][j];
            }

            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N][M]);

    }

}
