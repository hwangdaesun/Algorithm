package 스택_큐;

import java.io.*;
import java.util.*;
public class BJ_5397 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        Deque<Character> front = new LinkedList<>();
        Deque<Character> back = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(char c : line.toCharArray()){
                if(c == '<'){
                    if(!front.isEmpty()){
                        Character poll = front.pollLast();
                        back.offerFirst(poll);
                    }
                }else if(c == '>'){
                    if(!back.isEmpty()){
                        Character poll = back.poll();
                        front.offer(poll);
                    }
                }else if(c == '-'){
                    if(!front.isEmpty()){
                        front.pollLast();
                    }
                }else{
                    front.offer(c);
                }
            }
            while(!front.isEmpty()){
                sb.append(front.poll());
            }
            while(!back.isEmpty()){
                sb.append(back.poll());
            }
            sb.append("\n");
            front.clear();
            back.clear();
        }
        System.out.print(sb.toString());
    }
}
