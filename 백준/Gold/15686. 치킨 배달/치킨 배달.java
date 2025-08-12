import java.util.*;
import java.io.*; 

public class Main {
   static int N, M;
    static ArrayList<Point> chickens = new ArrayList<>();
    static ArrayList<Point> houses   = new ArrayList<>();
    static boolean[] selected;          // 치킨집 선택 여부
    static int answer = Integer.MAX_VALUE;
  
  static class Point{
    int x, y; 
    Point(int x, int y){
      this.x = x; 
      this.y = y; 
    }
  }
    public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
      StringTokenizer st = new StringTokenizer(bf.readLine());
      
      N = Integer.parseInt(st.nextToken()); 
      M = Integer.parseInt(st.nextToken()); 
      
      for(int i=0; i<N; i++){
        st= new StringTokenizer(bf.readLine()); 
        for(int j=0; j<N; j++){
          int k = Integer.parseInt(st.nextToken());
          if(k ==1){
            houses.add(new Point(i+1, j+1)); 
          }else if (k ==2){
            chickens.add(new Point(i+1, j+1));
          }
        }
      }
      
      selected = new boolean[chickens.size()];
      backtrack(0,0); 
      
      System.out.println(answer); 
      
    
  }
  
  static void backtrack(int idx, int picked){
    if(picked == M){
      answer = Math.min(answer, evaluate()); 
      return ;
    }
    if(idx == chickens.size()){
      return ;
    }
    
    // 현재 idx 치킨집 선택
    selected[idx] = true;
    backtrack(idx + 1, picked + 1);
    
    // 선택 취소(미선택)
    selected[idx] = false;
    backtrack(idx + 1, picked);
    
  }
  
  static int evaluate(){
    int sum =0 ;
    for(Point h: houses){
      int best = Integer.MAX_VALUE;
      
      //최적 거리 계산 
      for(int i=0; i< chickens.size(); i++){
        if(!selected[i]) continue; 
        Point c = chickens.get(i); 
        int d = Math.abs(c.x - h.x) + Math.abs(c.y - h.y); 
        if(d < best) {
          best = d ; 
        }
      }
       sum += best; 
      if (sum >= answer) return sum; // 조기 종료 
    }
    
    return sum; 
    
  }
}