import java.util.*;


public class Main {
  
    static List<Integer> dfsResult = new ArrayList<>(); // 전역 리스트
    static List<Integer> bfsResult = new ArrayList<>(); // 전역 리스트

    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int v = sc.nextInt();
      int m = sc.nextInt(); 
      int startNum = sc.nextInt(); 
     
      
      List<Integer>[] adjlist = new ArrayList[v + 1]; 
      
      // “Array of ArrayList” 배열안에 리스트 객체를 담은 구조로 
      // nested array는 메모리 구조상 완전히 2차원 배열이고,
      // adjlist[i] = new ArrayList<>();는 각각의 칸에 “리스트 객체를 집어넣는 것”
       for (int i = 1; i <= v; i++) {
            adjlist[i] = new ArrayList<>(); // 각 인덱스에 리스트 초기화
        }
      
      for (int i = 0 ; i < m ; i++){
        int fromNode = sc.nextInt(); 
        int toNode = sc.nextInt();
        adjlist[fromNode].add(toNode);
        adjlist[toNode].add(fromNode); // 무방향 그래프임  !!!!!!!!!!!
      }
      
      // 💡 여기에 정렬 추가 (문제 조건, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문)
      for (int i = 1; i <= v; i++) {
          Collections.sort(adjlist[i]);
      }
      
      //visited 함수 정의 및 초기화 
      boolean[] visited = new boolean[v+1]; 
      for(int i =0; i <= v; i++){
        visited[i] = false; 
      }
      
      
      doDFS(startNum, adjlist, visited);
      
      // BFS 전 visited 함수 초기화 
      for(int i =0; i <= v; i++){
        visited[i] = false; 
      }
      doBFS(startNum, adjlist, visited);
      
      
      for(int result: dfsResult){
        System.out.print(result + " ");
      }System.out.println();
      for(int result: bfsResult){
        System.out.print(result + " ");
      }
      
  }
  
  
  public static void doDFS(int v, List<Integer>[] adjlist, boolean[] visited){
    visited[v] = true; 
    dfsResult.add(v); 
    if(adjlist[v] != null ){
      for(int neighbor : adjlist[v]){
        if(!visited[neighbor]) {
          doDFS(neighbor, adjlist, visited); 
        }
      }
    }
  } 
  
  public static void doBFS(int v, List<Integer>[] adjlist, boolean[] visited){
    visited[v] = true;
    bfsResult.add(v); 

    int x;     
    Queue<Integer> q = new LinkedList<>();
    q.offer(v);
    
    while(!q.isEmpty()){
      x = q.poll(); 
      for(int neighbor: adjlist[x]){
        if(!visited[neighbor]){
          visited[neighbor] = true; 
          bfsResult.add(neighbor);
          q.offer(neighbor); 
        }
       
      }
    }
  }
}
