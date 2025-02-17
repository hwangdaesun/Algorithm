package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_피보나치함수 {
    static List<ZO> zeroOne = new ArrayList<ZO>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            Integer m = Integer.valueOf(br.readLine());
            zeroOne.add(new ZO(1,0));
            zeroOne.add(new ZO(0,1));
            ZO zo = fibo(m);
            sb.append(zo.zero + " " + zo.one + "\n");
            zeroOne.clear();
        }

        System.out.println(sb);
    }

    public static ZO fibo(int k){
        for(int i=2; i<k+1; i++) {
            int zero = zeroOne.get(i-1).zero + zeroOne.get(i-2).zero;
            int one = zeroOne.get(i-1).one + zeroOne.get(i-2).one;
            zeroOne.add(new ZO(zero, one));
        }
        return zeroOne.get(k);
    }

    public static class ZO{
        int zero;
        int one;

        public ZO(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }
}
