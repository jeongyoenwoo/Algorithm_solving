using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int n, long left, long right) {
        List<int> answer = new List<int>();
        
        for(long i=left;i<=right;i++){
            int x = (int)(i/n);
            int y = (int)(i%n);
            
            int value = x>y?x+1:y+1;
            answer.Add(value);
        }

        return answer.ToArray();
    }
}