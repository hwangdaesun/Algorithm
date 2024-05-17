package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();

        for(Character c : input.toCharArray()){
            if(c == '('){
                deque.push(c);
            }else{
                if(deque.isEmpty()){
                    System.out.println("NO");
                    return;
                }else{
                    deque.pop();
                }
            }
        }

        if(deque.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
