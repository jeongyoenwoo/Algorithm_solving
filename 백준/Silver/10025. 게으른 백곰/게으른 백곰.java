import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] ice;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ice = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            ice[x] = g;
        }

        int answer = 0;
        if ((K * 2 + 1) >= 1000000) {
            for (int i = 0; i <= 1000000; i++) {
                answer += ice[i];
            }

            System.out.println(answer);
            return;
        }

        int slideSum = 0;
        for (int i = 0; i < (K * 2 + 1); i++) {
            slideSum += ice[i];
        }
        answer = slideSum;

        for (int i = (K * 2 + 1); i <= 1000000; i++) {
            slideSum += ice[i];
            slideSum -= ice[i - (K * 2 + 1)];
            
            answer = Math.max(answer, slideSum);
        }

        System.out.println(answer);
    }

}
