package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 공주님구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<inputs[0]; i++){
            int a = i+1;
            queue.offer(a);
        }
        int k = 1;
        while(queue.size() != 1){
            if(k % 3 == 0){
                queue.poll();
            }else{
                queue.offer(queue.poll());
            }
            k++;

        }
        System.out.println(queue.peek());
    }
}
