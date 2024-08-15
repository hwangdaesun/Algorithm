package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_통계학v2 {

    public static int[] req;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        req = new int[n];
        for(int i=0; i<n; i++){
            req[i] = Integer.valueOf(br.readLine());
        }
        System.out.println(average(n));

        System.out.println(mid(n));

        System.out.println(mostRepeat(n));

        System.out.println(roungd(n));
    }
    public static int average(int n){
        double sum = 0;
        for(int i=0; i<req.length; i++){
            sum += req[i];
        }
        return (int)Math.round(sum/n);
    }

    public static int mid(Integer n){
        Arrays.sort(req);
        return req[n/2];
    }

    public static int mostRepeat(Integer n){
        if(req.length == 1){
            return req[0];
        }
        Map<Integer, Integer> maps = new HashMap<>();
        List<Integer> mostFrequencyList = new ArrayList<>();
        boolean flag = false;
        // key 값, value 빈도수
        Arrays.stream(req).forEach(
                r -> {
                    if(maps.containsKey(r)){
                        maps.put(r, maps.get(r)+ 1);
                    }else{
                        maps.put(r,1);
                    }
                }
        );

        int maxKey = req[0];
        Iterator<Integer> iter = maps.keySet().stream().iterator();
        while(iter.hasNext()){
            Integer next = iter.next();
            if(maps.get(next) > maps.get(maxKey)){
                maxKey = next;
            }
        }
        Iterator<Integer> iterator2 = maps.keySet().stream().iterator();
        while(iterator2.hasNext()){
            Integer next = iterator2.next();
            if(maps.get(maxKey) == maps.get(next)){
                if(next != maxKey){
                    flag = true;
                }
                mostFrequencyList.add(next);
            }
        }

        if(flag){
            // 최빈값중 2번째로 작은 값
            Collections.sort(mostFrequencyList);
            return mostFrequencyList.get(1);
        }
        return maxKey;
    }

    public static int roungd(Integer n){
        return req[n-1] - req[0];
    }



}
