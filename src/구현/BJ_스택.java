package 구현;

import java.io.*;
import java.util.Stack;

public class BJ_스택 {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            if(s.length == 2){
                stack.push(Integer.valueOf(s[1]));
            }else{
                if(s[0].equals("top")){
                    try{
                        System.out.println(stack.peek());
                    }catch (Exception e){
                        System.out.println(-1);
                    }
                } else if (s[0].equals("empty")) {
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                } else if (s[0].equals("size")) {
                    System.out.println(stack.size());
                } else if (s[0].equals("pop")) {
                    try{
                        Integer pop = stack.pop();
                        System.out.println(pop);
                    }catch (Exception e){
                        System.out.println(-1);
                    }
                }
            }
        }

    }

}
