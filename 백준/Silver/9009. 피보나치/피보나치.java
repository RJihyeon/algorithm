import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      StringTokenizer st = new StringTokenizer(br.readLine()); 
      int TC = Integer.parseInt(st.nextToken()); 
      
      for(int t=0; t < TC ; t++){
        ArrayList<Integer> arr = new ArrayList<>(); 
        st = new StringTokenizer(br.readLine()); 
        int num = Integer.parseInt(st.nextToken()); 
        
        //피보나치 리스트 미리 생성해두기 
        ArrayList<Integer> fibs = new ArrayList<>() ; 
        fibs.add(1);
        fibs.add(1) ;
        int k =1; 
        while(true){
          int next = fibs.get(k) + fibs.get(k-1); 
          k++; 
          if(next > num) {
            break; 
          }
          fibs.add(next);
        }
        
        // 최적 원소들 찾아나가기
        int j = fibs.size()-1; 
        while(j >= 0 ){
          //조건 다 만족했다면 탈출하기 
          int sum=0; 
          for(int e: arr){
            sum += e; 
          }
          
          if (sum ==num){
            break ;
          }
          
          //조건 만족 못한 경우 계속 찾기 
          if(sum + fibs.get(j) <=num) {
            arr.add(0, fibs.get(j)); 
          }
          j--; 
        }
        
        if(arr.size() == 1){
          System.out.println(arr.get(0)); 
          continue; 
        }
        
        for(int i = 0; i < arr.size(); i ++){
          if(i == 0){
            System.out.print(arr.get(0)); 
          }else if(i ==arr.size()-1){
            System.out.print(" ");
            System.out.println(arr.get(i));
          } else{
            System.out.print(" "); 
            System.out.print(arr.get(i)); 
          }
        }
        
        
       
      }
      
   
  }
}

