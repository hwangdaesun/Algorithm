package 정렬;

import java.io.*;
import java.util.*;
public class BJ_1181 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        Set<String> sets = new HashSet<>();
        for(int i=0; i<n; i++){
            sets.add(br.readLine());
        }
        List<String> list = new ArrayList<>();

        for(Object ss : sets.toArray()){
            list.add((String) ss);
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() > o2.length()){
                return 1;
            }else{
                return o1.compareTo(o2);
            }
        } );

        for(String s : list){
            System.out.println(s);
        }
    }
}
