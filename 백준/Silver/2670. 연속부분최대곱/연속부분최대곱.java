import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        
        //입력받기
        int n=sc.nextInt();
        double[] numbers=new double[n];
        
        for (int i=0; i<n;i++){
            numbers[i]=sc.nextDouble();
        }
        
        //DP 배열 초기화
        double[] dp=new double[n];
        dp[0]=numbers[0];
        double maxProduct=dp[0];
        
        //DP를 이용해 최대 연속곱 계산
        for(int i=1; i<n; i++){
            dp[i]=Math.max(dp[i-1]*numbers[i], numbers[i]);
            maxProduct = Math.max(maxProduct, dp[i]);
        }
        
        //결과 출력(소수점 셋째 자리까지)
        System.out.printf("%.3f", maxProduct);
        
        sc.close();
    }
}