package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_기타레슨 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] input = new int[n];
        int sum =0 ;
        int start = 1;
        for(int i=0; i<n; i++){
            input[i] = Integer.valueOf(st1.nextToken());
            sum += input[i];
            start = Math.max(start, input[i]);
        }

        int end = sum;

        while(start <= end){
            int mid = (start + end) / 2;
            int calculated = calculate(input, mid, n);
            System.out.println("mid : " + mid + ", cal :  " + calculated);
            if(calculated > m){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(start);

    }
    public static int calculate(int[] input, int size, int n){
        int cnt = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(cnt + input[i] <= size){
                cnt += input[i];
            }else{
                cnt = 0;
                cnt += input[i];
                ans ++;
            }

            if (i == n - 1) {
                if(cnt != 0){
                    ans ++;
                }
            }
        }
        return ans;
    }
}


