#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int area = brown+yellow;
    for(int height=3;;height++){
        if(area%height!=0) continue;
        
        int width = area/height;
        int yNum = (width-2)*(height-2);
        
        if(yNum==yellow){
            answer.push_back(width);
            answer.push_back(height);
            break;
        }
    }
    return answer;
}