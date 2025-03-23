package 스택_큐;

import java.io.*;
import java.util.*;
public class BJ_6198 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int[] input = new int[n];

        for(int i=0; i<n; i++){
            input[i] = Integer.valueOf(br.readLine());
        }

        long ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            int bd = input[i];

            while(!stack.isEmpty() && stack.peek() <= bd){
                stack.pop();
            }
            ans += stack.size();
            stack.push(bd);
        }

        System.out.println(ans);
    }
}
