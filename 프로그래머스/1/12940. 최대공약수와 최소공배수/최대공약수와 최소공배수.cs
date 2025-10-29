public class Solution {
    int gcd;
    
    public void cal(int a, int b){
        if(b==0){
            gcd = a;
            return;
        }
        
        int temp = b;
        b = a%b;
        a = temp;
        
        cal(a,b);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        

        if(n<m) cal(m,n);
        else cal(n,m);
        
        answer[0] = gcd;
        answer[1] = (n*m)/gcd;
        
        return answer;
    }
}