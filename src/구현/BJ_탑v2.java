package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_탑v2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] reqs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(i == 0){
                deque.push(new int[]{i+1, reqs[i]});
                sb.append("0 ");
            }else{
                while(!deque.isEmpty() && deque.peek()[1] < reqs[i]){
                    deque.pop();
                }
                if(deque.isEmpty()){
                    sb.append("0 ");
                }else{
                    sb.append(deque.peek()[0]).append(" ");
                }
                deque.push(new int[]{i+1,reqs[i]});
            }
        }
        System.out.println(sb);
    }
}
