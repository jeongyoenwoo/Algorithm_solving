using System;
using System.Collections.Generic;

public class Solution {
    HashSet<int> trys = new HashSet<int>();
    string Numbers;
    int answer = 0;
    
    public void IsPrime(int num){
        if(trys.Contains(num)||num<2) return;
        
        trys.Add(num);
        
        bool check = true;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                check = false;
                break;
            }
        }
        
        if(check) answer++;
    }
    
    public void DFS(bool[] visited, string str){
        if(int.TryParse(str,out int ret)) IsPrime(ret);
        
        for(int i=0;i<Numbers.Length;i++){
            if(visited[i]) continue;
            
            visited[i]=true;
            DFS(visited,str+Numbers[i]);
            visited[i]=false;
        }
    }
    public int solution(string numbers) {
        Numbers = numbers;
        bool[] visited = new bool[numbers.Length];
        
        DFS(visited,"");
        
        return answer;
    }
}