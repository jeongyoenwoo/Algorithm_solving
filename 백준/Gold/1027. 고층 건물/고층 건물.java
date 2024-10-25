import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {

            int result = 0;
            double tmp = 0;

            // i번째 빌딩에서 왼쪽으로 탐색

            for (int left = i - 1; left >= 1; left--) {

                double grad = (double) (arr[left] - arr[i]) / (left - i);

                if (left == i - 1 || tmp > grad) {
                    tmp = grad;
                    result++;
                }
            }

            // i번째 빌딩에서 오른쪽으로 탐색

            for (int right = i + 1; right <= N; right++) {

                double grad = (double) (arr[right] - arr[i]) / (right - i);

                if (right == i + 1 || tmp < grad) {
                    tmp = grad;
                    result++;
                }
            }

            max = Math.max(max, result);
        }

        System.out.println(max);
    }

}
