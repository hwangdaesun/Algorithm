package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등수구하기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] answer = new int[n];


        for(int i=0;i<n;i++){
            int cnt = 1;
            for(int j=0; j<n; j++){
                if(score[i] < score[j]) cnt++;
            }
            answer[i] = cnt;
        }

        for(int k=0; k<n; k++){
            System.out.print(answer[k] + " ");
        }
    }

}


