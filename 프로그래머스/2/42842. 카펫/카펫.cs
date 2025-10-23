using System;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
         for(int i=1;i<=yellow;i++){
             if(yellow%i!=0) continue;
             int a = i;
             int b = yellow/a;
             
             int sum = a*2+b*2+4;
             
             if(sum==brown){
                 answer[0] = b+2;
                 answer[1] = a+2;
                
                 break;
             }
         }
        return answer;
    }
}