package 투포인터;

import java.io.*;
import java.util.*;

public class BJ_1644 {

    public static boolean[] primes;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        // 2 ~ n 까지의 소수 구하기
        primes = new boolean[n+1];
        makePrimes(n);
        List<Integer> rPrimes = new ArrayList<>();

        for(int i=0; i<primes.length; i++){
            if(!primes[i]) rPrimes.add(i);
        }

        int sum = 0;
        if(!rPrimes.isEmpty()) sum = rPrimes.get(0);

        int j=0;
        int ans = 0;
        for(int i=0; i<rPrimes.size(); i++) {
            while(sum < n && j < rPrimes.size()) {
                j++;
                if(j == rPrimes.size()) break;
                sum += rPrimes.get(j);
            }
            if(sum == n){
                ans ++;
            }
            sum -= rPrimes.get(i);
        }

        System.out.print(ans);

    }

    public static void makePrimes(int n){
        // 소수 - false
        // 일반 - true
        primes[0] = true;
        primes[1] = true;

        // i 소수 2 ~ 루트 n, +1
        // j i*i ~ n, j+i
        for(int i=2; i<= Math.sqrt(n); i++){

            if(primes[i]){
                continue;
            }

            for(int j=i+i; j<= n; j = j+i){
                primes[j] = true;
            }
        }
    }
}
