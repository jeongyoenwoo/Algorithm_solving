#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<bool> visited;

void bfs(vector<vector<int>> computers,int idx,int n){
    queue<int> q;
    visited[idx]=true;
    q.push(idx);
    
    while(!q.empty()){
        int num = q.front();
        q.pop();
        
        for(int i=0;i<n;i++){
            if(num!=i){
                if(!visited[i]){
                    if(computers[num][i]==1){
                       visited[i]=true;
                        q.push(i); 
                    }
                }
            }
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    visited.assign(computers.size(),false);
    
    for(int i=0;i<n;i++){
        if(!visited[i]){
            bfs(computers,i,n);
            answer++;
        }
    }
    return answer;
}

