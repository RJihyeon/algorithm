import java.util.*;

public class Main {
    static int M, N; // M: 열, N: 행
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int totalTomato = 0; // 전체 토마토 개수
    static int ripeTomato = 0; // 익은 토마토 개수
    static Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
    static int[][] graph ;
    static int days = -1; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //열
        N = sc.nextInt(); //행
      
      
        //graph 초기화 
        graph = new int[N][M]; 
        for(int i=0 ; i<N; i++){
        for(int j=0; j<M; j++){
            graph[i][j] = sc.nextInt(); 
            if (graph[i][j] == 0 || graph[i][j] == 1) {
                    totalTomato++;
                }
            if(graph[i][j] == 1){
            queue.offer(new int[] {i, j}); 
            ripeTomato++; // 익은 토마토 개수 증가
            }
        }
        }

        //이미 모두 익었으면 출력하고 프로그렘 종료 
        if(ripeTomato == totalTomato){
            System.out.println(0); 
            return; 
        }

        days = bfs(); // BFS 실행
        
        if(ripeTomato == totalTomato){
            System.out.println(days);
        }else{
            System.out.println(-1);
        }
        
      
  }

  static int bfs(){
    while(!queue.isEmpty()){
      days++ ;
      int size = queue.size(); 
      
      for(int i =0 ; i<size; i++){
        int[] p = queue.poll(); 
        int x = p[0];
        int y = p[1];
        
        for(int d = 0 ; d<4; d++){
          int nx = x+dx[d];
          int ny = y+dy[d];
          
          if(nx>=0 && nx < N && ny >=0 && ny < M){
            if(graph[nx][ny] ==0 ){
              graph[nx][ny]=1; 
              ripeTomato++;
              queue.offer(new int[] {nx, ny});
            }
          }
        }
      }
    }
    

    return days; 
    

  }
}