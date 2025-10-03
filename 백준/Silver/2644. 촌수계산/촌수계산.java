import java.util.*;
import java.io.*; 

public class Main {
  static int start, dest; 
  static boolean[] visited; 
  static ArrayList<ArrayList<Integer>> A; 
  
  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      
      //사람 총 몇명? 
      StringTokenizer st = new StringTokenizer(br.readLine()); 
      int people = Integer.parseInt(st.nextToken()); 
      
      //촌수 타겟 ! 
      st = new StringTokenizer(br.readLine()); 
      start = Integer.parseInt(st.nextToken());  
      dest = Integer.parseInt(st.nextToken()); 
      
      //Array 리스트 만들어놓기 (관계 파악)
      A = new ArrayList<>(); 
      for (int i = 0; i <= people; i++) { 
        A.add(new ArrayList<>());
      }
      
      int N = Integer.parseInt(br.readLine().trim()); 
      for(int i=0; i<N; i++){
         st = new StringTokenizer(br.readLine()); 
         int parent = Integer.parseInt(st.nextToken());  
         int child = Integer.parseInt(st.nextToken()); 
         A.get(parent).add(child); 
         A.get(child).add(parent); 
      }
      
      visited = new boolean[people+1]; 
      
      // bfs로 촌수 알아내기 ! 
      int result = bfs(start, dest); 
      System.out.println(result); 
  }
  
  static int bfs(int s, int d){
      Queue<int[]> q = new ArrayDeque<>();
      q.offer(new int[]{s, 0}); // [현재 노드, 촌수]
      visited[s] = true; 
      
      while(!q.isEmpty()){
          int[] cur = q.poll(); 
          int u = cur[0], depth = cur[1]; 
          
          if(u == d) return depth; 
          
          for(int v : A.get(u)){
              if(!visited[v]){
                  visited[v] = true; 
                  q.offer(new int[]{v, depth+1}); 
              }
          }
      }
      return -1; // 도달 불가
  }
}