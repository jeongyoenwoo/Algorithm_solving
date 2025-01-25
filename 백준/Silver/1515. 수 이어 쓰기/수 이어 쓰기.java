import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] arr = input.toCharArray(); 
        int arrP = 0; 

        int ans = 1; 

        while(arrP < arr.length){

            String num = Integer.toString(ans);
            
         
            for(int i=0;i<num.length();i++){
                if(num.charAt(i) == arr[arrP]){ 
                    arrP++; 
                }
                if(arrP >= arr.length) break;
            }
            ans = ans + 1;
        }
        System.out.println(ans-1);
    }
}