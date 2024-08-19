import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (end < N && start <= end) {
            int diff = Math.abs(arr[start] - arr[end]);

            if (diff == M) {
                min = diff;
                break;
            } else if (diff > M) {
                min = Math.min(min, diff);
                start += 1;
            } else {
                end += 1;
            }
        }

        System.out.println(min);

    }

}
