public class Solution {
    public long solution(long n) {
        long answer = 0;
        
        bool check = false;
        long num = 0;
        for(long i=1;i*i<=n;i++){
            if(i*i==n){
                check = true;
                num = i;
                break;
            }
        }
        
        if(check){
            answer = (num+1)*(num+1);
        }
        else answer = -1;
        
        return answer;
    }
}