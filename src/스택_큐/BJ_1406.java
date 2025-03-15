package 스택_큐;

import java.io.*;
import java.util.*;

public class BJ_1406 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Deque<Character> front = new LinkedList<>();
        Deque<Character> back = new LinkedList<>();

        for(char c : line.toCharArray()){
            front.offer(c);
        }


        Integer n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("L")) {
                if(!front.isEmpty()){
                    Character c = front.pollLast();
                    back.offerFirst(c);
                }
            } else if (command[0].equals("P")) {
                front.offer(command[1].charAt(0));
            } else if (command[0].equals("D")) {
                if(!back.isEmpty()){
                    Character poll = back.poll();
                    front.offer(poll);
                }
            } else if (command[0].equals("B")) {
                if(!front.isEmpty()){
                    front.pollLast();
                }
            }
        }
//        System.out.println(front);
//        System.out.println(back);

        char[] ans = new char[front.size() + back.size()];

        int i =0;
        while(!front.isEmpty()){
            ans[i] = front.poll();
            i++;
        }
        while(!back.isEmpty()){
            ans[i] = back.poll();
            i++;
        }

        System.out.println(String.valueOf(ans));
    }
}
