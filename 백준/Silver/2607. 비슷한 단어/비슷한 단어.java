import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        int result = 0;

        for (int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            int[] alphabet = new int[26];
            int sameCnt = 0;

            for (int j = 0; j < first.length(); j++) {
                int idx = first.charAt(j) - 'A';
                alphabet[idx]++;
            }

            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'A';
                if (alphabet[idx] > 0) {
                    sameCnt++;
                    alphabet[idx]--;
                }
            }

            if (first.length() == str.length() && (first.length() == sameCnt || first.length() - 1 == sameCnt)) {
                result++;
            }

            else if (first.length() == str.length() - 1 && str.length() - 1 == sameCnt) {
                result++;
            }

            else if (first.length() == str.length() + 1 && str.length() == sameCnt) {
                result++;
            }

        }

        System.out.println(result);

    }

}
