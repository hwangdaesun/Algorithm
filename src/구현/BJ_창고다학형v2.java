package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_창고다학형v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<XY> all = new ArrayList<>();
        List<XY> lefts = new ArrayList<>();
        List<XY> rights = new ArrayList<>();


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer x = Integer.valueOf(st.nextToken());
            Integer y = Integer.valueOf(st.nextToken());
            XY xy = new XY(x, y);
            all.add(xy);
        }

        all.sort(Comparator.comparing(a -> a.x));

        int maxX = all.get(0).x;
        int maxY = all.get(0).y;
        int maxIdx = 0;

        for(int i=0; i<n; i++){
            if(all.get(i).y > maxY){
                maxX = all.get(i).x;
                maxY = all.get(i).y;
                maxIdx = i;
            }
        }

        int tempY = 0;
        for(int i = 0; i < maxIdx; i++){
            if(i == 0){
                lefts.add(all.get(0));
                tempY = all.get(i).y;
            }else{
                int nextY = all.get(i).y;
                if(tempY <= nextY){
                    lefts.add(all.get(i));
                    tempY = nextY;
                }
            }
        }

//        System.out.println(maxIdx);
//        System.out.println(all);
//        System.out.println(lefts);

        tempY = 0;
        for(int i = n-1; i > maxIdx; i--){
            if(i == n-1){
                rights.add(all.get(n-1));
                tempY = all.get(i).y;
            }else{
                int nextY = all.get(i).y;
                if(tempY <= nextY){
                    rights.add(all.get(i));
                    tempY = nextY;
                }
            }

        }
//
//        System.out.println(rights);

        int width = maxY;
        int leftX = maxX;
        for(int i=lefts.size()-1; i >= 0; i--){
            int xx = leftX - lefts.get(i).x;
            width += xx * lefts.get(i).y;
            leftX = lefts.get(i).x;
        }

        int rightX = maxX + 1;
        for(int i=rights.size() - 1; i >=0; i--){
            int xx = rights.get(i).x + 1 - rightX;
            width += xx * rights.get(i).y;
            rightX = rights.get(i).x + 1;
        }

        System.out.println(width);


    }
    static class XY{
        public int x;
        public int y;
        public XY(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "XY{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
