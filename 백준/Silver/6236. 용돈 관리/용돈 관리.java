import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static int[] money;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
        }

        int start = max;
        int end = 10000 * 100000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (getCount(mid) > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(start);
    }

    public static int getCount(int mid) {
        int count = 1;
        int remain = mid;

        for (int i = 0; i < money.length; i++) {
            if (remain < money[i]) {
                remain = mid;
                count++;
            }
            remain -= money[i];
        }

        return count;
    }

}
