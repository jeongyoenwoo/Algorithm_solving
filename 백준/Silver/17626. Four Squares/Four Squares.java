import java.io.*;
import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int num = i - j * j;

                min = Math.min(min, dp[num]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[N]);

    }

}
