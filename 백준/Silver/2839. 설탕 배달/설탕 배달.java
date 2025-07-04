import java.util.*;


public class Main {
  static int x, y, N; 
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      N = sc.nextInt(); 
      
      
      //3x+5y = N 
      for(int x =0; x<N ;x++){
        for(int y =0; y<N; y++){
          if(3*x + 5*y == N){
            System.out.println(x+y); 
            return; 
          }else if(3*x + 5*y > N){
            break;
          }
        }
      }
      
      System.out.println(-1); 
      
      
      
  }
}