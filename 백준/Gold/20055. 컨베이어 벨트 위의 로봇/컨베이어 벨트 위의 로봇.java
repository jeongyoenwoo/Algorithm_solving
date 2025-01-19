import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[(2 * N) + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= (2 * N); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        Queue<Integer> robot = new LinkedList<>();

        while (!endCheck()) {
            time++;

            // 과정1
            int temp = arr[2 * N];
            for (int i = (2 * N); i > 1; i--) {
                arr[i] = arr[i - 1];
            }
            arr[1] = temp;

            int robotSize = robot.size();
            for (int i = 0; i < robotSize; i++) {
                int robotLoc = robot.poll();

                if (robotLoc == N)
                    continue;

                robot.offer(robotLoc + 1);
            }

            // 과정2
            robotSize = robot.size();

            for (int i = 0; i < robotSize; i++) {
                int robotLoc = robot.poll();

                if (robotLoc == N)
                    continue;

                if (!robot.contains(robotLoc + 1) && arr[robotLoc + 1] != 0) {
                    arr[robotLoc + 1]--;
                    robot.offer(robotLoc + 1);
                } else {
                    robot.offer(robotLoc);
                }

            }

            // 과정3
            if (arr[1] != 0) {
                arr[1]--;
                robot.offer(1);
            }

        }

        System.out.println(time);
    }

    public static boolean endCheck() {
        int zeroNum = 0;

        for (int i = 1; i <= (2 * N); i++) {
            if (arr[i] == 0)
                zeroNum++;
        }

        if (zeroNum >= K)
            return true;
        else
            return false;

    }

}
