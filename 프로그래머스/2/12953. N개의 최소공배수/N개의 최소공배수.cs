public class Solution {
    public int LCM(int a, int b){
        int n = b;
        int m = a;
        while(m!=0){
            int temp = m;
            m = n%m;
            n = temp;
        }
        
        return (a*b)/n;
    }
    public int solution(int[] arr) {
        int answer = LCM(arr[0],arr[1]);
        
        for(int i=2;i<arr.Length;i++){
            answer = LCM(answer,arr[i]);
        }
        return answer;
    }
}