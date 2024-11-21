package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_창고다각형 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<Stick> sticks = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer x = Integer.valueOf(st.nextToken());
            Integer y = Integer.valueOf(st.nextToken());
            sticks.add(new Stick(x,y));
        }

        sticks.sort(Comparator.comparing(stick -> stick.x));

        // 가장 큰 선 찾기
        int maxIdx = getMaxLeftIdx(0, n, sticks);

        List<Stick> leftStick = new ArrayList<>();

        int leftIdx = maxIdx;
        while(leftIdx > 0){
            leftIdx = getMaxLeftIdx(0, leftIdx, sticks);
            leftStick.add(sticks.get(leftIdx));
        }

        int rightIdx = maxIdx;
        List<Stick> rightStick = new ArrayList<>();
        while(rightIdx < n-1){
            rightIdx = getMaxRightIdx(rightIdx+1, n, sticks);
            rightStick.add(sticks.get(rightIdx));
        }

        int maxLeftX = sticks.get(maxIdx).x;
        int maxLeftY = sticks.get(maxIdx).y;

        int maxRightY = sticks.get(maxIdx).y;

        int totalArea = 0;
        if(leftStick.isEmpty() && rightStick.isEmpty()) {
            totalArea = maxRightY;
        } else if(leftStick.isEmpty()){
            totalArea = (rightStick.get(rightStick.size() - 1).x + 1 - maxLeftX) * maxLeftY;
        } else if (rightStick.isEmpty()) {
            totalArea = (maxLeftX + 1 - leftStick.get(leftStick.size()-1).x) * maxLeftY;
        } else{
            totalArea = (rightStick.get(rightStick.size() - 1).x + 1 - leftStick.get(leftStick.size()-1).x) * maxLeftY;
        }

        for(int i=0; i<leftStick.size(); i++){
            Stick stick = leftStick.get(i);
            int width = 0;
            if(i == 0){
                width = maxLeftX - stick.x;
            }else{
                width = leftStick.get(i-1).x - stick.x;
            }
            int height = maxLeftY - stick.y;
            int area = width * height;
            totalArea -= area;
        }

        for(int j=0; j<rightStick.size(); j++){
            Stick stick = rightStick.get(j);
            int width = 0;
            if(j == 0){
                width = stick.x - maxLeftX;
            }else{
                width = stick.x - rightStick.get(j-1).x;
            }
            int height = maxRightY - stick.y;
            int area = width * height;
            totalArea -= area;
        }

        System.out.println(totalArea);

    }

    private static int getMaxLeftIdx(Integer start , Integer end, List<Stick> sticks) {
        int maxH = 0;
        int maxIdx = 0;
        for(int i = start; i< end; i++){
            if(maxH < sticks.get(i).y){
                maxH = sticks.get(i).y;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static int getMaxRightIdx(Integer start , Integer end, List<Stick> sticks) {
        int maxH = sticks.get(start).y;
        int maxIdx = start;
        for(int i = start; i< end; i++){
            if(maxH < sticks.get(i).y){
                maxH = sticks.get(i).y;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static class Stick{
        int x;
        int y;

        public Stick(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Stick{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


}

