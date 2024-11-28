package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_solvedAc {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<Integer> inputs = new ArrayList<>();
        for(int i=0; i<n; i++){
            inputs.add(Integer.valueOf(br.readLine())) ;
        }
        Collections.sort(inputs);
//        System.out.println(inputs);

        int size = inputs.size();
        if(size == 0){
            System.out.println(0);
        }else{
            int removedIdx = (int) Math.round(size * 0.15);
//            System.out.println(removedIdx);
            int fromIdx = removedIdx ;
            int toIdx = size - removedIdx;
//            System.out.println("fromIdx : " + fromIdx);
//            System.out.println("toIdx : " + toIdx);
            List<Integer> subList = inputs.subList(fromIdx, toIdx);
//            System.out.println(subList);
            double ans = subList.stream().mapToInt(Integer::valueOf).sum() / (double) subList.size();
            System.out.println(Math.round(ans));
        }
    }
}
