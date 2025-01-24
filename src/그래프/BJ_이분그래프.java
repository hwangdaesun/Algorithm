package 그래프;

import java.io.*;
import java.util.*;

public class BJ_이분그래프 {

    public static List<List<Integer>> graph;
    public static int[] visited;
    public static boolean flag;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer time = Integer.valueOf(br.readLine());

        for(int i=0; i<time; i++){
            flag = false;
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int v = Integer.valueOf(st1.nextToken());
            int e = Integer.valueOf(st1.nextToken());
            graph = new ArrayList<>();
            visited = new int[v+1];

            for(int l=0; l<=v; l++){
                graph.add(new ArrayList<>());
            }

            for(int j=0; j<e; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int v1 = Integer.valueOf(st.nextToken());
                int v2 = Integer.valueOf(st.nextToken());
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            for(int k=1; k<=v; k++){
                if(visited[k] == 0){
                    flag = isBi(k);
                }
                if(!flag) break;
            }
            if (flag) {
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }

        }

        System.out.println(sb);

    }

    public static boolean isBi(int start){
        visited[start] = 1;

        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        while(!que.isEmpty()){
            Integer current = que.poll();
            for(int next : graph.get(current)){

                if (visited[next] == visited[current]) {
                    return false;
                }

                if(visited[next] == 0){
                    if(visited[current] == 1){
                        visited[next] = -1;
                    }else{
                        visited[next] = 1;
                    }
                    que.offer(next);
                }

            }
        }
        return true;
    }

}
