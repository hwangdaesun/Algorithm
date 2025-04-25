package 정렬;

import java.io.*;
import java.util.*;
public class BJ_11652 {
    public static void main(String args[]) throws Exception{
        // hashMap 형태로 한다음에
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        Map<Long, Long> map = new HashMap();

        for(int i=0; i<n; i++){
            Long key = Long.valueOf(br.readLine());
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
//        System.out.println(map);


        List<Long[]> input = new ArrayList();
        for(Long key : map.keySet()){
            input.add(new Long[]{key, map.get(key)});
        }

        // 정렬
        Collections.sort(input, (o1,o2) -> {
            if(o1[1] > o2[1]){
                return -1;
            }else if(o1[1] < o2[1]){
                return 1;
            }else{
                if(o1[0] < o2[0]){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

//        for(Long[] ll : input){
//            System.out.println(ll[0] + " : " + ll[1]);
//        }
        System.out.println(input.get(0)[0]);

    }
}
