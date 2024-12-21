import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] ducks = new int[len];

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == 'q')
                ducks[i] = 0;
            else if (c == 'u')
                ducks[i] = 1;
            else if (c == 'a')
                ducks[i] = 2;
            else if (c == 'c')
                ducks[i] = 3;
            else
                ducks[i] = 4;
        }

        int duck = 0, num = len;
        boolean[] used = new boolean[len];

        while (num > 0) {
            int idx = 0, total = 0;

            for (int i = 0; i < len; i++) {
                if (!used[i] && ducks[i] == idx) {
                    used[i] = true;
                    idx = (idx + 1) % 5;
                    total++;
                }
            }
            num -= total;
            if (total != 0 && total % 5 == 0) {
                duck++;
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(duck);

    }

    public static void check() {

    }
}
