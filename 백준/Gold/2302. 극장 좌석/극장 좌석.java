import java.util.*;

public class Main {
    static int N; 
    static boolean[] vip; 
    static List<Integer> group ; 
    static int sum =1 ;
    
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      N = sc.nextInt() ;
      vip = new boolean[N+1]; 
      group = new ArrayList<>(); 
      
      //vip석 지정 
      int numVip = sc.nextInt(); 
      for(int i=1; i<=numVip; i++){
        int v = sc.nextInt(); 
        vip[v] = true; 
      }
      
      int num =0;
      //group 나누기 
      // 자유 구간 나누기
        int prev = 0;
        for (int i = 1; i <= N; i++) {
            if (vip[i]) {
                group.add(i - prev - 1); // 이전 VIP부터 이번 VIP 전까지 거리
                prev = i;
            }
        }
        group.add(N - prev); // 마지막 VIP 이후 구간
      
      // 주요 로직 (각 group에서의 경우의 수 세서 곱하기)
      for(int i=0; i<group.size(); i++){
        int k=group.get(i); 
        int dp = fib(k); 
        sum *=dp; 
      }
      
      System.out.println(sum); 
      
      
  }
  
  static int fib(int k){
    if(k<2) {
      return 1; 
    }else{
      return fib(k-1) + fib(k-2); 
    }
  }
}