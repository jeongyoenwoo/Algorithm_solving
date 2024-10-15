import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;      
        int curWeight=0;
        int index=0;
        Queue<Node> q = new LinkedList<>();
        
        
        while(true){
            
            time++;

            if(!q.isEmpty()&&q.peek().time+bridge_length==time) {
                curWeight-=q.peek().weight;
                q.poll();
            }
            if(index==truck_weights.length&&q.isEmpty()){
                break;
            }
            if(index<truck_weights.length&&curWeight+truck_weights[index]<=weight){
                curWeight+=truck_weights[index];
                q.offer(new Node(truck_weights[index++],time));
            }
            
        }
        
        return time;
    }
    
    public static class Node{
        int weight;
        int time;
        
        public Node(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
}