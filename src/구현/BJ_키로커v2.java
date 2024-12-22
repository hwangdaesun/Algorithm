package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_키로커v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++){
            String calculate = calculate(br.readLine());
            System.out.println(calculate);
        }
    }

    private static String calculate(String input){
        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();

        for(Character c : input.toCharArray()){
            if(c.equals('<')){
                if(!deque1.isEmpty()){
                    deque2.offer(deque1.pollLast());
                }
            } else if (c.equals('>')){
                if(!deque2.isEmpty()){
                    deque1.offer(deque2.pollLast());
                }
            } else if (c.equals('-')) {
                deque1.pollLast();
            }else{
                deque1.offer(c.toString());
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!deque2.isEmpty()){
            deque1.offer(deque2.pollLast());
        }

        while(!deque1.isEmpty()){
            sb.append(deque1.poll());
        }
        return sb.toString();
    }
}
