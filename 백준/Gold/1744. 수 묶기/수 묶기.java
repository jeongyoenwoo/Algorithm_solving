import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] num;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        int index = N - 1;

        while (index >= 0 && num[index] > 0) {
            if (index == 0) {
                answer += num[index];
                break;
            } else {
                if (num[index] < num[index] * num[index - 1]) {
                    answer += (num[index] * num[index - 1]);
                    index -= 2;
                } else {
                    answer += num[index];
                    index -= 1;
                }
            }
        }

        index = 0;

        while (index < N && num[index] < 0) {
            if (index == N - 1) {
                answer += num[index];
                break;
            } else {
                if (num[index] < num[index] * num[index + 1]) {
                    answer += (num[index] * num[index + 1]);
                    index += 2;
                } else {
                    answer += num[index];
                    index += 1;
                }
            }
        }

        System.out.println(answer);
    }

}
