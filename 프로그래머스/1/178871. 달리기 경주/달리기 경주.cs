using System;
using System.Collections.Generic;

public class Solution {
    public string[] solution(string[] players, string[] callings) {
        Dictionary<string,int> dic = new Dictionary<string,int>();
        
        for(int i=0;i<players.Length;i++){
            dic.Add(players[i],i);
        }
        
        foreach(string str in callings){
            int index = dic[str];
            
            string temp = players[index-1];
            players[index-1] = players[index];
            players[index] = temp;
            
            dic[str]--;
            dic[temp]++;
        }


        return players;
    }
}