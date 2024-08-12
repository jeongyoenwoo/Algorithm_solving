import java.util.*;
import java.io.*;

public class Main {

    public static int N, K;
    public static int[] lines;
    public static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if (lines[i] > max)
                max = lines[i];
        }

        System.out.println(check(1, max + 1));
    }

    public static long check(long start, long end) {

        long mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (getCount(mid) >= N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start-1;

    }

    public static long getCount(long mid) {
        long count = 0;

        for (int i = 0; i < K; i++) {
            count += (lines[i] / mid);
        }

        return count;

    }

}
