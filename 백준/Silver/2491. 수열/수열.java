import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        //element가 하나인 경우
        if(n==1){
            System.out.println(1);
            return;
        }
        
        int maxLength = 1;
        int incLength =1;
        int decLength = 1;
        
        for(int i=1; i<n; i++){
            if(arr[i]>=arr[i-1]){
                incLength++;
            }else{
                incLength=1;
            }
            
            if(arr[i]<=arr[i-1]){
                decLength++;
            }else{decLength=1;}
            
            maxLength=Math.max(maxLength, Math.max(incLength, decLength));
        }
        System.out.println(maxLength);
    }
}