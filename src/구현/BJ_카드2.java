package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_카드2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            deque.offer(i);
        }
        System.out.println(deque);

        while((deque.size() > 2)){
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }

        if(deque.size() == 1){
            System.out.println(deque.peek());
        }else {
            System.out.println(deque.pollLast());
        }

    }

}
