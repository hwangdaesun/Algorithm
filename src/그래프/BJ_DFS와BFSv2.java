package 그래프;

import java.io.*;
import java.util.*;
public class BJ_DFS와BFSv2 {
    static int[][] input;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int v = Integer.valueOf(st.nextToken());

        input = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            Integer v1 = Integer.valueOf(st1.nextToken());
            Integer v2 = Integer.valueOf(st1.nextToken());
            input[v1][v2] = 1;
            input[v2][v1] = 1;
        }


        isVisited = new boolean[n+1];

        dfs(v);

        for(int i=0; i<isVisited.length; i++){
            isVisited[i] = false;
        }

        sb.append("\n");

        bfs(v);

        System.out.println(sb.toString());

    }

    public static void dfs(int root){
        isVisited[root] = true;
        sb.append(root + " ");
        for(int i=1; i<input[root].length; i++){
            if(input[root][i] == 1 && !isVisited[i]){
                isVisited[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int root){
        isVisited[root] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(root);
        sb.append(root + " ");

        while(!que.isEmpty()){
            Integer poll = que.poll();
            for(int i=0; i<input[poll].length; i++) {
                if (input[poll][i] == 1 && !isVisited[i]) {
                    que.offer(i);
                    isVisited[i] = true;
                    sb.append(i + " ");
                }
            }
        }

    }
}
