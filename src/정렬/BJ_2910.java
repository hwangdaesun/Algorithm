package 정렬;

import java.io.*;
import java.util.*;
public class BJ_2910 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        
        List<Integer> input = new ArrayList();
        HashMap<Integer, Integer> fq = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> first = new HashMap<Integer, Integer>();
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int time = 1;
        for(int i : inputs){
            fq.put(i, fq.getOrDefault(i, 0) + 1);
            input.add(i);
            if(!first.containsKey(i)){
                first.put(i, time);
            }
            time ++;
        }

        Collections.sort(input, (o1, o2) -> {
           if(fq.get(o1) > fq.get(o2)){
               return -1;
           }else if(fq.get(o1) < fq.get(o2)){
               return 1;
           }else{
               if(first.get(o1) < first.get(o2)){
                   return -1;
               }else if(first.get(o1) > first.get(o2)){
                   return 1;
               }else{
                   return 0;
               }
           }
        });

        StringBuilder sb = new StringBuilder();
        for(int i : input){
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
}
