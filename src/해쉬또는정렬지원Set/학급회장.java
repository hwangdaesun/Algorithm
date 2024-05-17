package 해쉬또는정렬지원Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 학급회장 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split("");

        HashMap<String, Integer> ans = new HashMap<>();
        ans.put("A",0);
        ans.put("B",0);
        ans.put("C",0);
        ans.put("D",0);
        ans.put("E",0);

        for(int i=0; i<n; i++){
            Integer a = ans.get(input[i]);
            ans.put(input[i],++a);
        }


        int max = 0;
        String key = "A";
        for(String s : ans.keySet()){
            if(max < ans.get(s)){
                max = ans.get(s);
                key = s;
            }
        }


        System.out.println(key);
    }
}
