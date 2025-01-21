import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
            max = Math.max(max, num);
        }

        M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            int budget = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    budget += mid;
                } else {
                    budget += arr[i];
                }
            }

            if (budget <= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
