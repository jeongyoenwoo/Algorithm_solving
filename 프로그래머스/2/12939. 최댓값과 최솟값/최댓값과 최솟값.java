import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int strSize = str.length;
        int[] list = new int[strSize];
        
        for(int i=0;i<strSize;i++){
            list[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(list);
        
        answer += Integer.toString(list[0]);
        answer += " ";
        answer+= Integer.toString(list[strSize-1]);
        
        return answer;
    }
}