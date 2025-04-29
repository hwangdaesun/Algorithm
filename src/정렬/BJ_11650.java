package 정렬;

import java.io.*;
import java.util.*;
public class BJ_11650 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        List<Pos> pos = new ArrayList<Pos>();
        for(int i=0; i<n; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            pos.add(new Pos(input[0], input[1]));
        }


        Collections.sort(pos, (p1, p2) -> {
           if(p1.x < p2.x){
               return -1;
           }else if(p1.x > p2.x){
               return 1;
           }else{
               if(p1.y < p2.y){
                   return -1;
               }else if(p1.y > p2.y){
                   return 1;
               }else{
                   return 0;
               }
           }
        });

        for(int i=0; i<n; i++){
            System.out.println(pos.get(i).x + " " + pos.get(i).y);
        }
    }

    public static class Pos{
        public int x;
        public int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
