import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] sortArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sortArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }

        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();

        int num = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], num);
                num++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i]));
            sb.append(" ");
        }

        System.out.println(sb);

    }

}
