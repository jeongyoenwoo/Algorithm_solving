#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;

    queue<pair<int,int>> q;
    priority_queue<int> pq;
    
    for(int i=0;i<priorities.size();i++){
        q.push(make_pair(i,priorities[i]));
        pq.push(priorities[i]);
    }
    
    int time=1;
    while(true){
        
        int index = q.front().first;
        int priority = q.front().second;
        q.pop();
        
        if(priority==pq.top()){
           if(index==location){
               break;
           }
           else{
               pq.pop();
               time++;
           }
        }
        
        else if(priority<pq.top()){
            q.push(make_pair(index,priority));
        }
        
    }
    return time;
}