import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] arr;
    public static Integer[] diff;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if (K >= N) {
            System.out.println(0);
            System.exit(0);
        }

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        diff = new Integer[N - 1];

        for (int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        int result = 0;

        for (int i = K - 1; i < N - 1; i++) {
            result += diff[i];
        }

        System.out.println(result);

    }
}
