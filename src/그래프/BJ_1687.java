package 그래프;

import java.io.*;
import java.util.*;
public class BJ_1687 {
    static int[] input;
    static int n;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        Integer k = Integer.valueOf(st.nextToken());

        input = new int[100001];
        bfs(n);

        System.out.println(input[k] - 1);
    }

    public static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        input[start] = 1;
        que.offer(start);

        while(!que.isEmpty()){
            Integer poll = que.poll();

            for(int i=1; i<=3; i++){
                if(i == 1){
                    int next = poll + 1;
                    if(next >= 0 && next < 100001 && input[next] == 0){
                        input[next] = input[poll] + 1;
                        que.offer(next);
                    }
                }
                if(i == 2){
                    int next = poll - 1;
                    if(next >= 0 && next < 100001 && input[next] == 0){
                        input[next] = input[poll] + 1;
                        que.offer(next);
                    }
                }
                if(i == 3){
                    int next = poll * 2;
                    if(next >= 0 && next < 100001 && input[next] == 0){
                        input[next] = input[poll] + 1;
                        que.offer(next);
                    }
                }
            }
        }
    }
}
