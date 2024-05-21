package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_분수찾기 {

    public static int i;
    public static int sum;
    public static int a;
    public static int b;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer input = Integer.valueOf(br.readLine());

        i=0;
        sum=0;

        while(true){
            i++;
            sum += i;

            if(sum >= input){
                break;
            }
        }

        a = i;
        b = 1;


        for(int k = sum; k>input; k--){
            a--;
            b++;
        }

        if(i%2 == 0){
            System.out.println(a + "/" + b);
        }else{
            System.out.println(b + "/" + a);
        }


    }
}
