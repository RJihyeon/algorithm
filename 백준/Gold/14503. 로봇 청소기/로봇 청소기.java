import java.util.*;
import java.io.*; 

public class Main {
  static int[][] map; 
  static int robotN, robotM, robotDir; 
  static int[] dir = {0,1,2,3}; 
  static int[] dx = {-1, 0, 1, 0}; 
  static int[] dy = {0, 1, 0, -1};
  static int count = 0; // clean up count 
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); 
      int M = Integer.parseInt(st.nextToken()); 
      map = new int[N][M]; 
      
      //robot setting
      st = new StringTokenizer(br.readLine());
      robotN = Integer.parseInt(st.nextToken()); 
      robotM = Integer.parseInt(st.nextToken()); 
      robotDir = Integer.parseInt(st.nextToken()); 
      
      //map setting
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++){
          map[i][j] = Integer.parseInt(st.nextToken()); 
        }
      }
      
      
      
      while(true){
        // 1. 현재 칸 청소 확인 
        if(map[robotN][robotM] == 0){
          map[robotN][robotM] =2; 
          count++; 
        }
        
       
        boolean cleaned = false;

        // 현재 칸 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우 
        // 반시계 방향으로 4번 회전
        for (int i = 0; i < 4; i++) {
            robotDir = (robotDir + 3) % 4; 
            int nx = robotN + dx[robotDir];
            int ny = robotM + dy[robotDir];
    
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                robotN = nx;
                robotM = ny;
                cleaned = true;
                break;
            }
        }

        if (cleaned) continue;
        
        //현재 칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
        int backDir = (robotDir + 2) % 4;
        int backN = robotN + dx[backDir];
        int backM = robotM + dy[backDir];
        
        if(backN<0 || backM<0 || backN >=N || map[backN][backM] == 1){
          break;
        }else{
          robotN = backN; 
          robotM = backM ; 
        }
        
          
       
      }
      
      System.out.println(count);
      
      
      
      
      
  }
}