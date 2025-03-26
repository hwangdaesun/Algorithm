package 탐색;

import java.io.*;
import java.util.*;
public class BJ_1920v2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        int[] nn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nn);

        Integer m = Integer.valueOf(br.readLine());
        int[] mm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for(int mmm : mm){
            if(binarySearch(mmm, nn, 0, nn.length-1)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }

    public static boolean binarySearch(int root, int[] input, int left, int right){
        if(left > right){
            return false;
        }
        int mid = (left + right) / 2;

        if(input[mid] == root){
            return true;
        }else if(input[mid] > root){
            return binarySearch(root, input, left, mid - 1);
        }else{
            return binarySearch(root, input, mid + 1, right);
        }
    }
}
