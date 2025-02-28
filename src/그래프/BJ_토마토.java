package 그래프;

import java.io.*;
import java.util.*;
public class BJ_토마토 {
    static int[][] input;
    static int[][] time;
    static int n;
    static int m;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dirR = {1, 0, -1, 0};
    static int[] dirC = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        input = new int[m][n];
        time = new int[m][n];

        for(int i=0; i<m; i++){
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(input[i][j] == 1){
                    que.offer(new int[]{i,j});
                    time[i][j] = 1;
                }
            }
        }

        bfs();


        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(time[i][j] == 0 && input[i][j] != -1){
                    System.out.print(-1);
                    return;
                }
                ans = Math.max(time[i][j], ans);
            }
        }
        System.out.print(ans-1);

    }
    public static void bfs(){
        while(!que.isEmpty()){
            int[] poll = que.poll();
            for(int i=0; i<4; i++){
                int rr = poll[0] + dirR[i];
                int cc = poll[1] + dirC[i];
                if(rr >=0 && rr < m && cc >=0 && cc < n && input[rr][cc] == 0 && time[rr][cc] == 0){
                    time[rr][cc] = time[poll[0]][poll[1]] + 1;
                    que.offer(new int[]{rr,cc});
                }
            }
        }
    }
}
