import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        
        while(pq.size()!=1&&pq.peek()<K){
            int food1 = pq.poll();
            int food2 = pq.poll();
            
            int newFood = food1 + (food2*2);
            
            pq.offer(newFood);
            
            answer++;
        }
        
        if(pq.size()==1){
            if(pq.peek()<K) return -1;
        }
        return answer;
    }
}