package 정렬;

import java.io.*;
import java.util.*;
public class BJ_1431 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<String> inputs = new ArrayList<>();
        for(int i=0; i<n; i++){
            inputs.add(br.readLine());
        }

        Collections.sort(inputs,(a,b) -> {
            if(a.length() - b.length() < 0){
                return -1;
            }else if(a.length() - b.length() > 0){
                return 1;
            }else{
                int asum = 0;
                int bsum = 0;
                for(char aa : a.toCharArray()){
                    if(Character.isDigit(aa)){
                        asum += (aa - '0');
                    }
                }
                for(char bb : b.toCharArray()){
                    if(Character.isDigit(bb)){
                        bsum += (bb - '0');
                    }
                }
                if(asum < bsum){
                    return -1;
                }else if(asum > bsum){
                    return 1;
                }else{
                    return a.compareTo(b); // 사전순이 기본인가?
                }
            }
        });

        for(int i=0; i<inputs.size(); i++){
            System.out.println(inputs.get(i));
        }
    }
}
