package 정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_최소회의실개수 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int[] rooms = new int[n];
        List<Time> times = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            Time time = new Time(start, end);
            times.add(time);
        }

        times.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.start - o2.start;
            }
        });

        for(int i=0; i<times.size(); i++){
            for(int j=0; j<rooms.length; j++){
                if(rooms[j] <= times.get(i).start){
                    rooms[j] = times.get(i).end;
                    break;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<rooms.length; i++){
            if(rooms[i] != 0){
                ans++;
            }
        }

        System.out.println(ans);
    }
    static class Time{
        int start;
        int end;
        Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
