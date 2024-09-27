#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int getCount(int distance,int mid, vector<int> rocks){
    
    int count=0;
    int cur=0;
    
    for(int i=0;i<rocks.size();i++){
        if(rocks[i]-cur<mid) count++;
        else cur = rocks[i];
    }
    
    if(distance-cur<mid) count++;
    
    return count;
    
}

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    
    sort(rocks.begin(),rocks.end());
    
    int start = 1;
    int end = distance;
    
    while(start<=end){
        int mid = (start+end)/2;
        
        if(getCount(distance,mid,rocks)<=n){
            answer = max(answer,mid);
            start = mid+1;
        }
        else end = mid-1;
        
    }
    
    return answer;
}