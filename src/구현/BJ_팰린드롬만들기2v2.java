package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BJ_팰린드롬만들기2v2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for(Character c : input.toCharArray()){
            Integer orDefault = tm.getOrDefault(c, 0);

            if(orDefault.equals(0)){
                tm.put(c,1);
            }else{
                tm.put(c,orDefault + 1);
            }
        }

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        // 홀수는 반드시 1개
        List<Character> characters = tm.keySet().stream().filter(t -> tm.get(t) % 2 != 0).collect(Collectors.toList());
        long count = characters.stream().count();
        if(count > 1){
            flag = false;
        }

        if(flag){
            if(count == 0){
                for(Character c : tm.keySet()){
                Integer cnt = tm.get(c);
                    for(int i=0; i<cnt/2; i++){
                       sb.append(c);
                    }
                }
                String original = sb.toString();
                String reverse = sb.reverse().toString();
                String ans = original.concat(reverse);
                System.out.println(ans);
            }else{
                for(Character c : tm.keySet()){
                    Integer cnt = tm.get(c);
                    for(int i=0; i<cnt/2; i++){
                        sb.append(c);
                    }
                }
                String original = sb.toString();
                String reverse = sb.reverse().toString();
                String ans = original.concat(characters.get(0).toString()).concat(reverse);
                System.out.println(ans);
            }
        }else{
            System.out.println("I'm Sorry Hansoo");
        }

    }

}
