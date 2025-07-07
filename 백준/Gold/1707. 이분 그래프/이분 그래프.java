import java.util.*;

public class Main {
  static List<Integer>[] graph; 
  static int[] color; 
  static boolean result; 
  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      int K = sc.nextInt(); 
      
      for(int k=0; k<K; k++){
        int V = sc.nextInt(); 
        int E = sc.nextInt(); 
        
        graph = new ArrayList[V+1]; 
        color = new int[V+1]; // 0: 미방문, 색깔은 1과 2 
        result = true; 
        
        //node 1부터 담기 
        for(int v=1; v<=V; v++){
          graph[v] = new ArrayList<>() ; 
        }
        
        // 간선 입력 
        for(int i=1; i<=E; i++){
          int u = sc.nextInt(); 
          int v = sc.nextInt() ;
          graph[u].add(v); 
          graph[v].add(u); 
        }
        
        //bfs 
        for(int i=1; i<=V; i++){
          if(color[i] ==0){
            bfs(i); 
          }
        }
        
        System.out.println(result? "YES" : "NO") ;
      }

  }
  
  
  static void bfs(int start){
    Queue<Integer> queue = new LinkedList<>(); 
    queue.add(start); 
    color[start] = 1; 
    
    while (!queue.isEmpty()){
      int current = queue.poll(); 
      for(int next:graph[current]){
        if(color[next] ==0){
          if(color[current] ==1){
            color[next] = 2; 
          }else{
            color[next] = 1; 
          }
          queue.add(next); 
        }else if(color[next] == color[current]) {
          result = false; 
          return; 
        }
      }
    }
  }
}

