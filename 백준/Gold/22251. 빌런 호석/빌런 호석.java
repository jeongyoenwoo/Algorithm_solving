import java.io.*;
import java.util.*;

public class Main {

    public static int N, K, P, X;
    public static int[][] number = { { 1, 1, 1, 0, 1, 1, 1 }, // 0
            { 0, 0, 1, 0, 0, 0, 1 }, // 1
            { 0, 1, 1, 1, 1, 1, 0 }, // 2
            { 0, 1, 1, 1, 0, 1, 1 }, // 3
            { 1, 0, 1, 1, 0, 0, 1 }, // 4
            { 1, 1, 0, 1, 0, 1, 1 }, // 5
            { 1, 1, 0, 1, 1, 1, 1 }, // 6
            { 0, 1, 1, 0, 0, 0, 1 }, // 7
            { 1, 1, 1, 1, 1, 1, 1 }, // 8
            { 1, 1, 1, 1, 0, 1, 1 } }; // 9
    public static long answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] numList = numToDigit(X);

        check(numList);

        System.out.println(answer);
    }

    public static int[] numToDigit(int num) {
        int[] result = new int[K];

        for (int i = K - 1; i >= 0; i--) {
            result[i] = num % 10;
            num /= 10;
        }

        return result;
    }

    public static void check(int[] numList) {
        for (int i = 1; i <= N; i++) {
            if (i == X)
                continue;
            if (can_change(i, numList)) {
                answer++;
            }
        }
    }

    public static boolean can_change(int target, int[] numList) {
        int[] targetDigit = numToDigit(target);

        int count = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if (number[numList[i]][j] != number[targetDigit[i]][j]) {
                    count++;
                }
                if (count > P) {
                    return false;
                }
            }
        }
        return true;
    }
}
