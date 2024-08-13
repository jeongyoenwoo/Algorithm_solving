import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static Integer[] rope;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Comparator.reverseOrder());

        int total = 0;
        for (int i = 0; i < N; i++) {
            total = Math.max(total, rope[i] * (i + 1));
        }

        System.out.println(total);
    }

}
