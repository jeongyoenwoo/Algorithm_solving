import java.io.*;
import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] near = new int[N + 1];
        int[] cnt = new int[N + 1];
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            near[i] = -100000;
        }

        // 왼쪽 기준
        stack.push(1);
        for (int i = 2; i <= N; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            cnt[i] = stack.size();

            if (cnt[i] > 0)
                near[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

        // 오른른쪽 기준
        stack.push(N);
        for (int i = N - 1; i >= 1; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            int s = stack.size();
            cnt[i] += s;

            if (s > 0 && (i - near[i]) > (stack.peek() - i))
                near[i] = stack.peek();

            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(cnt[i]);

            if (cnt[i] != 0) {
                sb.append(" ");
                sb.append(near[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
