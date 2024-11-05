import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //Test case수
        int[][] apt=new int[15][15]; //최대 14층 14호까지 계산가능
        
        //0층 초기화: 0층의 i호에는 i명이 산다
        for(int i=1; i<=14; i++){
            apt[0][i]=i;
        }
        
        //각 층과 호수에 따라 거주민 수를 계산
        for (int k=1; k<=14; k++){
            for(int n=1; n<=14; n++){
                apt[k][n]=apt[k][n-1]+apt[k-1][n];
            }
        }
        
        //입력된 테스트 케이스에 대해 출력
        for(int t=0; t<T;t++){
            int k=sc.nextInt();
            int n=sc.nextInt();
            System.out.println(apt[k][n]);
        }
        
        sc.close();
    }
}