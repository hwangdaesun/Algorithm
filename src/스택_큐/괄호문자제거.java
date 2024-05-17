package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호문자제거 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        boolean flag = true;

        for(Character c : input.toCharArray()){
            if(c == '('){
                flag = true;
                deque.push(c);
            } else if (c == ')') {
                if(flag){
                    deque.push(c);

                    while(!(deque.peek() =='(')){
                        deque.pop();
                    }
                    deque.pop();
                }else{
                    deque.push(c);
                }
            }else{
                if(flag){
                    deque.push(c);
                }
            }
        }
        System.out.println(deque);
        while(!deque.isEmpty()){
            System.out.print(deque.pollLast());
        }
    }

}
