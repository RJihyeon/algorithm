import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy={0,0,1,-1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        M=sc.nextInt();
        N=sc.nextInt();
        map=new char[N][M];
        visited=new boolean[N][M];
        
        for(int i=0; i<N;i++){
            String line=sc.next();
            for(int j=0; j<M; j++){
                map[i][j]=line.charAt(j);
            }
        }
        
        int whitePower=0;
        int bluePower=0;
        
        //BFS로 각 팀의 전력 계산
        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                if(!visited[i][j]){
                    int power=bfs(i,j,map[i][j]);
                    if(map[i][j]=='W'){
                        whitePower+=power*power;
                    }else{
                        bluePower+=power*power;
                    }
                }
                
            }
        }
        System.out.println(whitePower+" "+bluePower);
    }
    
    //bfs로 연결된 팀의 병력 수 계산
    static int bfs(int x, int y, char team){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;
        int count=1;
        
        while(!queue.isEmpty()){
            int[] pos= queue.poll();
            int cx=pos[0];
            int cy=pos[1];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==team){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny});
                    count++;
                }
            }
        }
        return count;
    }
}