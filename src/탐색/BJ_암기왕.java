package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_암기왕 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n1 = Integer.valueOf(br.readLine());
            int[] before = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] input = Arrays.stream(before).sorted().toArray();

            int n2 = Integer.valueOf(br.readLine());
            int[] results = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for(int j=0; j<results.length; j++){
                boolean flag = find(input, results[j], 0, input.length - 1);
                if(flag){
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean find(int[] input, int k, int start, int last){
        int mid = (start + last) / 2;
        if(start <= last){
            if(k == input[mid]){
                return true;
            }
            if (k > input[mid]) {
                return find(input, k,mid + 1, last);
            } else{
                return find(input, k, start, mid - 1);
            }
        }
        return false;
    }
}
