package 탐색;

import java.io.*;
import java.util.*;
public class BJ_1920 {
    static int[] nn;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        nn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(nn);
        int m = Integer.valueOf(br.readLine());
        int[] mm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for(int i=0; i<m; i++){
            System.out.println(binary_search(0,n-1, mm[i]));
        }

    }
    public static int binary_search(int left, int right, int root){
        if(left > right){
            return 0;
        }
        int mid = (left + right) / 2;
        int temp = nn[mid];

        if(temp < root){
            return binary_search(mid + 1, right, root);
        }else if(temp == root){
            return 1;
        }else{
            return binary_search(left, mid-1, root);
        }

    }
}
