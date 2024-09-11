package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_수이어쓰기1 {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer input = Integer.valueOf(s);
        int n = s.length();
        int sum = 0;
        for(int i=1; i<n; i++){
            sum += func(i);
        }
        int bound = getBound(n, input);
        System.out.println(sum + bound);
    }

    public static int func(int n){
        if(n == 1){
            return 9;
        }
        return (int)((9 * Math.pow(10,n-1)) * n);
    }

    public static int getBound(int n, int input){
        return (int)(input - Math.pow(10,n-1) + 1) * n;
    }
}
