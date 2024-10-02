import java.util.*; 
import java.io.*;

public class Main{
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    
    static int count = 0, number =0;
    static int nowX, nowY, N;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        
        //input 값 읽어서 NxN 배열 결정
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        
        //input 배열 확보하기
        for (int i = 0 ; i<N; i++){
            //일단은 string으로 읽기
            String str = br.readLine();
            
            //numberic value로 변환해서 arr에 넣기
            for(int j=0; j<N; j++){
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        
        //DFS진행
        for(int i=0; i<N; i++){
            for( int j=0; j<N; j++){
                if (visit[i][j]==false & arr[i][j]==1){
                    count =0; 
                    number++;
                    DFS(i,j);
                    list.add(count); 
                }
            }
        }
        
        //sorting하고 출력하기
        Collections.sort(list);
        bw.append(String.valueOf(number)+'\n');
        for (int num : list) {
            bw.append(String.valueOf(num) + "\n");  // int를 String으로 변환
        }
        
        //한번에 출력하고 닫기
        bw.flush();
        bw.close();
    } //main method 끝
    
    
    static void DFS(int x, int y){
        visit[x][y] = true; 
     
        count++;
        
        //좌우 양옆 검사
        for(int i=0; i<4;i++){
            nowX = dx[i] + x;
            nowY = dy[i] +y; 
            //재귀적 탐색
            if(Range_Check() && visit[nowX][nowY] == false &&  arr[nowX][nowY]==1){
     
                
                DFS(nowX,nowY);
            }
        }
    } //DFS method 끝!
    
    static boolean Range_Check(){
    return (nowX>=0 && nowX<N && nowY >=0 && nowY<N);
    }
    }