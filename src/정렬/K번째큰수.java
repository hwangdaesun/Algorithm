package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class K번째큰수 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nk[0];
        int k = nk[1];

        int b = 0;
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        TreeSet<Integer> tr = new TreeSet<>(Comparator.reverseOrder());

        for(int i=0; i<input.length-2; i++){
            int sum = 0;
            for(int j=i+1; j<input.length-1; j++){
                for(int l=j+1; l<input.length; l++){
                    sum = input[i] + input[j] + input[l];
                    tr.add(sum);
                    b++;
                }
            }
        }

        int j = 0;

        for(Integer i : tr){
            if(j == k-1){
                System.out.println(i);
                break;
            }
            j++;
        }

        if(j == tr.size()){
            System.out.println(-1);
        }


    }
}
