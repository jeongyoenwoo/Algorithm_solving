using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.Length];
        Stack<int> s = new Stack<int>();
        
        for(int i=0;i<numbers.Length;i++){
            int n = numbers[i];
            answer[i] = -1;
            while(s.Count>0){
                if(numbers[s.Peek()]>=n){
                    break;
                }
                
                answer[s.Pop()] = n;
            }
            s.Push(i);
        }
        
        return answer;
    }
}