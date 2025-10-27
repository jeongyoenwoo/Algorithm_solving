using System;

class Solution 
{
    public int solution(int n) 
   {
        int answer = 0;
        string s = Convert.ToString(n,2);
        int count = 0;
        
        for(int i=0;i<s.Length;i++){
            if(s[i]=='1') count++;
        }
        
        while(true){
            n++;
            string str = Convert.ToString(n,2);
            
            int c = 0;
            for(int i=0;i<str.Length;i++){
                if(str[i]=='1') c++;
            }
            
            if(c==count) break;
        }

        answer = n;
        return answer;
    }
}