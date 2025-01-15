package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_랜선자르기 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer k = Integer.valueOf(st.nextToken());
        Integer n = Integer.valueOf(st.nextToken());

        long[] input = new long[k];
        long end = 0;

        for(int i=0; i<k; i++){
            input[i] = Long.valueOf(br.readLine());
            if(end < input[i]){
                end = input[i];
            }
        }

        long start = 1;

        while(start <= end){
            long mid = (start + end) / 2;
            int ans = 0;
            for(int i=0; i<input.length; i++){
                ans += input[i] / mid;
            }

           if (ans < n){
               end = mid - 1;
            }else{
               start = mid + 1;
            }
        }


        System.out.println(end);
    }
}
