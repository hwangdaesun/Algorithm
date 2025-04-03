package 투포인터;

import java.io.*;
import java.util.*;
public class BJ_2003 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int j =0;
        int sum = input[j];
        int count = 0;

        for(int i=0; i<n; i++){
            while(sum < m && j < n){
                j++;
                if(j == n) break;
                sum += input[j];
            }
            if(j == n) break;
            if(sum == m) count++;
            sum -= input[i];
        }

        System.out.println(count);
    }
}
