import java.util.*;
import java.io.*;

public class Main {

    public static int N, K;
    public static int[] arr;
    public static int max = Integer.MIN_VALUE;
    public static HashMap<Integer, Integer> map = new HashMap<>();

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

        int[] count = new int[100001];
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;

        while (end < N) {

            while (end < N && count[arr[end]] + 1 <= K) {
                count[arr[end++]]++;
            }

            max = Math.max(max, end - start);

            count[arr[start++]]--;
        }

        System.out.println(max);

    }

}
