import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long ans = 0;
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            if (num > 0)
                break;

            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                int sum = num + arr[start] + arr[end];

                if (sum == 0) {
                    int left = 1;
                    int right = 1;

                    if (arr[start] == arr[end]) {
                        int n = end - start + 1;
                        ans += n * (n - 1) / 2;
                        break;
                    }

                    while (arr[start] == arr[start + 1]) {
                        start++;
                        left++;
                    }

                    while (arr[end] == arr[end - 1]) {
                        end--;
                        right++;
                    }

                    ans += left * right;

                }

                if (sum > 0)
                    end--;
                else
                    start++;
            }

        }

        System.out.println(ans);
    }

}