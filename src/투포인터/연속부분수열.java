package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 연속부분수열 {

    public static void main(String ars[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nm[0];
        int m = nm[1];

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int count = 0;

        for(int i=0; i<n; i++){
            int sum = input[i];
            if(sum == m){
                count++;
                continue;
            }

            for(int j=i+1; j<n; j++){
                sum+= input[j];
                if(sum > m){
                    break;
                } else if (sum == m) {
                    count++;
                    break;
                }
            }
            }
        System.out.println(count);
        }

}
