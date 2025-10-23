using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[5] {1,2,3,4,5};
        int[] b = new int[8] {2,1,2,3,2,4,2,5};
        int[] c = new int[10] {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3] {0,0,0};
        List<int> nList = new List<int>();
        
        for(int i=0;i<answers.Length;i++){
            if(answers[i]==a[i%5]) score[0]++;
            if(answers[i]==b[i%8]) score[1]++;
            if(answers[i]==c[i%10]) score[2]++;
        }
        
        int max = 0;
        for(int i=0;i<3;i++){
            max = Math.Max(max,score[i]);
        }
        for(int i=0;i<3;i++){
            if(max==score[i]) nList.Add(i+1);
        }
        
        
        return nList.ToArray();
    }
}