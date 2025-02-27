package 그래프;

import java.io.*;
import java.util.*;
public class BJ_그림 {
    static int max = 0;
    static int cnt = 0;

    static int[][] input;
    static int[][] isVisited;

    static int[] dirR = {0,1,0,-1};
    static int[] dirC = {1,0,-1,0};

    static int n;
    static int m;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        input = new int[n][m];
        isVisited = new int[n][m];

        for(int i=0; i<n; i++){
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(input[i][j] == 1 && isVisited[i][j] != 1){
                    int temp = bfs(new int[]{i, j});
                    max = Math.max(max, temp);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);

    }

    public static int bfs(int[] rc){
        int temp = 1;
        Queue<int[]> que = new LinkedList();
        que.offer(rc);
        isVisited[rc[0]][rc[1]] = 1;

        while(!que.isEmpty()){
            int[] poll = que.poll();
            int r = poll[0];
            int c = poll[1];

            for(int i=0; i<4; i++){
                int rr = dirR[i] + r;
                int cc = dirC[i] + c;
                if(rr >= 0 && rr < n && cc >=0 && cc < m && input[rr][cc] == 1 && isVisited[rr][cc] == 0){
                    que.offer(new int[]{rr,cc});
                    isVisited[rr][cc] = 1;
                    temp ++;
                }
            }
        }
        return temp;
    }

}
