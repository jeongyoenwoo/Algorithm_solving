import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] weight;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        weight = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][40001];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 40000; j++) {
                if (dp[i - 1][j])
                    dp[i][j] = true;
                else {
                    if (weight[i] == j)
                        dp[i][j] = true;
                    else {
                        if (j < weight[i]) {
                            if (dp[i - 1][weight[i] - j])
                                dp[i][j] = true;
                        } else if (j > weight[i]) {
                            if (dp[i - 1][j - weight[i]])
                                dp[i][j] = true;
                        }

                        if (weight[i] + j <= 40000) {
                            if (dp[i - 1][weight[i] + j])
                                dp[i][j] = true;
                        }
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (dp[N][num]) {
                sb.append("Y");
            } else {
                sb.append("N");
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }

}
