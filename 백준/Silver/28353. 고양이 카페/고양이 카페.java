import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int answer = 0;

        while (left < right) {
            if (arr[left] + arr[right] <= K) {
                answer++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        System.out.println(answer);

    }
}
