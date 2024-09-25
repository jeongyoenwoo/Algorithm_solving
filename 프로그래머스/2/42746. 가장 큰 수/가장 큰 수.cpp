#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const string &a, const string &b){
    return a+b>b+a;
}


string solution(vector<int> numbers) {
    string answer = "";
    
    vector<string> numVec;
    for(int i=0;i<numbers.size();i++){
        numVec.push_back(to_string(numbers[i]));
    }
    
    sort(numVec.begin(),numVec.end(),cmp);
    
    for(int i=0;i<numVec.size();i++){
        answer+=numVec[i];
    }
    
    if(answer[0]=='0') return "0";
    
    return answer;
}