package 구현;

import java.io.*;
import java.util.*;

public class BJ_트럭 {
    public static int curL = 0; // 다리 안 트럭 하중
    public static int time = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(tk.nextToken()); // 트럭 수
        Integer w = Integer.valueOf(tk.nextToken()); // 다리 길이
        Integer l = Integer.valueOf(tk.nextToken()); // 최대 하중

        Queue<Integer> trucks = new LinkedList<>();
        StringTokenizer tk1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.valueOf(tk1.nextToken()));
        }

        Queue<Integer> brg = new LinkedList<>();

        time++;
        Integer t = trucks.poll();
        brg.offer(t);
        curL += t;

        while(!trucks.isEmpty()){
            Integer truck = trucks.peek();
            if(brg.size() == w){
                curL -= brg.poll();
            }
            if(curL + truck <= l && brg.size() <= w){
                brg.offer(trucks.poll());
                curL += truck;
            }else{
                brg.offer(0);
            }
            time++;
        }

        System.out.println(time + w);
    }
}
