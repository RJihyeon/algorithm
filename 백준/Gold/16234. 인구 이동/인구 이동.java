import java.util.*;
import java.io.*;

public class Main {
  static int N, L, R; 
  static int[][] map; 
  static boolean[][] visited; 
  static int[] dx ={-1,1,0,0}; 
  static int[] dy = {0,0,-1,1};
  
  static class Point{
    int x, y ; 
    Point(int x, int y ){
      this.x = x; 
      this.y = y; 
    }
  }
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      
      map = new int[N][N]; 
      
      for (int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine()); 
        for (int j =0; j<N; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      int days = 0; 
      
      while (true){
        visited = new boolean[N][N];
        boolean moved = false; 
         for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if(!moved) break;
            days++;
      }

    System.out.println(days); 
  }
  
  static boolean bfs(int x, int y){
    Queue<Point> queue = new LinkedList<>() ; 
    List<Point> union = new ArrayList<>(); 
    
    queue.offer(new Point(x, y)); 
    union.add(new Point(x, y)); 
    
    visited[x][y] = true; 
    int totalPopulation = map[x][y];
    
    while (!queue.isEmpty()){
      Point p = queue.poll(); 
      for(int d = 0; d<4; d++){
         int nx = p.x + dx[d];
         int ny = p.y + dy[d];
         
          if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                int diff = Math.abs(map[p.x][p.y] - map[nx][ny]);
                if(diff >= L && diff <= R) {
                    queue.offer(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    totalPopulation += map[nx][ny];
                }
      }
    }
    
    if (union.size()==1) return false; 
    
    int avg = totalPopulation / union.size(); 
    for(Point p: union){
      map[p.x][p.y] = avg; 
    }
    
    return true; 
  }
}