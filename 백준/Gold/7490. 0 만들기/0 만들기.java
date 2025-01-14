import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            char[] arr = new char[N];

            dfs(arr, 1, N);

            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void dfs(char[] arr, int cnt, int N) {
        if (cnt == N) {
            if (calculate(arr, N)) {
                for (int i = 1; i <= N; i++) {
                    if (i != N) {
                        sb.append(i);
                        sb.append(arr[i]);
                    } else
                        sb.append(i);
                }
                sb.append("\n");
            }
            return;
        }

        arr[cnt] = ' ';
        dfs(arr, cnt + 1, N);
        arr[cnt] = '+';
        dfs(arr, cnt + 1, N);
        arr[cnt] = '-';
        dfs(arr, cnt + 1, N);
    }

    public static boolean calculate(char[] arr, int N) {
        int sum = 0;

        for (int i = N; i > 1; i--) {
            int num = i;

            if (arr[i - 1] == '+') {
                sum += num;
            } else if (arr[i - 1] == '-') {
                sum -= num;
            } else {
                int result = i;
                int cnt = 1;
                while (arr[i - 1] == ' ') {
                    i--;
                    result = i * (int) Math.pow(10, cnt++) + result;
                }

                if (i - 1 >= 1 && arr[i - 1] == '-') {
                    sum -= result;
                } else {
                    sum += result;
                }
            }
        }

        if (arr[1] != ' ') {
            sum += 1;
        }

        if (sum == 0)
            return true;
        else
            return false;

    }

}
