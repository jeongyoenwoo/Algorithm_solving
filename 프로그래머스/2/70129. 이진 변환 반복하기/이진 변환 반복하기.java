import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count=0;
        int zeroCount=0;
        
        while(true){
            count++;
            
           StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    zeroCount++;
                }
                else{
                    sb.append(s.charAt(i));
                }
            }   
            
            int len = sb.length();
            if(len==1) break;
            
            s = Integer.toBinaryString(len);
            
            
        }
        answer[0]=count;
        answer[1]=zeroCount;
        
        return answer;
    }
}