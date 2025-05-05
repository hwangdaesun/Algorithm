package 스택_큐;

import java.io.*;
import java.util.*;

public class BJ_2493v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        List<int[]> input = new ArrayList<>();
        int[] arrays = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for(int i=0; i<n; i++){
            input.add(new int[]{arrays[i], i+1});
        }

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty()){
                int[] peek = stack.peek();
                if(peek[0] > input.get(i)[0]){
                    sb.append(peek[1] + " ");
                    stack.push(input.get(i));
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(input.get(i));
            }
        }
        System.out.println(sb.toString());
    }
}
