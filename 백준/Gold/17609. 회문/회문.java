import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            String str = br.readLine();
            System.out.println(process(str,0,str.length()-1,0));
        }
    }

    public static int process(String str, int left, int right, int count){
        if(count == 2) return 2;

        while( left < right ) {
            
         
            if (str.charAt(left) != str.charAt(right)) {
                int leftMove = process(str,left+1,right,count+1); 
                int rightMove = process(str,left,right-1,count+1); 
                return Math.min(leftMove,rightMove);
            }

            left++;
            right--;
        }
        return count;
    }
}