import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            int start = N - 1;
            int idx = start - 1;
            long result = 0;

            while (true) {
                if (idx < 0)
                    break;

                int max = list[start];

                if (list[idx] <= max) {
                    result += (max - list[idx]);
                    idx--;
                } else {
                    start = idx;
                }
            }

            sb.append(result);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
