import java.util.*;
import java.io.*; 

public class Main {
  static Deque<Character>[] group = new Deque[4];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      //4개의 톱니바퀴 
      for(int i=0; i<4; i++){
        group[i] = new ArrayDeque<>(); 
        String line = br.readLine(); 
        for(char c: line.toCharArray()){
          group[i].add(c);
        }
      }
      //회전
      int N = Integer.parseInt(br.readLine()); 
      while(N-- > 0){
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int groupInx = Integer.parseInt(st.nextToken()) -1; // group 이 0~3
        int dir = Integer.parseInt(st.nextToken()); 
        
        rotate(groupInx, dir); 
      }
  
      
      // 점수 
      int score = 0; 
      for(int i=0; i<4; i++){
        if(group[i].peekFirst() =='1'){
          score += (1<<i) ;//비트 연산 left shift 
        }
      }
      
      System.out.println(score); 

    }
    
    static void rotate(int idx, int dir){
      int[] dirs = new int[4]; 
      dirs[idx] = dir; 
      
      //왼쪽 전파 
      for(int i=idx-1; i>=0; i--){
        if(get(group[i], 2) !=get(group[i+1], 6)){
          dirs[i] = -dirs[i+1];
        }else{
          break;
      }}
      
      //오른쪽 전파
      for(int i=idx+1; i<4; i++){
        if(get(group[i-1],2)!=get(group[i],6)){
          dirs[i]= -dirs[i-1];
        }else{
          break;
        }
      }
      
      
      //회전 
      for(int i=0; i<4; i++){
        if(dirs[i]==1) rotateClockwise(group[i]); 
        else if(dirs[i]==-1) rotateCounterClockwise(group[i]); 
      }
    }
    
    
    static char get(Deque<Character> dq, int idx){
      Iterator<Character> it = dq.iterator(); 
      for(int i=0; i<idx; i++) it.next(); 
      return it.next(); 
    }
    
    static void rotateClockwise(Deque<Character> dq){
      char last= dq.pollLast(); 
      dq.offerFirst(last); 
    }
    
    static void rotateCounterClockwise(Deque<Character> dq){
      char first = dq.pollFirst(); 
      dq.offerLast(first); 
    }
}