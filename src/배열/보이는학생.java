package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보이는학생 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(br.readLine());
        int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        boolean flag = true;
        int count = 0;
        for(int i=x-1; i>=0; i--){

            for(int j=0; j<i; j++){
                if(q[i] <= q[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
            flag = true;
        }
        System.out.println(count);
    }
}
