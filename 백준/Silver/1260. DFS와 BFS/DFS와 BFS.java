import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static ArrayList<Integer> [] list;
	public static boolean[] visited;
	public static int N,M,V;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<N+1;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			list[start].add(end);
			list[end].add(start);
		}
		for(int i=1;i<N+1;i++) {
			Collections.sort(list[i]);
		}
		
		visited=new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		visited=new boolean[N+1];
		bfs(V);
		
	}
	public static void dfs(int idx) {
		visited[idx]=true;
		System.out.print(idx+" ");
		
		for(int i=0;i<list[idx].size();i++) {
			int n=list[idx].get(i);
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
	public static void bfs(int idx) {
		Queue<Integer> q=new LinkedList<>();
		q.add(idx);
		
		while(!q.isEmpty()) {
			int n=q.poll();
			if(!visited[n]) System.out.print(n+" ");
			visited[n]=true;
			
			for(int i=0;i<list[n].size();i++) {
				if(!visited[list[n].get(i)]) q.add(list[n].get(i));
			}
		}
	}

}
