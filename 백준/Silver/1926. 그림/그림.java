import java.util.*;

public class Main{
    static int n,m;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int area;
    
    public static void dfs(int x, int y){
        visited[x][y]= true;
        area++;
        
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            //범위 벗어나지 않고, 방문 X, 1인 경우! dfs 진행 또하기
            if(nx >=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && paper[nx][ny]==1){
                dfs(nx, ny);
            }
        }
    }
    
    
    public static void main(String[] args){
        
    Scanner sc = new Scanner(System.in);
    
    //입력 받기
    n = sc.nextInt(); //세로의 크기
    m = sc.nextInt(); //가로의 크기
    paper=new int[n][m];
    visited=new boolean[n][m];
    
    //도화지 정보 입력
    for(int i=0; i<n; i++){
        for(int j=0; j<m;j++){
            paper[i][j]=sc.nextInt();
        }
    }
        
    int totalPictures =0; 
    int maxArea=0;
    
        
    //도화지를 순회하며 그림 찾기
    for(int i=0; i<n;i++){
        for(int j=0; j<m; j++){
            if(paper[i][j]==1 && !visited[i][j]){
                area=0;
                dfs(i,j);
                totalPictures++;
                maxArea=Math.max(maxArea, area);
            }
        }
    }
        
        System.out.println(totalPictures);
        System.out.println(maxArea);
}
}