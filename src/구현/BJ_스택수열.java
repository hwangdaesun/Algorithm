package 구현;

import java.io.*;
import java.util.Stack;

public class BJ_스택수열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        Integer n = Integer.valueOf(br.readLine());
        int i = 0;
        boolean flag = false;
        for(int l=0; l<n; l++){
            int k = Integer.valueOf(br.readLine());
            int m = Math.abs(k - i);
            if(flag) break;
            if(i < k){
                for(int j=0; j<m; j++){
                    stack.push(i+1);
                    sb.append('+');
                    i++;
                }
                Integer aa = stack.pop();
                sb.append('-');
                if(aa != k){
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            } else if (i>k) {
                int aa = 0;
                if(!stack.isEmpty()) aa = stack.pop();
                sb.append('-');
                if(aa != k){
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }

        }
        if(!flag){
            for(char x : sb.toString().toCharArray()){
                System.out.println(x);
            }
        }
    }
}
