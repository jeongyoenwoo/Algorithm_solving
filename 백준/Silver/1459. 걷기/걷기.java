import java.io.*;
import java.util.*;

public class Main {

    public static long X, Y, W, S;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        long temp1, temp2, temp3, temp4;

        temp1 = (X + Y) * W;

        if ((X + Y) % 2 == 0) {
            temp2 = Math.max(X, Y) * S;
        } else {
            temp2 = (Math.max(X, Y) - 1) * S + W;
        }

        temp3 = Math.min(X, Y) * S + Math.abs(X - Y) * W;

        System.out.println(Math.min(temp1, Math.min(temp2, temp3)));

    }

}
