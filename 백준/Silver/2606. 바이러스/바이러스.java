import java.util.*;


public class Main {
    static int comp ;  // Q. 여기 static 안해도 됐는지 기억이 안남 ㅋ 
  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int v = sc.nextInt(); 
      int m = sc.nextInt(); 
      
      //인접리스트 만들기 
      List<Integer>[] adjlist = new ArrayList[v+1]; 
      for(int i =1 ; i<v+1; i++){
        adjlist[i] =new ArrayList<>();  
      }
      
      for(int i = 0 ; i < m ; i++){
        int from = sc.nextInt(); 
        int to = sc.nextInt(); 
        adjlist[from].add(to); 
        adjlist[to].add(from); 
      }
      
      //visited list 만들기 + initialization
      boolean[] visited = new boolean[v+1]; 
      for(int i =1 ; i<=v; i++){
        visited[i] = false; 
      }
      
      
      comp = doDFS(1, adjlist, visited) - 1 ;
      
      System.out.print(comp); 
      
     
    
  }
  
  public static int doDFS(int v, List<Integer>[] adjlist, boolean[] visited){
    comp++; 
    visited[v] = true; 
    for(int neighbor : adjlist[v]){
      if(!visited[neighbor]){
        doDFS(neighbor, adjlist, visited); 
      }
    }
    
    return comp; 
  }
}
