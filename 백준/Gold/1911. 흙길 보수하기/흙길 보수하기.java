import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
		
        //웅덩이 시작 위치가 앞선 순서로 정렬
        PriorityQueue<Hole> pq = new PriorityQueue<>((a,b)->(a.start - b.start));
		
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
 
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
 
            pq.add(new Hole(start, end));
        }
 
        int start = 0;
        int total = 0;
	
        while(!pq.isEmpty()){
            Hole curr = pq.poll();
 
            //이미 판자로 웅덩이를 덮힌 경우면 무시
            if(curr.end < start){
                continue;
            }
			
            //판자 시작점 구하기
            start = Math.max(curr.start,start);
            //세워야하는 최소 판자 길이
            int length = curr.end - start;
			
            //판자 개수 구하기
            int count = length % L != 0 ? length/L + 1 : length/L;
			
            //판자 개수 더하기
            total +=count;
            //다음 판자 최소 시작점 갱신 
            start += count*L;
        }
 
        System.out.println(total);
    }
}
 
class Hole{
    int start;
    int end;
 
    public Hole(int start, int end){
        this.start = start;
        this.end = end;
    }
}