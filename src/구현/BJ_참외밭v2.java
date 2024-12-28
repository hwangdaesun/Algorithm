package 구현;

import java.io.*;
import java.util.*;
public class BJ_참외밭v2 {

    public static int BL = 0;
    public static int BC = 0;

    public static int SL = 0;
    public static int SC = 0;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer s = Integer.valueOf(st.nextToken());
        List<DD> dds = new ArrayList<>();
        for(int i=0; i<6; i++){
            int[] dirDis = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            dds.add(new DD(dirDis[0], dirDis[1]));
        }
        boolean flag = false;


        for(int i=0; i<6; i++){
            int dir = dds.get(i).dir;
            if(dir == 1 || dir == 2){
                BL = Math.max(BL, dds.get(i).dis);
            }

            if(dir == 3 || dir == 4){
                BC = Math.max(BC, dds.get(i).dis);
            }
            if(i > 0){
                int before = dds.get(i - 1).dir;
                if(before == 1 && dir == 3){
                    SL = dds.get(i-1).dis;
                    SC = dds.get(i).dis;
                    flag = true;
                }
                if(before == 2 && dir == 4){
                    SL = dds.get(i-1).dis;
                    SC = dds.get(i).dis;
                    flag = true;
                }
                if(before == 3 && dir == 2){
                    SL = dds.get(i-1).dis;
                    SC = dds.get(i).dis;
                    flag = true;
                }
                if(before == 4 && dir == 1){
                    SL = dds.get(i-1).dis;
                    SC = dds.get(i).dis;
                    flag = true;
                }
            }
        }

        if(!flag){
            System.out.println(s * (BL * BC - dds.get(0).dis * dds.get(5).dis));
        }else{
            System.out.println(s * (BL * BC - SL * SC));
        }
    }

    public static class DD {
        int dir;
        int dis;

        public DD(int dir, int dis) {
            this.dir = dir;
            this.dis = dis;
        }
    }
}
