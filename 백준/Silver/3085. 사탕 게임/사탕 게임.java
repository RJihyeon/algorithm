import java.util.*;
import java.io.*; 

public class Main {
  static int N; 
  static char[][] A; 
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      
      
      N = Integer.parseInt(br.readLine().trim());
      A = new char[N][N]; 
      for(int i=0; i <N; i++){
        A[i] = br.readLine().trim().toCharArray(); 
      }
      
      //시작점의 최대값 알아내기 
      int ans = startMax();       
      
      //시작점부터 검사
      // (반복) A[0][0] ~~A[N-1][N-2]까지?우측, 아래측 바꾸기 (swap)
      //       out of bound 되지 않도록 가드 필요 
      //      swap 영향이 있는 column (i, j)(i+1,j)(i,j+1) 이렇게 검사해서 best answer갱신하기 
      for(int i=0; i <N ; i++){
        for(int j=0; j<N; j++){
          //오른쪽이랑 바꾸기 
          if(j+1 < N && A[i][j] != A[i][j+1] ){
            swap(i,j,i,j+1); 
            int cand =0;
            cand = Math.max(cand, maxRunInRow(i));
            cand = Math.max(cand, maxRunInCol(j));
            cand = Math.max(cand, maxRunInCol(j+1));
            ans = Math.max(ans, cand);
            swap(i,j,i,j+1); //원상 복귀 
          }
          
          //아래쪽이랑 바꾸기 
          if(i+1<N && A[i][j] != A[i+1][j]){
            swap(i,j,i+1,j); 
            int cand = 0;
            cand = Math.max(cand, maxRunInCol(j));
            cand = Math.max(cand, maxRunInRow(i));
            cand = Math.max(cand, maxRunInRow(i+1));
            ans = Math.max(ans, cand);
            swap(i,j,i+1,j);
          }
        }
      }
      
      System.out.println(ans); 
      
      
  }
  
  static int startMax(){
    int best = 1; 
    for (int r=0; r<N; r++) best = Math.max(best, maxRunInRow(r)); 
    for(int c = 0; c<N; c++) best = Math.max(best, maxRunInCol(c));
    return best ;
  }
  
  //swap 해주는 함수 
  static void swap(int a, int b, int c, int d){
    char copy = A[a][b]; 
    A[a][b] = A[c][d]; 
    A[c][d] = copy; 
  }
  
  
  
  //행에서 최댓값 구해주는 함수 
  static int maxRunInRow(int r){
    int best = 1; 
    int cnt = 1; 
    for(int i=0; i<N-1; i++){
      if(A[r][i] == A[r][i+1]){
        cnt++; 
      }else cnt=1; 
      if(cnt > best) best = cnt; 
    }
    
    return best; 
  }
  
  //열에서 최댓값 구해주는 함수 
  static int maxRunInCol(int c){
    int best = 1; 
    int cnt = 1; 
    for(int i=0; i<N-1; i++){
      if(A[i][c] == A[i+1][c]){
        cnt++; 
      }else cnt=1; 
      if(cnt > best) best = cnt; 
    }
    
    return best; 
  }
}