package 그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_숨바꼭질v2 {
    static int[] input;
    static int n;
    static int k;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        int limit = 100000;

        input = new int[limit+1];

        Queue<Integer> que = new LinkedList<>();

        que.offer(n);
        input[n] = 1;

        while(!que.isEmpty()){
            Integer poll = que.poll();

            if (poll == k) {
                System.out.println(input[k] - 1);
                return;
            }

            if(poll - 1 >= 0 && input[poll -1] == 0){
                input[poll - 1] = input[poll] + 1;
                que.offer(poll - 1);
            }

            if(poll + 1 <= limit && input[poll + 1] == 0){
                input[poll + 1] = input[poll] + 1;
                que.offer(poll + 1);
            }

            if(poll * 2 <= limit && input[poll * 2] == 0){
                input[poll * 2] = input[poll] + 1;
                que.offer(poll * 2);
            }
        }

    }

}
