import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            list.add(arr[i], i);

        }

        for (int i : list) {
            System.out.print(i);
            System.out.print(" ");
        }

    }

}
