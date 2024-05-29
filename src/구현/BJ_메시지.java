package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_메시지 {

    public static Queue<Integer> queue = new LinkedList<>();
    public static Integer count = 1;
    public static List<Integer> ans = new ArrayList<>();
    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int n = array[0];
        int k = array[1];

        for(int i=1;i<=n;i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            if(count == k){
                count = 1;
                ans.add(queue.poll());
            }else{
                count++;
                queue.offer(queue.poll());
            }
        }

        char[] ansans = ans.toString().toCharArray();
        ansans[0] = '<';
        ansans[ansans.length-1] = '>';
        System.out.println(ansans);


    }
}
