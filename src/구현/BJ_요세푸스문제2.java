package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_요세푸스문제2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for(int i=1; i<=n; i++){
            que.add(i);
        }

        while(!que.isEmpty()){
            for(int j=1; j<=k; j++){
                if(j == k){
                    Integer poll = que.poll();
                    sb.append(poll);
                    sb.append(", ");
                }else{
                    Integer poll = que.poll();
                    que.add(poll);
                }
            }
        }

        sb.append('>');
        sb.delete(sb.length()-3, sb.length()-1);
        System.out.println(sb);
    }
}
