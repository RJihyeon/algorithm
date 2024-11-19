import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.close();
        
        final int MOD = 1_000_000_007;
        if(n ==0){
            System.out.println(0);
            return;
        }else if (n==1){
            System.out.println(1);
            return;
        }
        
        long[] dp = new long[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2; i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%MOD;
        }
        System.out.println(dp[n]);
    }
}