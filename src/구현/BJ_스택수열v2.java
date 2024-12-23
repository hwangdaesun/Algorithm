package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BJ_스택수열v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        List<Integer> inputs = new ArrayList<>();

        for(int i=0; i<n; i++){
            inputs.add(Integer.valueOf(br.readLine()));
        }

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int top = 0;

        for(int i=0; i<n; i++){
            int next = inputs.get(i);

            if(next > top){
                for(int j = top + 1; j<=next; j++){
                    deque.offer(j);
                    sb.append("+\n");
                }
                top = next;
            }else if(deque.peekLast() != next){
                System.out.println("NO");
                return;
            }
            deque.pollLast();
            sb.append("-\n");
        }
        System.out.println(sb);

    }
}
