package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BJ_이전수열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int idx = 0;
        boolean flag = false;
        for(int i=n-1; i>0; i--){
            if(req[i] < req[i-1]){
                idx = i-1;
                flag = true;
                break;
            }
        }

        if(flag){
            for(int j=n-1; j>idx; j--){
                if(req[idx] > req[j]){
                    int temp = req[j];
                    req[j] = req[idx];
                    req[idx] = temp;
                    break;
                }
            }
            Integer[] req1 = Arrays.stream(req).boxed().toArray(Integer[]::new);
            Arrays.sort(req1, idx+1, n, Collections.reverseOrder());
            Arrays.stream(req1).forEach(i -> System.out.print(i + " "));
        }else{
            System.out.println(-1);
        }
    }
}
