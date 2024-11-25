package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_등수구하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int score = Integer.valueOf(st.nextToken());
        int size = Integer.valueOf(st.nextToken());
        boolean flag = true;

        if(n>0){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Integer> pq = new PriorityQueue<>(size+1);
            for(int i=0; i<n; i++){
                Integer n1 = Integer.valueOf(st1.nextToken());
                pq.add(n1);
            }

            pq.add(score);
            int pqSize = pq.size();
            if(pqSize > size){
                for(int i = 0; i< pqSize - size; i++){
                    if(i == 0){
                        if(score == pq.peek()){
                            flag = false;
                            System.out.println(-1);
                            break;
                        }
                    }
                    pq.poll();
                }
            }

            if (flag) {
                PriorityQueue<Integer> npq = new PriorityQueue<>(Collections.reverseOrder());
                while(!pq.isEmpty()){
                    npq.add(pq.poll());
                }

                int rank = 1;
                int realRank = 1;
                int before = 0;
                while(!npq.isEmpty()){
                    if(score == npq.peek()){
                        if(before == npq.peek()){
                            System.out.println(rank);
                        }else{
                            System.out.println(realRank);
                        }
                        break;
                    }else{
                        if(before == npq.peek()){
                            realRank++;
                        }else{
                            rank++;
                            realRank++;
                        }
                        before = npq.poll();
                    }
                    if(npq.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                }
            }
        }else {
            System.out.println(1);
        }
    }
}
