using System;

public class Solution {
    static int answer=0;
    
    public void dfs(int idx, int depth, int sum, int[] number){
        if(depth==3){
            if(sum==0) answer++;
            return;
        }
        for(int i=idx;i<number.Length;i++){
           dfs(i+1,depth+1,sum+number[i],number); 
        }
    }
    public int solution(int[] number) {
        dfs(0,0,0,number);
        return answer;
    }
}