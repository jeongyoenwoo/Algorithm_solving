#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    unordered_map<string,int> map;
    
    for(auto cloth : clothes){
        if(map.find(cloth[1])==map.end()){
            map.insert(make_pair(cloth[1],1));
        }
        else map[cloth[1]]++;
    }
    
    answer=1;
    for(auto it=map.begin();it!=map.end();++it){
        answer*=(it->second+1);
    }
   
    
    return answer-1;
}