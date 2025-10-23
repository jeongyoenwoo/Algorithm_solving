using System;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Array.Sort(score);
        Array.Reverse(score);

        int start = 0;
        while(start+m<=score.Length){
            int min = k;
            for(int i=0;i<m;i++){
                min = Math.Min(k,score[start+i]);
            }
            answer+=(min*m);
                
            start+=m;
        }

        return answer;
    }
}