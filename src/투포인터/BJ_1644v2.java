package 투포인터;

import java.io.*;
import java.util.*;
public class BJ_1644v2 {
    static boolean[] isPrime;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        isPrime = new boolean[n+1];
        makePrimes(n);
        List<Integer> input = new ArrayList<>();
        for(int i=0; i<isPrime.length; i++){
            if(isPrime[i]){
                input.add(i);
            }
        }


        int size = input.size();
        int j = 0;
        int sum = 0;
        if(!input.isEmpty()) sum = input.get(0);
        int ans = 0;
        for(int i=0; i<size; i++){
            while(j < size && sum < n){
                j++;
                if(j == size) break;
                sum += input.get(j);
            }
            if(sum == n) ans++;
            sum-=input.get(i);
        }

        System.out.print(ans);
    }

    public static void makePrimes(int n){
        for(int i=0; i<n+1; i++){
            isPrime[i] = true; // 소수
        }
        isPrime[0] = false;
        isPrime[1] = false;

        // 배수일 경우
        for(int i=2; i*i<n+1; i++){
            if(isPrime[i]){
                for(int j=i*i; j<n+1; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}
