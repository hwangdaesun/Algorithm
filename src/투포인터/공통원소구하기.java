package 투포인터;

import java.io.*;
import java.util.*;

public class 공통원소구하기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> cl = new ArrayList<>();
        int c1=0;

        List<Integer> al = new ArrayList<>();
        for(int a1 : a){
            al.add(a1);
            cl.add(a1);
            c1++;
        }

        Integer m = Integer.valueOf(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> bl = new ArrayList<>();
        for(int b1 : b){
            bl.add(b1);
            cl.add(c1,b1);
            c1++;
        }

        Set<Integer> set = new HashSet<>(cl);


        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(cl.contains(next)){
                cl.remove(next);
            }
        }

        cl.stream().sorted().forEach(c -> System.out.print(c + " "));


    }
}
