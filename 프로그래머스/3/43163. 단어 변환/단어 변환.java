class Solution {
    static boolean[] visited;
    static int answer=0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(0,begin,target,words);
        
        return answer;
        
    }
    
    public static void dfs(int count,String begin, String target,String[] words){
        if(begin.equals(target)){
            answer = count;
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;
            
            int num=0;
            for(int j=0;j<begin.length();j++){
                if(begin.charAt(j)!=words[i].charAt(j)){
                    num++;
                }
            }
            
            if(num==1){
                visited[i]=true;
                dfs(count+1,words[i],target,words);
                visited[i]=false;
            }
        }
        
        
    }
}