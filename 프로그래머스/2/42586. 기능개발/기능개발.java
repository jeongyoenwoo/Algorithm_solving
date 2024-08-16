import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }
            else{
                q.add((100-progresses[i])/speeds[i]+1);
            }
        }
        
        int count=1;
        int now = q.poll();
        while(!q.isEmpty()){
            if(now>=q.peek()){
                count++;
                q.poll();
            }
            else{
                list.add(count);
                count=1;
                now = q.poll();
            }
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
 
}