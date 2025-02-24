package 탐색;

import java.io.*;
import java.util.*;

public class BJ_숫자카드 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(input1);

        Integer m = Integer.valueOf(br.readLine());
        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            int target = input2[i];
            int ans = binary_search(input1, target, 0, n - 1);
            sb.append(ans +  " ");
        }

        System.out.print(sb.toString());

    }

    public static int binary_search(int[] array, int target, int start, int end){
        if(start > end){
            return 0;
        }
        int mid = (start + end) / 2;
        if(array[mid] == target){
            return 1;
        }else if(array[mid] > target){
            return binary_search(array, target, start, mid - 1);
        }else{
            return binary_search(array, target, mid + 1, end);
        }
    }

}
