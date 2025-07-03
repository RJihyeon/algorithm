import java.util.*;
import java.io.*; 

public class Main {
  static int N, K, L; // map 크기, 사과 개수, 방향변환 횟수 
  static int[][] map; // 0: 빈 칸, 1: 사과, 2: 뱀
  static int time =0; 
  static int[][] apple; 
  static int[] dx = {0,-1,0,1};
  static int[] dy = {1,0,-1,0};
  static int dir = 0; 

  static List<Dir> dirList = new ArrayList<>(); // 동적배열생성 
  static class Dir {
        int time;
        char turn;
        Dir(int time, char turn) {
            this.time = time;
            this.turn = turn;
        }
    }
  
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      
      N = Integer.parseInt(br.readLine()); 
      K = Integer.parseInt(br.readLine());
      
      map = new int[N + 1][N + 1];  // 1-based 설계
      
      for (int i=0; i<K; i++){
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int x = Integer.parseInt(st.nextToken()); //행 읽기 
        int y = Integer.parseInt(st.nextToken()); //열 읽기 
        map[x][y] = 1;         
      }
      
      L = Integer.parseInt(br.readLine()); 
      // L 만큼 반복해서 Dir 생성 
      for(int i=0; i<L; i++){
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int t=Integer.parseInt(st.nextToken()); 
        char c = st.nextToken().charAt(0); 
        dirList.add(new Dir(t, c)); 
      }
      
      
      game(); 
      
      System.out.println(time); 
      
  }
  
  static void game(){
    Deque<int[]> snake = new ArrayDeque<>();
    snake.add(new int[]{1,1}); 
    map[1][1] = 2; 
    int dirIndex = 0; 
    
   while(true){
     time++; 
     int[] head = snake.peekLast() ;
     int nx = head[0] + dx[dir]; 
     int ny = head[1]+ dy[dir]; 
     
     if(nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] ==2){
       break; 
     }
     
     //사과를 만났따.
     if(map[nx][ny]==1){
       map[nx][ny]=2; 
       //사과 -> 머리 추가, 꼬리 유지 (머리를 끝에 추가한거임 queue니까)
       snake.addLast(new int[]{nx, ny}); 
     }else{
       //빈칸 -> 머리 추가, 꼬리 제거 
       map[nx][ny] = 2; 
       snake.addLast(new int[]{nx, ny}); 
       int[] tail = snake.pollFirst(); 
       map[tail[0]][tail[1]] = 0 ;
     }
     
     
    //방향전환을 만났따. 
    if(dirIndex < dirList.size() && dirList.get(dirIndex).time == time) {
      char turn = dirList.get(dirIndex).turn; 
      if(turn =='D'){
        dir = (dir+3) % 4; 
      }else{
        dir = (dir+1)%4; 
      }
      dirIndex++; 
    }
    
   }
   

    
    
  }
}