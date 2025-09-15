import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());     // 도시 수
        int M = Integer.parseInt(br.readLine());     // 버스(간선) 수

        // 인접 리스트: adj[u]에 [w, v] 저장
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[]{w, v}); // 방향 그래프
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        final int INF = 1_000_000_000;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // pq: [cost, node] (최소 힙)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int x = cur[1];

            if (d > dist[x]) continue;
            if (x == last) break; // 목표만 필요하면 조기 종료(선택)

            for (int[] e : adj.get(x)) {
               int w = e[0]; 
               int v = e[1]; 
               if(dist[v] > d + w){
                  dist[v] = d + w;
                  pq.offer(new int[]{dist[v], v});
               }
            }
        }

        System.out.println(dist[last]);
    }
}