public class Solution {
    public int solution(int n) {
        int MOD = 1234567;
        long a = 0;
        long b = 1;
        
        for(int i=2;i<=n;i++){
            long temp = (a+b)%MOD;
            a = b;
            b = temp;
        }
        
        return (int)b;
    }
}