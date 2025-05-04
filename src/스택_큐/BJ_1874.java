package 스택_큐;

import java.io.*;
import java.util.*;
public class BJ_1874 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        List<Integer> as = new ArrayList<>();
        for(int i=0; i<n; i++){
            as.add(Integer.valueOf(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        int top = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            if(top < as.get(i)){
                for(int j=top + 1; j<= as.get(i); j++){
                    stack.push(j);
                    sb.append("+\n");
                }
                top = as.get(i);
                stack.pop();
                sb.append("-\n");
            }else{
                if(!stack.isEmpty()){
                    Integer pop = stack.pop();
                    if(pop.equals(as.get(i))){
                        sb.append("-\n");
                    }else{
                        sb.setLength(0);
                        sb.append("NO");
                        break;
                    }
                }else{
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
