import java.util.*;
import java.io.*; 

public class Main {
  static int n ; 
  static int r; 
  static int[][] arr; 
  static int[] result; 
  static int min = Integer.MAX_VALUE;
  
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      StringTokenizer st = new StringTokenizer(br.readLine()); 
      
      n = Integer.parseInt(st.nextToken()); 
      r = n / 2 ;  
      arr = new int[n+1][n+1]; 
      result = new int[r]; 
      
      
      
      //arr 생성
      for(int i=1; i < n+1 ; i++){
        st = new StringTokenizer(br.readLine()); 
        for(int j = 1; j < n+1 ; j++){
          arr[i][j] = Integer.parseInt(st.nextToken()); 
        }  
      }
      
      mindiff(0, 0); 
      
      System.out.print(min); 
      
  }
  
  static void mindiff(int idx, int picked){
    
    if (picked == r) {
      // 링크팀은 result[]
        int[] other = new int[r];
        int idx2 = 0;
        for (int i=1; i<=n; i++) {
            boolean inLink = false;
            for (int x : result) if (x == i) inLink = true;
            if (!inLink) other[idx2++] = i;
        }
    
        int linkSum = 0, startSum = 0;
        for (int i=0; i<r; i++) {
            for (int j=i+1; j<r; j++) {
                linkSum += arr[result[i]][result[j]] + arr[result[j]][result[i]];
                startSum += arr[other[i]][other[j]] + arr[other[j]][other[i]];
            }
        }
        min = Math.min(min, Math.abs(linkSum - startSum));
        return;
    }
    if(idx == n) return ; 
    result[picked] = idx+1; 
    mindiff(idx+1, picked+1); 
    mindiff(idx+1, picked); 
    
  }
}