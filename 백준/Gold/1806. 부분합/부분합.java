import java.io.*;
import java.util.*;

public class Main {

    public static int N, S;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < N) {
            sum += arr[end++];

            while (sum >= S) {
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++];
            }

        }

        System.out.println(minLen==Integer.MAX_VALUE ? 0 : minLen);
    }
}
