class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1){
            return new int[]{-1};
        }
        int min = arr[0];
        
        for(int i=1;i<arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        
        int[] answer = new int[arr.length-1];
        int idx = 0;
        
        for(int num : arr){
            if(num==min) continue;
            
            answer[idx++] = num;
        }
        
        return answer;
    }
}