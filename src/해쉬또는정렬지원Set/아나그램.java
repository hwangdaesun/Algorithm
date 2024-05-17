package 해쉬또는정렬지원Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 아나그램 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length; i++){
            if(map1.containsKey(s1[i])){// 있으면
                Integer n = map1.get(s1[i]);
                map1.put(s1[i],++n);
            }else{
                map1.put(s1[i],1);
            }
        }

        for(int i=0; i<s2.length; i++){
            if(map2.containsKey(s2[i])){// 있으면
                Integer n = map2.get(s2[i]);
                map2.put(s2[i],++n);
            }else{
                map2.put(s2[i],1);
            }
        }

        boolean flag = true;

        if(map1.keySet().size() != map2.keySet().size()){
            flag = false;
        }
        for(String s : map1.keySet()){
            Integer i1 = map1.get(s);
            if(map2.containsKey(s)){
                Integer i2 = map2.get(s);
                if(i1 != i2){
                    flag = false;
                }
            }else{
                flag = false;
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
