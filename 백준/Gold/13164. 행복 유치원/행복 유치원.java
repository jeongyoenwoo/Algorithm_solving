import java.util.*;
import java.io.*;

public class Main {

    public static int N, K;
    public static int[] num;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            list.add(num[i] - num[i - 1]);
        }

        Collections.sort(list);

        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += list.get(i);
        }

        System.out.println(ans);

    }

}
