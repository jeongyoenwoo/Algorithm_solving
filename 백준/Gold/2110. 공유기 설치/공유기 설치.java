import java.util.*;
import java.io.*;

public class Main {

    public static int N, C;
    public static int[] home;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
            if (home[i] > max)
                max = home[i];
        }

        Arrays.sort(home);

        System.out.println(check(1, max));
    }

    public static int check(int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (getCount(mid) < C) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start - 1;
    }

    public static int getCount(int mid) {
        int count = 1;
        int index = home[0];
        for (int i = 1; i < N; i++) {
            if (home[i] - index >= mid) {
                index = home[i];
                count++;
            }
        }

        return count;
    }
}
