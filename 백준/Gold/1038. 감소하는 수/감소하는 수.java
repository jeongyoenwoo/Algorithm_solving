import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        if (N <= 10) {
            System.out.print(N);
        } else if (N > 1022) {
            System.out.print(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            
            Collections.sort(list);

            System.out.print(list.get(N));
        }

       
    }

    public static void bp(long num, int idx) {
        if (idx > 10)
            return;

        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }

}
