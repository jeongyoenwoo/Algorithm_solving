import java.io.*;
import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long[] cnt = new long[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        cnt[N - 1] = 0;
        stack.push(N - 1);

        for (int i = N - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int s = stack.pop();

                cnt[i]++;
                cnt[i] += cnt[s];
            }

            stack.push(i);
        }

        long result = 0;
        for (int i = N - 1; i >= 0; i--) {
            result += cnt[i];
        }

        System.out.println(result);

    }

}
