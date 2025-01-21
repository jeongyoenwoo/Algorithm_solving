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

        while (true) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (max >= arr[i]) {
                    sum += arr[i];
                } else {
                    sum += max;
                }
            }

            if (sum <= M)
                break;
            else
                max--;
        }

        System.out.println(max);
    }
}
