package 투포인터;

import java.io.*;
import java.util.*;
public class BJ_1806 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int s = Integer.valueOf(st.nextToken());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int j = 0;
        int sum = input[0];
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            while(j < n && s > sum){
                j ++;
                if(j == n) break;
                sum += input[j];
            }
            if(j == n) break;
            ans = Math.min(ans, j-i+1);
            sum -= input[i];
        }

        if(ans == Integer.MAX_VALUE){
            System.out.print(0);
        }else{
            System.out.print(ans);
        }
    }
}
