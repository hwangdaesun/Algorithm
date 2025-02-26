package 탐색;

import java.io.*;
import java.util.*;
public class BJ_나무자르기 {
    static int mid = 0;
    static int m = 0;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int ans = binarySearch(0, 1000_000_000, input);
        System.out.print(ans);
    }

    public static int binarySearch(int left, int right, int[] input){
        while(left <= right){
            mid = (left + right) / 2;
            long sum = 0;

            for(int h : input){
                int gap = (h - mid) > 0 ? h-mid : 0;
                sum += gap;
            }

            if(m > sum){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
