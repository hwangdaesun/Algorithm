package 구현;

import java.io.*;
import java.util.*;

public class BJ_탑 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        for (int j = 1; j <= n; j++) {
            int token = Integer.valueOf(st.nextToken());
            int[] t = {token,j};
            while(!stack.isEmpty()){
                if(stack.peek()[0] > token){
                    bw.write(stack.peek()[1] + " ");
                    stack.push(t);
                    break;
                }else{
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                stack.push(t);
                bw.write("0 ");
            }
        }
        bw.flush();
    }
}
