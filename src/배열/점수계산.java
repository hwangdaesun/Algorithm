package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 점수계산 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] input = Arrays.stream(strings).mapToInt(Integer::valueOf).toArray();
        int count = 0;
        int bonus = 0;

        for(int i=0; i<n; i++){
            if(input[i] == 1){
                bonus += 1;
            }else {
                bonus = 0;
            }
            count += bonus;
        }

        System.out.println(count);
    }
}
