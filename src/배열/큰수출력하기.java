package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 큰수출력하기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(br.readLine());
        String str = br.readLine();
        String[] split = str.split(" ");
        int[] q = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();

        for(int i=0;i<x;i++){
            if(i == 0){
                System.out.print(q[i] + " ");
                continue;
            }
            if(q[i-1] < q[i]){
                System.out.print(q[i] + " ");
            }
        }

    }
}
