package 스택_큐;

import java.io.*;
import java.util.*;

public class BJ_17298 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> ans = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= input[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(input[i]);
                ans.push(-1);
            }else{
                Integer peek = stack.peek();
                ans.push(peek);
                stack.push(input[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!ans.isEmpty()){
            Integer pop = ans.pop();
            sb.append(pop);
            sb.append(" ");
        }

        System.out.println(sb.toString());

    }
}
