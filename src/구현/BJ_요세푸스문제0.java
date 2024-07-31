package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_요세푸스문제0 {

    static Deque<Integer> deque = new LinkedList<>();
    static List<Integer> ans = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = req[0];
        int k = req[1];


        for(int i=0; i<n; i++){
            deque.offerLast(i+1);
        }
        int i = 1;
        while(!deque.isEmpty()){
            if(i % k == 0){
                ans.add(deque.pollFirst());
            }else {
                Integer first = deque.pollFirst();
                deque.offerLast(first);
            }
            i++;
        }
        System.out.println(ans.toString().replace('[','<').replace(']','>'));
    }
}
