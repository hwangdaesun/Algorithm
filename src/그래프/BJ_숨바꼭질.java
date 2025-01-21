package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_숨바꼭질 {
    static int[] input;
    static int start;
    static int end;
    static int limit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        start = n;
        end = k;
        if(start == end){
            System.out.println(0);
        }else{
            limit = 100001;
            input = new int[limit];

            bfs();
        }

    }
    public static void bfs() {
        int[] visited = new int[limit];
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = 1;

        while (!que.isEmpty()) {
            Integer temp = que.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if(i == 0){
                    next = temp + 1;
                }else if(i == 1){
                    next = temp - 1;
                }else{
                    next = temp * 2;
                }

                if (next == end) {
                    System.out.println(visited[temp]);
                    return;
                }

                if(next >= 0 && next < visited.length && visited[next] == 0){
                    que.offer(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }

}

