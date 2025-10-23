using System;

public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            
            int mul = (n/a) *b;
            int div = n%a;
            
            answer+=mul;
            n = mul+div;
        }
        return answer;
    }
}