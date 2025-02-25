import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(arr[i]);
        }

        int[] idx = new int[N];
        int answer = Integer.MAX_VALUE;
        int minIdx = 0;

        while (true) {
            int cMax = 0;
            int cMin = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                if (arr[i][idx[i]] > cMax) {
                    cMax = arr[i][idx[i]];
                }

                if (arr[i][idx[i]] < cMin) {
                    cMin = arr[i][idx[i]];
                    minIdx = i;
                }
            }

            answer = Math.min(answer, cMax - cMin);
            idx[minIdx]++;
            if (idx[minIdx] == M)
                break;

        }

        System.out.println(answer);

    }
}
