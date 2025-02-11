package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_ATMv2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(input);

        int sum = 0;
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<=i; j++){
                temp += input[j];
            }
            sum += temp;
        }
        System.out.println(sum);
    }
}
