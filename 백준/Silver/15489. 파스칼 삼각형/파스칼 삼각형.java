import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //입력 3개 다 받긩!
        int R=sc.nextInt();
        int C=sc.nextInt();
        int W=sc.nextInt();
        
        
        //파스칼 삼각형 생성
        int[][] triangle=new int[31][31];
        for(int i=1; i<=30; i++){
            triangle[i][1]=1; 
            for(int j=2; j<=i; j++){
                triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
            }
        }
        
        //합산하기 (한행한행씩 합산해서 저장하기)
        int sum=0;
        for(int i=0; i<W;i++){
            for(int j=0; j<=i;j++){
                sum+=triangle[R+i][C+j];
            }
        }
        
        System.out.println(sum);
        sc.close();
         
    }
}
