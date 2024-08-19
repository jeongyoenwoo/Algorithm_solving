import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Node> q = new LinkedList<>();
        
        int curTime = 0;
        int curWeight=0;
        int curEnd=0;
        int index=0;
        
        while(true){
            
            if(curEnd==truck_weights.length) break;
            
            curTime++;
            if(!q.isEmpty()&&q.peek().time+bridge_length==curTime){
                Node n = q.poll();
                curWeight -= n.weight;
                curEnd++;
            }
            
            if(index<truck_weights.length&&curWeight+truck_weights[index]<=weight){
                curWeight += truck_weights[index];
                q.offer(new Node(curTime,truck_weights[index]));
                index++;
            }
            
        }
        
        return curTime;
    }
    
    public static class Node{
        int time;
        int weight;
        
        public Node(int time, int weight){
            this.time = time;
            this .weight = weight;
        }
    }
}