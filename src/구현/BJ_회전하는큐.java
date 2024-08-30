package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_회전하는큐 {

    static int count2 = 0;
    static int count3 = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int N = nm[0];
        int M = nm[1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++){
            deque.offer(i);
        }
        boolean flag = true;

        int[] reqs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for(int i=0; i<M; i++){
            int index = 1;
            for(int j=1; j<=deque.size(); j++){
                Integer poll = deque.poll();
                if(reqs[i] == poll){
                    index = j;
                }
                deque.offer(poll);
            }
            flag =true;

            int size = 0;
            if(deque.size() % 2 == 0){
                size = deque.size() / 2;
            }else{
                size = deque.size() / 2 + 1;
            }

            while(flag){
                if(deque.peek() == reqs[i]){
                    deque.poll();
                    break;
                }
                if(index <= size){
                    deque.offer(deque.poll());
                    count2 ++;
                }else{
                    deque.offerFirst(deque.pollLast());
                    count3 ++;
                }
            }
        }
        System.out.println(count3 + count2);

    }
}
