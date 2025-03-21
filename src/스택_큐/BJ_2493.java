package 스택_큐;

import java.io.*;
import java.util.*;
public class BJ_2493 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int bound = input[i];

            while(!stack.isEmpty()){
                if(stack.peek()[1] < bound){
                    stack.pop();
                }else{
                    sb.append(stack.peek()[0]);
                    sb.append(" ");
                    stack.push(new int[]{i+1, input[i]});
                    break;
                }
            }
            if(stack.isEmpty()){
                stack.push(new int[]{i+1,input[i]});
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());

    }
}
