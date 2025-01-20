package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_DFS와BFS {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] input;
    public static int[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        Integer node = Integer.valueOf(st1.nextToken());
        Integer line = Integer.valueOf(st1.nextToken());
        Integer root = Integer.valueOf(st1.nextToken());

        input = new int[node+1][node+1];
        visited = new int[node+1];

        for(int i=0; i<line; i++){
            int[] se = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int start = se[0];
            int end = se[1];
            input[start][end] = 1;
            input[end][start] = 1;
        }

        dfs(root);
        sb.append("\n");

        for(int i=0; i<visited.length; i++){
            visited[i] = 0;
        }

        bfs(root);
        System.out.println(sb);
    }

    public static void dfs(int root){
        int len = input.length;
        int i = root;
        sb.append(root + " ");
        visited[i] = 1;
        for(int j=0; j<len; j++){
            if(input[i][j] == 1){
                if(visited[j] != 1){
                    dfs(j);
                }
            }
        }
    }

    public static void bfs(int root){
        int len = input.length;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(root);
        visited[root] = 1;
        while(!nodes.isEmpty()){
            Integer current = nodes.poll();
            sb.append(current + " ");
            for(int j=0; j<len; j++){
                if(input[current][j] == 1){
                    if(visited[j] != 1){
                        nodes.offer(j);
                        visited[j] = 1;
                    }
                }
            }
        }
    }

}
