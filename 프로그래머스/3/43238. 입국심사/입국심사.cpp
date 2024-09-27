#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long getCount(long long time,vector<int> times){
    
    long long count=0;

    for(int i=0;i<times.size();i++){
        
        count+=(time/(long long)times[i]);
    }
    
    return count;
}


long long solution(int n, vector<int> times) {
    long long answer = 0;
    
    sort(times.begin(),times.end());
    
    long long start = 0;
    long long end = n * (long long)times.back();

    
    while(start<=end){
        long long mid = (start+end)/2;
        
        if(getCount(mid,times)>=n){
            end = mid-1;
            answer = mid;
        }
        else{
            start = mid+1;
        }
    }
    
    return answer;
}