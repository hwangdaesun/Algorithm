package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_한줄로서기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = -1;
        }
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for(int i=0; i<n; i++){
            int count = 0;
            int idx = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == -1){
                    count ++;
                }
                if(count == req[i] + 1){
                    idx = j;
                    break;
                }
            }
            arr[idx] = i + 1;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
