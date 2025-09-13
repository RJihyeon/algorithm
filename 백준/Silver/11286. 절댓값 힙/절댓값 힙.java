import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      int N = Integer.parseInt(br.readLine()); 
      
      //  compare(a, b) 가 음수면 a<b로 해석됨 
       PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return a - b; 
            return absA - absB; 
        });
      
      for(int i=0; i < N ; i++){
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int num = Integer.parseInt(st.nextToken()); 
        if( num ==0 ){
          if(minHeap.isEmpty()){
            System.out.println(0);
          }else{
            System.out.println(minHeap.poll()); 
            }
        }else{
          minHeap.add(num); 
        }
        
      }
      
  }
}