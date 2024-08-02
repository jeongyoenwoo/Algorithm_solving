import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] names;
    public static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        names = new int[n];
        dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = Integer.parseInt(st.nextToken());
        }

        dp[n - 1] = 0;
        System.out.println(solution(0));

    }

    public static int solution(int idx) {

        if (dp[idx] < Integer.MAX_VALUE) {
            return dp[idx];
        }

        int remain = m - names[idx];

        for (int i = idx + 1; i <= n && remain >= 0; i++) {
            if (i == n) {
                dp[idx] = 0;
                break;
            }
            dp[idx] = Math.min(dp[idx], remain * remain + solution(i));
            remain -= names[i] + 1;
        }

        return dp[idx];
    }

}
