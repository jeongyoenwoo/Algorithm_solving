import java.io.*;
import java.util.*;

public class Main {

    public static int C, N;
    public static int[] costArr;
    public static int[] numArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101];
        Arrays.fill(dp, (C + 100) * 100);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = num; j <= C + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + cost);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i <= (C + 100); i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }

}
