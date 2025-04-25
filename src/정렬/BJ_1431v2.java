package 정렬;

import java.io.*;
import java.util.*;

public class BJ_1431v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<String> inputs = new ArrayList<>();

        for(int i=0; i<n; i++){
            inputs.add(br.readLine());
        }

        Collections.sort(inputs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() < s2.length()){
                    return -1;
                }else if(s1.length() > s2.length()){
                    return 1;
                }else{
                    int sum1 = 0;
                    int sum2 = 0;

                    for(char c : s1.toCharArray()){
                        if(Character.isDigit(c)){
                            sum1 += Integer.valueOf(c- '0');
                        }
                    }

                    for(char c : s2.toCharArray()){
                        if(Character.isDigit(c)){
                            sum2 += Integer.valueOf(c - '0');
                        }
                    }

                    if(sum1 < sum2){
                        return -1;
                    }else if(sum1 > sum2){
                        return 1;
                    }else{
                        return s1.compareTo(s2);
                    }
                }
            }
        });

        for(String s : inputs){
            System.out.println(s);
        }
    }
}
