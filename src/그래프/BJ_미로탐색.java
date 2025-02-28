package 그래프;

import java.io.*;
import java.util.*;
public class BJ_미로탐색 {
    static int n;
    static int m;
    static int[][] input;
    static int[][] dis;

    static int[] dirR = {0,1,0,-1};
    static int[] dirC = {1,0,-1,0};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        input = new int[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            int j = 0;
            for(char c : line.toCharArray()){
                input[i][j] = Integer.valueOf(String.valueOf(c));
                j++;
            }
        }

        dis = new int[n][m];
        bfs(new int[]{0,0});

        System.out.print(dis[n-1][m-1]);
    }

    public static void bfs(int[] rc){
        Queue<int[]> que = new LinkedList<>();
        que.offer(rc);
        dis[rc[0]][rc[1]] = 1;
        while(!que.isEmpty()){
            int[] poll = que.poll();
            for(int i=0; i<4; i++){
                int rr = poll[0] + dirR[i];
                int cc = poll[1] + dirC[i];
                if(rr >= 0 && rr < n && cc >= 0 && cc < m && input[rr][cc] == 1 && dis[rr][cc] == 0){
                    que.offer(new int[]{rr,cc});
                    dis[rr][cc] = dis[poll[0]][poll[1]] + 1;
                }
            }
        }
    }
}
