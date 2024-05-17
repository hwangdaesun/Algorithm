package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 공통원소구하기2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> al = new ArrayList<>();
        for(int a1 : a){
            al.add(a1);
        }

        Integer m = Integer.valueOf(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> bl = new ArrayList<>();
        for(int b1 : b){
            bl.add(b1);
        }

        List<Integer> sorta = al.stream().sorted().collect(Collectors.toList());
        List<Integer> sortb = bl.stream().sorted().collect(Collectors.toList());

        int i =0;
        int j =0;
        String ans = "";
        while(i<n && j<m){
            if(sorta.get(i) < sortb.get(j)){
                i++;
            } else if (sorta.get(i) > sortb.get(j)) {
                j++;
            }else{
                ans += sorta.get(i) + " ";
                i++;
                j++;
            }
        }
        System.out.println(ans);
    }
}
