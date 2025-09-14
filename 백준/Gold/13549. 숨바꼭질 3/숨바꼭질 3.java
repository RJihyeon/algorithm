import java.util.*;
import java.io.*; 

public class Main {
    static final int MAX = 100000; 
    static final int INF = 1_000_000_000; 
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        
        
        // 1. distance MAX로 채우기 
        int[] dist = new int[MAX + 1]; // 0-MAX까지 가능하니까.. 
        Arrays.fill(dist, INF); 
        
        
        // 2.우선순위큐 (최소힙)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        dist[N] = 0; 
        pq.offer(new int[]{0,N}); // 큐에 시간 0 위치 N 시작점 삽입 
        
        //3. 다익스트라 ! 
        while(!pq.isEmpty()){
          int[] cur = pq.poll(); 
          int d = cur[0], x = cur[1]; 
          // 오래된 값은 버리자 ! 
          if( dist[x] != d ) continue; 
          //목표 도달 
          if( x == K ) break; 
          
          //1) 순간이동 -> 가중치0 
          // 시간이 추가로 안듦 
          int nx = x * 2 ; 
          if(nx <= MAX && dist[nx] > d ){
            dist[nx] = d; // 거리 갱신해주기 (추가적인 거리 없음 )
            pq.offer(new int[]{dist[nx], nx}); // 갱신된 상태 큐에 넣기 
          }
          
          // 2) 한칸 뒤로 이동하기 
          nx = x-1; 
          if(nx <= MAX && nx >=0 && dist[nx] > d){
            dist[nx] = d + 1; 
            pq.offer(new int[]{dist[nx], nx}); 
          }
          
          //3) 한칸 앞으로 가기 
          nx = x+1; 
          if(nx <= MAX && nx >=0 && dist[nx] > d){
            dist[nx] = d+1; 
            pq.offer(new int[]{dist[nx], nx}); 
          }
          
          
        }       
        
        
        //정답 
        System.out.println(dist[K]); 
        

  }
}