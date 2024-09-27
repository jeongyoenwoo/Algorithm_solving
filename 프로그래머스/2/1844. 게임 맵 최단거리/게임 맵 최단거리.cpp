#include<vector>
#include<queue>

using namespace std;


bool visited[101][101];
int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};

struct Node{
    int x;
    int y;
    int v;
};

int bfs(vector<vector<int> > maps,int n, int m){
    queue<Node> q;
    q.push({0,0,1});
    visited[0][0]=true;
    
    while(!q.empty()){
        Node node = q.front();
        q.pop();
        
        if(node.x==n-1&&node.y==m-1){
            return node.v;
        }
        
        for(int i=0;i<4;i++){
            int cx = node.x+dx[i];
            int cy = node.y+dy[i];
            
            if(cx<0||cy<0||cx>=n||cy>=m) continue;
            
            if(!visited[cx][cy]&&maps[cx][cy]==1){
                visited[cx][cy]=true;
                q.push({cx,cy,node.v+1});
            }
        }
    }
    
    return -1;
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    
    answer = bfs(maps,maps.size(),maps[0].size());
    
    return answer;
}