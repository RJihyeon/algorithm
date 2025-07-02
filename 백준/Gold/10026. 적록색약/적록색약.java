import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int regionA; 
    static int regionB; 
    static char[][] map; 
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 색약 아닌 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsA(i, j, map[i][j]);
                    regionA++;
                }
            }
        }

        // visited 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        // 색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsB(i, j, map[i][j]);
                    regionB++;
                }
            }
        }

        System.out.println(regionA + " " + regionB);
    }

    static void dfsA(int x, int y, char color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    dfsA(nx, ny, color);
                }
            }
        }
    }

    static void dfsB(int x, int y, char color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny]) {
                    if (color == 'R' || color == 'G') {
                        if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                            dfsB(nx, ny, color);
                        }
                    } else {
                        if (map[nx][ny] == color) {
                            dfsB(nx, ny, color);
                        }
                    }
                }
            }
        }
    }
}