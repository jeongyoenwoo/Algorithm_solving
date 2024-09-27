#include <string>
#include <vector>
#include <stack>

using namespace std;


vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size());
    
    stack<pair<int,int>> st;
    
    int time=0;
    for(int i=0;i<prices.size();i++){
        time++;
        while(!st.empty()&&prices[st.top().first]>prices[i]){
            answer[st.top().first] = time-st.top().second;
            st.pop();
        }
        st.push(make_pair(i,time));
    }
    
     while(!st.empty()){
        answer[st.top().first] = prices.size() - st.top().first - 1;
        st.pop();
    }
    
    return answer;
}