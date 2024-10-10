import java.util.*;

public class Main {
    public static int N, M; // 세로, 가로
    public static int K; // 음식물의 개수
    public static boolean[][] visited;
    public static int[][] paper;
    public static int area;
    public static int maxArea = 0;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        paper = new int[N][M]; // 도화지 초기화
        visited = new boolean[N][M]; // 방문 여부 배열 초기화

        // 음식물 쓰레기 위치 입력 받아서 도화지에 채우기
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            paper[r][c] = 1;
        }

        // 전체 영역 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    area = 0;
                    DFS(i, j); // DFS 호출
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(maxArea);
        sc.close();
    }

    // DFS 메소드를 static으로 !!!
    public static void DFS(int x, int y) {
        visited[x][y] = true;
        area++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < M && paper[nx][ny] == 1 && !visited[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }
}
