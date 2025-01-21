import java.io.*;
import java.util.*;

public class Main {

    public static int N, X;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;

        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        long max = sum;
        int num = 1;

        for (int i = X; i < N; i++) {
            sum -= arr[i - X];
            sum += arr[i];

            if (max < sum) {
                max = sum;
                num = 1;
            } else if (max == sum) {
                num++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(num);
        }

    }
}
