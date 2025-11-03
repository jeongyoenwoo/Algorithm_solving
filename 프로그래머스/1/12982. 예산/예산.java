import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        int sum = 0;
        for(int price : d){
            if(sum+price>budget) break;
            else{
                sum+=price;
                answer++;
            }
        }
        return answer;
    }
}