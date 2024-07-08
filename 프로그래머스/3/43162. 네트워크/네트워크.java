class Solution {
    public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<computers[0].length;i++){
            if(!visited[i]){
                dfs(i,computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int n, int[][] computers){
        if(!visited[n]){
            visited[n]=true;
            for(int i=0;i<computers[0].length;i++){
                if(computers[n][i]==1){
                   dfs(i,computers); 
                }
            }
        }
    }
}