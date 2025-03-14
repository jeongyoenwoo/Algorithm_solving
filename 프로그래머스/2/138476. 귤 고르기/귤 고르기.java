import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2)->map.get(o2).compareTo(map.get(o1)));
        
        int count=1;
        for(Integer i : keySet){
            k-=map.get(i);
            
            if(k<=0) break;
            else count++;
         
        }
        
        return count;
    }
}