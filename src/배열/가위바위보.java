package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가위바위보 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.valueOf(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for(int i=0; i<x; i++){
            if(a[i] == b[i]){
                System.out.println("D");
            } else if (Math.abs(a[i] - b[i]) == 1) {
                if(a[i] > b[i]){
                    System.out.println("A");
                }else{
                    System.out.println("B");
                }
            }else{
                if(a[i] < b[i]){
                    System.out.println("A");
                }else {
                    System.out.println("B");
                }
            }
        }
    }
}
