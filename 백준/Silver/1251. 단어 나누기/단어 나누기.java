import java.util.*;
import java.io.*;

public class Main {
    static String s, best;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().trim();
        n = s.length();
        best = null;
        
        //brute force 전체 케이스 확인해보기 
        for(int i=1; i <= n - 2; i++){
          for(int j=i+1; j<=n-1; j++){
            //쪼개기고 뒤집고 합치기 
            String a = new StringBuilder(s.substring(0,i)).reverse().toString(); 
            String b = new StringBuilder(s.substring(i,j)).reverse().toString(); 
            String c = new StringBuilder(s.substring(j)).reverse().toString(); 
            
            //비교하기 
            String cand = a+b+c; 
            if(best == null || best.compareTo(cand) > 0 ){
              best = cand; 
            }
            
          }
        }
        
        System.out.println(best); 
    }
}