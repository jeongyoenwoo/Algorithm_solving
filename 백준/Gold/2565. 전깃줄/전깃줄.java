import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static Integer[] dp;
    public static int[][] wire;
    public static int max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        wire = new int[N][2];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, recursive(i));
        }

        System.out.println(N - max);
    }

    public static int recursive(int num) {
        if (dp[num] == null) {
            dp[num] = 1;

            for (int i = num + 1; i < N; i++) {
                if (wire[num][1] < wire[i][1]) {
                    dp[num] = Math.max(dp[num], recursive(i) + 1);
                }
            }
        }

        return dp[num];
    }

}
