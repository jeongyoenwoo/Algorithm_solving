using System;
using System.Collections.Generic;

public class Solution {
        public int[] solution(string[] maps) {
        int row = maps.Length;
        int col = maps[0].Length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
            
        char[,] m = new char[row,col];
        bool[,] visited = new bool[row,col];
            
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char c = maps[i][j];
                m[i,j] = c;
                if(c=='X'){
                    visited[i,j] = true;
                }
            }
        }
        
        List<int> answer = new List<int>();
        Stack<int[]> st = new Stack<int[]>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i,j]) continue;
                
                st.Push(new int[]{i,j});
                visited[i,j] = true;
                
                int sum = 0;
                while(st.Count>0){
                    int[] xy = st.Pop();
                    int x = xy[0];
                    int y = xy[1];
                    
                    sum += (m[x,y]-'0');
                    visited[x,y] = true;
                    
                    for(int k=0;k<4;k++){
                        int cx = x+dx[k];
                        int cy = y+dy[k];
                        
                        if(cx<0||cy<0||cx>=row||cy>=col) continue;
                        
                        if(!visited[cx,cy]){
                            st.Push(new int[]{cx,cy});
                            visited[cx,cy] = true;
                        }
                    }
                }
                
                answer.Add(sum);
            }
        }
        answer.Sort();
        if(answer.Count==0){
            answer = new List<int>{-1};
        }
        return answer.ToArray();
    }
}