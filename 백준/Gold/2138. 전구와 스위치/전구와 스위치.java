import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static boolean[] now, want, nowA, nowB;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        now = new boolean[N];
        want = new boolean[N];

        switchState(br.readLine(), now);
        switchState(br.readLine(), want);

        nowA = new boolean[N];
        nowB = new boolean[N];

        int switchA = 1, switchB = 0;

        for (int i = 0; i < N; i++) {
            if (i <= 1) {
                nowA[i] = !now[i];
                nowB[i] = now[i];
            } else {
                nowA[i] = now[i];
                nowB[i] = now[i];
            }
        }

        for (int i = 1; i < N; i++) {
            if (nowA[i - 1] != want[i - 1]) {
                switchOn(i, nowA);
                switchA++;
            }
            if (nowB[i - 1] != want[i - 1]) {
                switchOn(i, nowB);
                switchB++;
            }

            if (Arrays.equals(nowA, want)) {
                if (Arrays.equals(nowA, nowB)) {
                    System.out.println(Math.min(switchA, switchB));
                    System.exit(0);
                }
                System.out.println(switchA);
                System.exit(0);
            }

            else if (Arrays.equals(nowB, want)) {
                System.out.println(switchB);
                System.exit(0);
            }
        }

        System.out.println(-1);
    }

    public static void switchState(String str, boolean[] switchName) {

        for (int i = 0; i < N; i++) {
            char n = str.charAt(i);
            if (n == '1') {
                switchName[i] = true;
            } else if (n == '0') {
                switchName[i] = false;
            }
        }
    }

    public static void switchOn(int idx, boolean[] switchName) {
        switchName[idx - 1] = !switchName[idx - 1];
        switchName[idx] = !switchName[idx];
        if (idx < N - 1) {
            switchName[idx + 1] = !switchName[idx + 1];
        }
    }
}
