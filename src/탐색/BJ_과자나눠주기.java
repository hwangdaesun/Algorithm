package 탐색;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_과자나눠주기 {
    static int max = 0;
    static int m; // 조카 수
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.valueOf(st.nextToken());
        Integer n = Integer.valueOf(st.nextToken());

        List<Integer> input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList());
        Collections.sort(input);

        binarySearch(input, 1, 1000_000_000);
        System.out.print(max);
    }

    public static void binarySearch(List<Integer> ex, int start, int end){
        if(start > end){
            return;
        }
        int mid = (start + end) / 2;
        int sum = 0;

        for(Integer e : ex){
            sum += (e / mid);
        }

        if(sum < m){
            binarySearch(ex, start, mid - 1);
        }else{
            max = Math.max(max, mid);
            binarySearch(ex, mid + 1, end);
        }
    }
}
