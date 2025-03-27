package 그래프;

import java.io.*;
import java.util.*;
public class BJ_1926v2 {
    static int[][] input;
    static int max;
    static int[] dirR = {1,0,-1,0};
    static int[] dirC = {0,1,0,-1};
    static int n;
    static int m;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        input = new int[n][m];

        for(int i=0; i<n; i++){
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(input[i][j] == 1){
                    max = Math.max(max, bfs(new int[]{i,j}));
                    count ++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    public static int bfs(int[] rc){
        input[rc[0]][rc[1]] = 2;
        Queue<int[]> que = new LinkedList<>();
        que.offer(rc);
        int temp = 1;
        while(!que.isEmpty()){
            int[] poll = que.poll();
            for(int i=0; i<4; i++){
                int rr = poll[0] + dirR[i];
                int cc = poll[1] + dirC[i];
                if(rr > -1 && rr < n && cc > -1 && cc < m && input[rr][cc] == 1){
                    input[rr][cc] = 2;
                    que.offer(new int[]{rr,cc});
                    temp++;
                }
            }
        }
        return temp;
    }
}
