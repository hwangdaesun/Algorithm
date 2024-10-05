package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_절댓값힙 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)){
                if(o1 < o2){
                    return -1;
                }else{
                    return 1;
                }
            }else if(Math.abs(o1) < Math.abs(o2)){
                return -1;
            }
            return 1;
        }));

        StringBuilder st = new StringBuilder();

        for(int i=0; i<n; i++){
            Integer k = Integer.valueOf(br.readLine());
            if(k == 0){
                if(!pq.isEmpty()){
                    st.append(pq.poll()).append("\n");
                }else{
                    st.append(0).append("\n");
                }
            }else{
                pq.add(k);
            }
        }
        System.out.println(st.toString());
    }
}
