import java.util.*;

public class Main{
    static int M,N,K;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        M=sc.nextInt(); //세로 길이
        N=sc.nextInt(); //가로길이
        K=sc.nextInt();// 직사각형의 개수
        
        paper=new int[M][N]; //갑자기 헷갈리네 java는 행-> 열
        visited=new boolean[M][N];
        
        //직사각형 부분 색칠하기 좌표로 주어짐 주의
        for(int i=0;i<K;i++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            
            for(int y=y1;y<y2;y++){
                for(int x=x1;x<x2;x++){
                    paper[y][x]=1;
                }       
            }
        }
        
        //도화지가 색칠되지 않았을 때!!! dfs 실시! >__< 
        ArrayList<Integer> areas= new ArrayList<>(); 
            //arraylist를 쓰는 이유는 저장해야 할 영역(빈 곳)의 변수가 가변적이기 때문! java에서 array는 반드시 개수를 미리 지정해야함을 잊지 말자
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(paper[i][j]==0&&!visited[i][j]){
                    areas.add(dfs(i,j));
                }
            }
        }
        
        Collections.sort(areas);
        System.out.println(areas.size());
        for(int area: areas){
            System.out.print(area+" ");
        }
        
    }
    
    //dfs로 영역의 너비를 계산
    public static int dfs(int y, int x){
        visited[y][x]=true;
        int area =1;
        for (int i=0; i<4; i++){
            int nx=x+dx[i]; //(이동방향은 열, 좌우)
            int ny=y+dy[i];//이동방향이 세로, 행
            
            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(paper[ny][nx]==0 && !visited[ny][nx]){
                    area+=dfs(ny, nx);
                }
            }
        }
        return area ;
    }
    
}