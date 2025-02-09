import java.io.*;
import java.util.*;

public class Main {

    public static int N, T;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        String[] sdp = new String[N];

        dp[0] = 1;
        sb.append(arr[0]);
        sb.append(" ");
        sdp[0] = sb.toString();

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            sb.setLength(0);
            sb.append(arr[i]);
            sb.append(" ");
            sdp[i] = sb.toString();

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;

                        sb.setLength(0);
                        sb.append(sdp[j]);
                        sb.append(arr[i]);
                        sb.append(" ");
                        sdp[i] = sb.toString();
                    }
                }
            }
        }

        int maxIdx = 0;
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(sdp[maxIdx]);

    }

}
