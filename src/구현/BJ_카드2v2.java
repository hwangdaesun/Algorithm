package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_카드2v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            deque.offer(i);
        }

        while(deque.size() > 1){
            deque.poll();
            Integer poll = deque.poll();
            deque.offer(poll);
        }
        System.out.println(deque.peek());
    }
}
