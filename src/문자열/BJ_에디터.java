package 문자열;

import java.io.*;
import java.util.Stack;

public class BJ_에디터 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] reqs = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        Stack<String> temp = new Stack<>();
        for(int i=0; i<reqs.length; i++){
            stack.push(reqs[i]);
        }
        Integer n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            if(input.length > 1){
                String b = input[1];
                stack.push(b);
            }else{
                String b = input[0];
                switch (b) {
                    case "L":
                        if(!stack.isEmpty()) temp.push(stack.pop());
                        break;
                    case "D":
                        if(!temp.isEmpty()) stack.push(temp.pop());
                        break;
                    case "B":
                        if(!stack.isEmpty()) stack.pop();
                        break;
                }
            }
        }

        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        while(!temp.isEmpty()) bw.write(temp.pop());
        bw.flush();
    }
}
