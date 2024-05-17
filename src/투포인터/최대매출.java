package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 최대매출 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] days = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = days[0];
        int k = days[1];
        int[] outputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();


        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n-k; i++){
            int count = 0;
            for(int j=i; j<i+k; j++){
                count += outputs[j];
            }
            ans.add(count);
        }

        Integer n1 = ans.stream().max(Comparator.naturalOrder()).get();
        System.out.println(n1);
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processotrs" + processors);
    }
}
