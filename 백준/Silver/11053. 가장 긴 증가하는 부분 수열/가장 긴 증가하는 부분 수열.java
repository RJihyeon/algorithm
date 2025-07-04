import java.util.*;


public class Main {
  static int max; 
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      int N = sc.nextInt(); 
      
      int[] A = new int[N]; // 0~N-1
      int[] dp = new int[N]; 
      
      //표 채우기 
      for(int i=0; i<N; i++){
        int t = sc.nextInt(); 
        A[i] = t; 
        dp[i] = 1; // 각 원소 부분수열 될 수 있음. 
      }
      
      // DP 너무 어려워요 
      for(int i=0; i<N; i++){
        for(int j=0; j<i; j++){
          if(A[j] < A[i]){
            dp[i] = Math.max(dp[i], dp[j]+1);
          }
      }}
      
       int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
  }
}