package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int count = 0;
        for(int j=1; j<(n/2 + 2); j++){
            int sum = 0;
            for(int i=j; i<(n/2 + 2); i++){
                sum += i;
                if(sum > n){
                    break;
                }else if(sum == n){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
