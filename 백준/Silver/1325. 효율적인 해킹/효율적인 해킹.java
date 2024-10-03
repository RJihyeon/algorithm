import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        int M = Integer.parseInt(st.nextToken()); // 신뢰 관계 수

        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // M개의 신뢰 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A); // B가 A를 신뢰하므로, B -> A로 그래프에 저장
        }

        int[] result = new int[N + 1]; // 각 컴퓨터가 해킹할 수 있는 컴퓨터 수 저장
        boolean[] visited; // 방문 기록

        int maxHack = 0; // 가장 많은 해킹 가능한 컴퓨터 수

        // 각 컴퓨터에 대해 BFS로 해킹 가능한 컴퓨터 수 계산
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = bfs(i, graph, visited);

            maxHack = Math.max(maxHack, result[i]);
        }

        // maxHack과 같은 값을 가진 컴퓨터 번호 출력
        for (int i = 1; i <= N; i++) {
            if (result[i] == maxHack) {
                bw.write(i + " ");
            }
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }

    // BFS method
    public static int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        return count;
    }
}
