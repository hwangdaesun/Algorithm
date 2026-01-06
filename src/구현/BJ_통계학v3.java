package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BJ_통계학v3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<a; i++){
            int aa = Integer.parseInt(br.readLine());
            sum += aa;
            list.add(aa);
        }

        int size = list.size();
        // 산술 평균

        int av = Math.round((float)sum / size);
        System.out.println(av);

        Collections.sort(list);
        // 중앙값
        System.out.println(list.get((size-1)/2));

        // 최빈값

        Map<Integer, Integer> map = new HashMap();
        for(int l : list){
            map.put(l, map.getOrDefault(l, 0) + 1);
        }

        // value가 가장 큰 것

        // value가 가장 큰 게 2개 이상일 경우 key가 두 번째로 작은 것.

        // value가 가장 크고 key가 가장 작은 것

        int key1 = Integer.MAX_VALUE;
        int value1 = Integer.MIN_VALUE;

        int key2 = Integer.MAX_VALUE;
        int value2 = Integer.MIN_VALUE;

        for(Entry<Integer, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            int key = entry.getKey();

            if((value > value2) || (value == value2 && key < key2)){
                int temp = value2;
                value2 = value;
                value = temp;

                temp = key2;
                key2 = key;
                key = temp;
            }

            if((value2 > value1) || (value2 == value1 && key2 < key1)){
                int temp = value1;
                value1 = value2;
                value2 = temp;

                temp = key1;
                key1 = key2;
                key2 = temp;
            }
        }

        if(value1 == value2){
            System.out.println(key2);
        }else{
            System.out.println(key1);
        }

        // 범위
        System.out.println(list.get(size-1) - list.get(0));

    }
}
