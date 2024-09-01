import java.util.*;
import java.io.*;

public class Main {

    public static int T,W,H;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<Node> fire = new LinkedList<>();
    public static Queue<Person> person = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder stringbuilder = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];
            fire.clear();
            person.clear();

            for(int i=0;i<H;i++){
                String str = br.readLine();
                for(int j=0;j<W;j++){
                    char c = str.charAt(j);
                    map[i][j] = c;
                    if(c=='*') fire.add(new Node(i, j));
                    else if(c=='@') {
                        visited[i][j]=true;
                        person.add(new Person(i, j, 0));
                    }
                }
            }
            
            while(true){
                fireSpread();
                int move = move();
                if(move==-2){
                    stringbuilder.append("IMPOSSIBLE");
                    stringbuilder.append('\n');
                    break;
                }
                else if(move!=-1){
                    stringbuilder.append(move+1);
                    stringbuilder.append('\n');
                    break;
                }
            }
        }

        System.out.print(stringbuilder.toString());

    }

    public static void fireSpread(){
        int length = fire.size();
        for(int i=0;i<length;i++){
            Node fireNode = fire.poll();
            int x = fireNode.x;
            int y = fireNode.y; 

            for(int j=0;j<4;j++){
                int cx = x+dx[j];
                int cy = y+dy[j];
                if(cx<0||cy<0||cx>=H||cy>=W) continue;
                
                if(map[cx][cy]=='#') continue;

                if(map[cx][cy]=='*') continue;

                map[cx][cy]='*';
                fire.add(new Node(cx,cy));

            }
            // for(int k=0;k<H;k++){
            //     for(int j=0;j<W;j++){
            //         System.out.print(map[k][j]);
            //     }
            //     System.out.println();
            // }
        }

    }

    public static int move(){
        int length = person.size();
        
        for(int i=0;i<length;i++){
            Person personNode = person.poll();
            int x = personNode.x;
            int y = personNode.y;
            int move = personNode.move;

            for(int j=0;j<4;j++){
                int cx = x+dx[j];
                int cy = y+dy[j];
                if(cx<0||cy<0||cx>=H||cy>=W){
                    return move;
                }

                if(map[cx][cy]=='#') continue;

                if(map[cx][cy]=='*') continue;

                if(!visited[cx][cy]){
                    visited[cx][cy]=true;
                    person.add(new Person(cx,cy,move+1));
                }
            }

            if(person.isEmpty()) return -2;
            
        }

        return -1;
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static class Person{
        int x;
        int y;
        int move;

        public Person(int x, int y,int move){
            this.x=x;
            this.y=y;
            this.move = move;
        }
    }
    
  
}