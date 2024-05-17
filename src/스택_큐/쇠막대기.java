package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 쇠막대기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        int ans = 0;
        Stack<String> stack = new Stack<>();

        for(int i=0; i<input.length; i++){
            if(input[i].equals("(")){
                stack.push(input[i]);
            }else{
                if (i >= 1) {
                    if(!input[i-1].equals(input[i])){
                        if(!stack.isEmpty()){
                            stack.pop();
                            ans += stack.size();
                        }
                    }else{
                        if(!stack.isEmpty()){
                            stack.pop();
                            ans+=1;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
