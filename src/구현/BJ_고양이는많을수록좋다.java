package 구현;

import java.io.*;
public class BJ_고양이는많을수록좋다 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(br.readLine());

        if(n <= 1l){
            System.out.println(n);
        }else{
            int count = 0;
            while(n != 1l){
                if(n % 2 == 0){
                    n = n / 2l;
                    count++;
                }else{
                    n =  (n / 2l) + 1;
                    count++;
                }
            }
            System.out.println(count + 1);
        }

    }
}
