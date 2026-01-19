package 구현;

import java.io.*;
import java.util.*;

public class BJ_이삿짐센터3 {
    public static void main (String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.valueOf(i)).toArray();

        int temp = 0;
        int count = 0;

        while(true){
            boolean flag = false;
            for(int i=4; i>=0; i--){

                if(input[i] > 0 && (i + 1 + temp <= 5)){
                    input[i] -= 1;
                    temp += (i+1);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                temp = 0;
                count++;
            }

            if(input[0] == 0 && input[1] == 0 && input[2] == 0 && input[3] == 0 && input[4] == 0){
                if(temp > 0){
                    count++;
                }
                break;
            }
        }

        System.out.println(count);
    }
}
