import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        int index=0;
        for(int i=0;i<citations.length;i++){
            int num = citations.length - i; // 인용된 논문의 수
            
            if(citations[i]>=num) {
                index=num;
                break;
            }
        }
        
        return index;
    }
}