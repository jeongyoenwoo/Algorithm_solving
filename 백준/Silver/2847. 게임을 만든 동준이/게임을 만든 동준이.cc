#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	int n,a,ans=0;
	
	cin>>n;
	vector<int> v;
	for(int i=0;i<n;i++){
		cin>>a;
		v.push_back(a);
	}

	for(int i=n-2;i>=0;i--){
		if(v[i+1]<=v[i])
			ans+=v[i]-(v[i+1]-1);
		v[i]=min(v[i],v[i+1]-1);
	}
	cout<<ans;
	
}