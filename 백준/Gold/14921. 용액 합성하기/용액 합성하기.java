import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      StringTokenizer st = new StringTokenizer(br.readLine()); 
      int n = Integer.parseInt(st.nextToken()); 
      
      st = new StringTokenizer(br.readLine()); 
      int[] arr = new int[n]; 
      for(int i=0; i < n ; i++){
        arr[i] = Integer.parseInt(st.nextToken()); 
      }
      
      int l =0; 
      int r = n-1; 
      
      int minCheck = Integer.MAX_VALUE; 
      int ans =0; 
      
      while(l<r){
        int candidate = Math.abs(arr[l] + arr[r]); 
        if(candidate == 0 ){
          ans = 0; 
          break ;
        }
        if(candidate < minCheck ){
          minCheck = candidate; 
          ans = arr[l] + arr[r]; 
        }
        if(Math.abs(arr[l]) < Math.abs(arr[r])){
          r--; 
        }else{
          l++; 
        }
      }
      
      System.out.println(ans); 
      
  }
}