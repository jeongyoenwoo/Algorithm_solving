import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<wires.length;i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        for(int i=0;i<wires.length;i++){
           int v1 = wires[i][0];
           int v2 = wires[i][1];
           list.get(v1).remove(Integer.valueOf(v2));
           list.get(v2).remove(Integer.valueOf(v1));
           
           boolean[] visited = new boolean[n+1];
           
           int cnt = dfs(1, visited);
           int diff = Math.abs(cnt-(n-cnt));
           min = Math.min(min,diff);
           
           list.get(v1).add(v2);
           list.get(v2).add(v1);
       }
        
        return min;
    }
    
    static int dfs(int v, boolean[] visited){
        visited[v]=true;
        int cnt=1;
        
        for(Integer i : list.get(v)){
            if(!visited[i]){
                cnt+=dfs(i,visited);
            }
        }
        
        return cnt;
    }
    
}