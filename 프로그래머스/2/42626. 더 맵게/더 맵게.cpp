#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int,vector<int>,greater<int>> pq;
    
    for(int i=0;i<scoville.size();i++){
        pq.push(scoville[i]);
    }
    
    while(!pq.empty()){
        
        if(pq.top()>=K) break;
        
        if(pq.size()==1){
            if(pq.top()<K){
                answer=-1;
                break;
            }
        }
        
        int food1 = pq.top();
        pq.pop();
        int food2 = pq.top();
        pq.pop();
        
        int newFood = food1+(food2*2);
        pq.push(newFood);
        answer++;
    }
    
    return answer;
}