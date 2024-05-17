package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 뒤집은소수 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        String[] strs = br.readLine().split(" ");

        List<Integer> ans = new ArrayList<>();

        boolean flag = true;
        for(int i=0; i<n; i++){
            Integer x = Integer.valueOf(new StringBuilder(strs[i]).reverse().toString());

            if(x == 1){
                flag = false;
            }

            for(int j=2; j<x; j++){
                if(x % j == 0){
                    flag = false;
                }
            }

            if(flag){
                ans.add(x);
            }
            flag = true;
        }

        ans.stream().forEach(a -> System.out.print(a + " "));
    }
}
