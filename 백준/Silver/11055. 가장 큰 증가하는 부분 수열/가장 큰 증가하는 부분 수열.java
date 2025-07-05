import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      int N = sc.nextInt(); 
      
      int[] dp, A; 
      dp = new int[N]; 
      A = new int[N];
      
      //세팅
      for(int i=0; i<N; i++){
        int num = sc.nextInt(); 
        A[i] = num; 
        dp[i] = num; 
      }
      
      for(int i=1; i<N; i++){
        for(int j=0; j<i; j++){
          if(A[j]<A[i]){
            dp[i] = Math.max(dp[i], dp[j]+A[i]);
          }
        }
      }
      
      int max=0; 
      for(int i=0; i<N; i++){
        max = Math.max(dp[i], max); 
      }
      
      System.out.println(max); 
      
  }
}