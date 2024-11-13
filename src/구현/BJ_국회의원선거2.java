package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_국회의원선거2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int me = Integer.parseInt(br.readLine());
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=1; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }


        while(!pq.isEmpty()){
            int max = pq.poll();
            if(max < me){
                break;
            }
            count ++;
            me++;
            pq.offer(max-1);
        }
        System.out.println(count);
    }
}
