package 그래프;

import java.io.*;
import java.util.*;
public class BJ_2178 {
    static int[] dirR = {1,0,-1,0};
    static int[] dirC = {0,1,0,-1};
    static int[][] input;

    static int n;
    static int m;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        input = new int[n][m];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                input[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(new int[]{0,0});

        System.out.println(input[n-1][m-1] -1);


    }

    public static void bfs(int[] rc){
        Queue<int[]> que = new LinkedList<>();
        que.offer(rc);
        input[rc[0]][rc[1]] = 2;

        while(!que.isEmpty()){
            int[] poll = que.poll();
            for(int i=0; i<4; i++){
                int rr = poll[0] + dirR[i];
                int cc = poll[1] + dirC[i];
                if(rr > -1 && rr < n && cc > -1 && cc < m && input[rr][cc] == 1){
                    que.offer(new int[]{rr,cc});
                    input[rr][cc] = input[poll[0]][poll[1]] + 1;
                }
            }
        }
    }
}
