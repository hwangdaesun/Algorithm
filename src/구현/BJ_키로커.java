package 구현;

import java.io.*;
import java.util.Stack;

public class BJ_키로커 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.valueOf(br.readLine());
        Stack<Character> as = new Stack<>();
        Stack<Character> bs = new Stack<>();

        for(int i=0; i<n; i++){
            char[] reqs = br.readLine().toCharArray();
            for(int j=0; j<reqs.length; j++){
                if (reqs[j] == '<'){
                    if(!as.isEmpty()) bs.push(as.pop());
                } else if (reqs[j] == '>') {
                    if(!bs.isEmpty()) as.push(bs.pop());
                } else if (reqs[j] == '-') {
                    if(!as.isEmpty()) as.pop();
                }else{
                    as.push(reqs[j]);
                }
            }
            while(!as.isEmpty()){
                bs.push(as.pop());
            }
            while(!bs.isEmpty()){
                bw.write(bs.pop());
            }
            bw.write('\n');
            bw.flush();
        }
    }

}
