import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        int[] parent = new int[n + 1];
        boolean[] vis = new boolean[n + 1];

        Deque<Integer> q = new ArrayDeque<Integer>();
        q.add(1);
        vis[1] = true; 
        
        while(!q.isEmpty()){
          int cur = q.poll(); 
          for(int nxt: g[cur]){
            if(!vis[nxt]){
              vis[nxt] = true; 
              parent[nxt] = cur; 
              q.offer(nxt); 
            }
          }
        }
        
        for(int i =2; i<=n; i++){
          System.out.println(parent[i]);
        }
        
    }
}
    