package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class 피보나치수열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(br.readLine());
        int[] fibo = fibo(x);
        Arrays.stream(fibo).forEach(f -> System.out.print(f + " "));
    }

    public static int[] fibo(int n){
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n; i++){
            answer[i] = answer[i-2] + answer[i-1];
        }
        return answer;
    }

}
