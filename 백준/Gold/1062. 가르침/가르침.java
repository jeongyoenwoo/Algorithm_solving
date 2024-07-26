import java.util.*;
import java.io.*;

public class Main {

    public static int N, K;
    public static boolean[] visited;
    public static int max = Integer.MIN_VALUE;
    public static String[] word;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        word = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }

        if (K < 5) {
            System.out.println("0");
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int a, int count) {
        if (count == K - 5) {
            int ans = 0;
            for (int i = 0; i < N; i++) {
                boolean check = true;

                for (int j = 0; j < word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    ans++;
                }
            }

            max = Math.max(max, ans);
            return;
        }

        for (int i = a; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
