package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_수이어쓰기1v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int l = input.length();
        int n = Integer.valueOf(input);
        int sum = 0;

        for(int i=0; i<l-1; i++){
            int next = (int)(Math.pow(10,i+1) - Math.pow(10, i));
            sum += next * (i+1);
        }

        if(l>1){
            sum += (n - Math.pow(10,l-1) + 1) * l;
        }else{
            sum += n;
        }
        System.out.println(sum);
    }
}
