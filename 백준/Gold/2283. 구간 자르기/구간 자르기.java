import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] count = new int[1000001];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            count[left]++;
            count[right]--;

            min = Math.min(min, left);
            max = Math.max(max, right);
        }

        for (int i = min + 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int start = min;
        int end = min;
        int cur = 0;
        int A = 0, B = 0;
        while (end <= max) {
            if (cur < K) {
                cur += count[end++];
            } else if (cur == K) {
                A = start;
                B = end;
                break;
            } else {
                cur -= count[start++];
            }
        }

        if (A == min)
            A = 0;

        System.out.println(A + " " + B);

    }

}
