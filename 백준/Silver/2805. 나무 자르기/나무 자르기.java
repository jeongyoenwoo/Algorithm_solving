import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] woods;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        woods = new int[N];
        int right = Integer.MIN_VALUE;
        int left = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            woods[i] = height;
            right = Math.max(right, height);
        }

        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            if (check(mid) >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

    }

    public static long check(int mid) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (woods[i] > mid) {
                sum += (woods[i] - mid);
            }
        }

        return sum;
    }

}
