import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(list);
        int answer = 0;

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];

                if (binarySearch(diff) && arr[i] > answer) {
                    answer = arr[i];
                }

            }
        }

        System.out.println(answer);
    }

    public static boolean binarySearch(int n) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) == n) {
                return true;
            } else if (list.get(mid) > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
