import java.util.*;
import java.io.*;

public class Main {

    public static int s;
    public static String n;
    public static char[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();
        int len = n.length();
        num = new char[len];

        for (int i = 0; i < len; i++) {
            num[i] = n.charAt(i);
        }

        for (int i = 0; i < len; i++) {
            System.out.print(" ");
            for (int j = 0; j < s; j++) {
                if (num[i] == '1' || num[i] == '4') {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }
            System.out.print(" ");
            System.out.print(" ");
        }

        System.out.println();

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < len; j++) {
                if (num[j] == '1' || num[j] == '2' || num[j] == '3' || num[j] == '7') {
                    System.out.print(" ");
                    for (int k = 0; k < s; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                } else if (num[j] == '5' || num[j] == '6') {
                    System.out.print("|");
                    for (int k = 0; k < s; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                    for (int k = 0; k < s; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < len; i++) {
            System.out.print(" ");
            for (int j = 0; j < s; j++) {
                if (num[i] == '1' || num[i] == '7' || num[i] == '0') {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }
            System.out.print(" ");
            System.out.print(" ");

        }

        System.out.println();

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < len; j++) {
                if (num[j] == '1' || num[j] == '3' || num[j] == '4' || num[j] == '5' || num[j] == '7'
                        || num[j] == '9') {
                    System.out.print(" ");
                    for (int k = 0; k < s; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                } else if (num[j] == '2') {
                    System.out.print("|");
                    for (int k = 0; k < s; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                    for (int k = 0; k < s; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < len; i++) {
            System.out.print(" ");
            for (int j = 0; j < s; j++) {
                if (num[i] == '1' || num[i] == '4' || num[i] == '7') {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }
            System.out.print(" ");
            System.out.print(" ");

        }
    }

}
