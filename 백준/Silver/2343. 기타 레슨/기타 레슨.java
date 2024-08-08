import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static int sum = 0;
    public static int[] lecture;
    public static int maxLecture = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lecture = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            sum += lecture[i];

            if (lecture[i] > maxLecture) {
                maxLecture = lecture[i];
            }
        }
        System.out.println(binarySearch(maxLecture, sum));
    }

    public static int binarySearch(int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (getCount(mid) > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static int getCount(int mid) {
        int count = 1;
        int remain = mid;

        for (int i = 0; i < N; i++) {
            if (remain < lecture[i]) {
                remain = mid;
                count++;
            }

            remain -= lecture[i];
        }

        return count;
    }

}
