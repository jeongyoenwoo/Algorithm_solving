import java.io.*;
import java.util.*;

public class Main {

    public static int N, a, b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        if (a + b > N + 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
            list.add(i);
        }

        list.add(Math.max(a, b));

        for (int i = b - 1; i >= 1; i--) {
            list.add(i);
        }

        if (a == 1) {
            while (list.size() < N) {
                list.add(1, 1);
            }
        } else {
            while (list.size() < N) {
                list.add(0, 1);
            }
        }

        for (int i : list) {
            System.out.print(i + " ");
        }

    }
}
