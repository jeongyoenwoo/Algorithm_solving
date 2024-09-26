#include <string>
#include <vector>

using namespace std;

vector<int> visited;
int answer = 0; 

void dfs(vector<int> numbers,int cnt,int target){
    if(cnt==numbers.size()){
        int sum=0;
        
        for(int i=0;i<numbers.size();i++){
            sum+=(numbers[i]*visited[i]);
        }
        
        if(sum==target) answer++;
        
        return;
    }
    
    visited[cnt]=1;
    dfs(numbers,cnt+1,target);
    visited[cnt]=-1;
    dfs(numbers,cnt+1,target);
    
}

int solution(vector<int> numbers, int target) {
    
    visited.assign(numbers.size(),0);
    
    dfs(numbers,0,target);
    
    return answer;
}


