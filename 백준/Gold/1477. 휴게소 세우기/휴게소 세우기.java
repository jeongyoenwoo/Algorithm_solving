import java.util.*;
import java.io.*;

public class Main {

    public static int N, M, L;
    public static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        road = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        road[0] = 0;
        road[N + 1] = L;
        Arrays.sort(road);

        int start = 1;
        int end = L;

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
        int count = 0;

        for (int i = 1; i <= N + 1; i++) {
            int dist = road[i] - road[i - 1];
            int num = (dist - 1) / mid;
            count += num;
        }

        return count;
    }

}
