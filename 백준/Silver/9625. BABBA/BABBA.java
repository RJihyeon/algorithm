import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int K=sc.nextInt();
        
        //피보나치 수열을 기반으로 A와 B의 개수를 계산
        int[] A=new int[K+1];
        int[] B=new int[K+1];
        
        
        //1단계에서의 초기값 설정
        A[0]=1;
        B[0]=0;
        
        for(int i=1; i<=K;i++){
            A[i]=B[i-1];
            B[i]=A[i-1]+B[i-1];
        }
        System.out.println(A[K]+" "+B[K]);
    }
}