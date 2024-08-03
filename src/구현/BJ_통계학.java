package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_통계학 {

    static List<Integer> req = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        for(int i=0; i< n; i++){
            Integer k = Integer.valueOf(br.readLine());
            req.add(k);
        }

        Collections.sort(req);

        int avg = avg(req);
        System.out.println(avg);

        int mid = mid(req);
        System.out.println(mid);

        int mostFrequency = mostFrequency(req);
        System.out.println(mostFrequency);

        System.out.println(req.get(req.size()-1) - req.get(0));
    }

    public static int avg(List<Integer> req){
        double sum = req.stream().mapToDouble(r -> r.doubleValue()).sum();
        double size = req.size();
        return (int)Math.round(sum/size);
    }

    public static int mid(List<Integer> req){
        int size = req.size();
        return req.get(size/2);
    }

    public static int mostFrequency(List<Integer> req){
        if (req.size() == 1){
            return req.get(0);
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> mostFrequencyList = new ArrayList<>();
        boolean flag = false;
        req.stream().forEach(
                r -> {
                    if(map.containsKey(r)){
                        map.put(r, map.get(r)+ 1);
                    }else{
                        map.put(r,1);
                    }
                }
        );

        int maxKey = req.get(0);
        Iterator<Integer> iterator = map.keySet().stream().iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(map.get(next) > map.get(maxKey)){
                maxKey = next;
            }
        }

        // maxKey와 같은 빈도수를 가진 애가 있나 확인
        Iterator<Integer> iterator2 = map.keySet().stream().iterator();
        while(iterator2.hasNext()){
            Integer next = iterator2.next();
            if(map.get(maxKey) == map.get(next)){
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


}
