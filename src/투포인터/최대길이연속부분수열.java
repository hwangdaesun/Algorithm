package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 최대길이연속부분수열 {

    public static void main(String arsg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nk[0];
        int k = nk[1];

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int max = 0;
        for(int i=0; i<n; i++){
            int limit = k;
            int maxCount = 0;
            for(int j=i; j<n; j++){

                if(input[j] == 1){
                    maxCount++;
                    continue;
                }else{
                    if(limit == 0){
                        max = Math.max(max,maxCount);
                        break;
                    }else {
                        limit --;
                        maxCount ++;
                    }
                }

            }
        }
        System.out.println(max);
    }
}
