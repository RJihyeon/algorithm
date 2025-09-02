import java.util.*;
import java.io.*; 

public class Main {
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, 1, -1};
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());  

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); 
        int t = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[r+1][c+1]; 
        int top = 0; // 공기청정기 위
        int bottom = 0 ; //공기청정기 아래 
        for(int i=1; i<=r ;i++){
          st = new StringTokenizer(br.readLine());
          for(int j=1; j<=c; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
            if (arr[i][j] == -1 && j == 1) {
            if (top == 0) top = i;
            else bottom = i;
        }
          }
        }
        
        
        for(int i=0; i<t; i++){
          arr = diffuse(arr, r, c, top, bottom);
          purify(arr, r, c, top, bottom);
        }
        
        //합산 
        int sum = 0 ; 
         for(int i=1; i<=r ;i++){
          for(int j=1; j<=c; j++){
            if (arr[i][j] > 0 ){
                sum += arr[i][j] ; 
            }
          }
        }
        
        System.out.println(sum); 
       
    }
    
    static int[][] diffuse(int[][] a, int r, int c, int top, int bottom){
      int[][] next = new int[r+1][c+1];
        next[top][1] = -1;
        next[bottom][1] = -1;
        for(int x=1; x<=r; x++){
            for(int y=1; y<=c; y++){
                if(a[x][y] <= 0) continue;
                int spread = a[x][y] / 5;
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx < 1 || nx > r || ny < 1 || ny > c) continue;
                    if(a[nx][ny] == -1) continue;
                    next[nx][ny] += spread;
                    cnt++;
                }
                next[x][y] += a[x][y] - spread * cnt;
            }
        }
        return next;
    }
    
    static void purify(int[][] a, int r, int c, int top, int bottom){
      for(int i=top-1; i>=2; i--) a[i][1] = a[i-1][1];
        for(int j=1; j<=c-1; j++) a[1][j] = a[1][j+1];
        for(int i=1; i<=top-1; i++) a[i][c] = a[i+1][c];
        for(int j=c; j>=3; j--) a[top][j] = a[top][j-1];
        a[top][2] = 0; a[top][1] = -1;
        
        for(int i=bottom+1; i<=r-1; i++) a[i][1] = a[i+1][1];
        for(int j=1; j<=c-1; j++) a[r][j] = a[r][j+1];
        for(int i=r; i>=bottom+1; i--) a[i][c] = a[i-1][c];
        for(int j=c; j>=3; j--) a[bottom][j] = a[bottom][j-1];
        a[bottom][2] = 0; a[bottom][1] = -1;
    }
}
