import java.util.*;

public class Main{
    public static int N, M; // 세로, 가로
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public static int sheepCount = 0; // 전체 양
    public static int wolfCount = 0;  // 전체 늑대
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M];
        
        // map 채우기, 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        // 지도 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && (map[i][j] == 'k' || map[i][j] == 'v')) {
                    // 새로운 울타리 영역 탐색
                    int[] result = bfs(i, j);
                    int localSheep = result[0];
                    int localWolf = result[1];
                    
                    // 양이 더 많으면 늑대는 죽음, 그렇지 않으면 양이 죽음
                    if (localSheep > localWolf) {
                        sheepCount += localSheep;
                    } else {
                        wolfCount += localWolf;
                    }
                }
            }
        }
        
        System.out.println(sheepCount + " " + wolfCount);
        sc.close();
    } 
    
    public static int[] bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int localSheep = 0;
        int localWolf = 0;
        
        // 첫 좌표에 따라 양과 늑대 초기화
        if (map[x][y] == 'k') localSheep++;
        if (map[x][y] == 'v') localWolf++;
        
        // BFS 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 내에 있고, 방문하지 않았으며 울타리가 아닌 경우에만 탐색
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});

                    // 양과 늑대 세기
                    if (map[nx][ny] == 'k') localSheep++;
                    if (map[nx][ny] == 'v') localWolf++;
                }
            }
        }
        
        // 양과 늑대의 수를 배열로 반환
        return new int[]{localSheep, localWolf};
    }
}
