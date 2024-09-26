#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    
    sort(routes.begin(),routes.end());
    
    int camera=-30001;
    for(int i=0;i<routes.size();i++){
        
        if(camera>routes[i][1]) camera = routes[i][1];
        
        if(camera<routes[i][0]){
            camera=routes[i][1];
            answer++;
        }
    }
    return answer;
}