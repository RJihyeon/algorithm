import java.util.*;
import java.io.*; 

public class Main {
  static int N, M; 
  static int[][] map; 
  static List<Point> empty = new ArrayList<>(); 
  static List<Point> virus = new ArrayList<>(); 
  static int maxSafe =0; 
  static int[] dx = {-1, 1, 0, 0}; 
  static int[] dy = {0, 0, -1, 1}; 
  
  static class Point{
    int x, y; 
    //생성자 
    Point(int x, int y){
      this.x = x; 
      this.y = y; 
    }
  }
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer  st = new StringTokenizer(br.readLine()); 
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    //map 만들기 
    
    map = new int[N][M];  
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] ==0) empty.add(new Point(i, j));
        else if (map[i][j]==2) virus.add(new Point(i,j));
      }
    }
    
    
    //빈칸 3개 조합 
    comb(0, 0, new Point[3]); 
    
    System.out.println(maxSafe);
  }
  
  
  static void comb(int depth, int start, Point[] walls){
    if(depth ==3){
      bfs(walls); 
      return ;
    }
    /// start인덱스부터 시작해서 empty(빈 칸들)에서 벽 후보 고르기 
    //backtracking bruteforce 완전탐색 ! 
    for (int i=start; i<empty.size(); i++){
      walls[depth] = empty.get(i);
      comb(depth+1, i+1, walls); 
      }
  }
  
  static void bfs(Point[] walls){
    int[][] temp = new int[N][M];
    
    //map 복사 
    for (int i=0; i<N; i++)temp[i] = map[i].clone(); 
    for(Point p: walls){
      temp[p.x][p.y] = 1; 
    }
    
    //바이러스를 큐에 넣기 ! 
    Queue<Point> q = new LinkedList<>() ; 
    for(Point v: virus){
      q.offer(new Point(v.x, v.y));
    }
    
    //바이러스 퍼트리기 
    while(!q.isEmpty()){
      Point p = q.poll(); 
      for(int d = 0; d<4; d++){
        int nx = p.x + dx[d];
        int ny = p.y + dy[d]; 
        
        if(nx >=0 && nx < N && ny>=0 && ny < M &&temp[nx][ny]==0){
          temp[nx][ny]=2; 
          q.offer(new Point(nx, ny));
        }
      }
    }
    //안전지대 세기 ~ 
    
    int safe = 0; 
    for (int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(temp[i][j]==0)safe++; 
      }
    }
    
    maxSafe = Math.max(maxSafe, safe);
  }
}