import java.io.*;
import java.util.*;

public class Main {

    public static int N, d, k, c;
    public static int[] belt;
    public static int[] sushi;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        belt = new int[N];
        sushi = new int[d + 1];

        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int max = 1;
        sushi[c]++;

        for (int i = 0; i < k; i++) {
            if (sushi[belt[i]] == 0) {
                max++;
            }
            sushi[belt[i]]++;
        }

        int answer = max;
        int start = 0;
        for (int i = k; i < N; i++) {
            sushi[belt[start]]--;
            if (sushi[belt[start]] == 0) {
                answer -= 1;
            }

            if (sushi[belt[i]] == 0) {
                answer++;
            }
            sushi[belt[i]]++;

            max = Math.max(max, answer);
            start++;
        }

        for (int i = 0; i < k - 1; i++) {
            sushi[belt[start]]--;
            if (sushi[belt[start]] == 0) {
                answer -= 1;
            }

            if (sushi[belt[i]] == 0) {
                answer++;
            }
            sushi[belt[i]]++;
            max = Math.max(max, answer);
            start++;
        }

        System.out.println(max);
    }

}
