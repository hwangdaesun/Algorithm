package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_팰린드롬만들기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] reqs = br.readLine().split("");
        Set<String> set = new HashSet<>(List.of(reqs));
        Map<String, Integer> maps = new TreeMap<>();

        Iterator<String> iterator = set.stream().iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            int count = 0;
            for(int j =0; j<reqs.length; j++){
                if(next.equals(reqs[j])){
                    count++;
                }
            }
            maps.put(next, count);
        }

        StringBuilder sb = new StringBuilder();

        List<String> ss = maps.keySet().stream().collect(Collectors.toList());
        // 홀수가 1개 이상있는 지 확인 만약 그렇다면 해당 출력
        int count = 0;
        String kkey = "";
        boolean flag = false;
        boolean exit = false;
        for(int i=0; i<ss.size(); i++){
            if(Integer.valueOf(maps.get(ss.get(i))) % 2 != 0){
                count ++;
                kkey = ss.get(i);
                flag = true; // 홀수 존재
                if(count > 1){
                    exit = true;
                    break;
                }
            }
        }
//
//        System.out.println(kkey);
//        System.out.println(flag);

        if(exit){
            System.out.println("I'm Sorry Hansoo");
        }else{
            if(flag){
                maps.put(kkey, maps.get(kkey) - 1);
                for(int i=0; i<ss.size(); i++){
                    String key = ss.get(i);
                    Integer value = maps.get(key);
                    // 짝수인 경우와
                    // 0인 경우
                    if(value == 0){
                        continue;
                    }
                    for(int j = 0; j < (value / 2); j++){
                        sb.append(key);
                    }
                }
            }else{
                for(int i=0; i<ss.size(); i++){
                    String key = ss.get(i);
                    Integer value = maps.get(key);
                    // 짝수인 경우와
                    // 0인 경우
                    if(value == 0){
                        continue;
                    }
                    for(int j = 0; j < (value / 2); j++){
                        sb.append(key);
                    }
                }
            }
            String answer = sb.toString();
            String  reverse = sb.reverse().toString();
//            System.out.println("answer : " + answer);
//            System.out.println("reverse : " + reverse);
            if(kkey.isBlank()){
                StringBuilder sb1 = new StringBuilder();
                sb1.append(answer).append(reverse);
                System.out.println(sb1);
            }else{
                StringBuilder sb1 = new StringBuilder();
                sb1.append(answer).append(kkey).append(reverse);
                System.out.println(sb1);
            }
        }
    }
}
