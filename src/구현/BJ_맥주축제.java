package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class BJ_맥주축제 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Integer n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());
        Integer k = Integer.valueOf(st.nextToken());

        List<Vc> vcs = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<k; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            Integer v = Integer.valueOf(st1.nextToken());
            Integer c = Integer.valueOf(st1.nextToken());
            vcs.add(new Vc(v,c));
        }

        vcs.sort(new Comparator<Vc>() {
            @Override
            public int compare(Vc o1, Vc o2) {
                if(o1.c > o2.c){
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        System.out.println(vcs);
        Queue<Integer> pq = new PriorityQueue<>();
        int limit = -1;

        for(Vc vc : vcs){
            pq.offer(vc.v);
            sum += vc.v;

            if(pq.size() > n){
                sum -= pq.poll();
            }
            if(pq.size() == n && sum >= m){
                limit = vc.c;
                break;
            }
        }
        System.out.println(limit);


    }

    static class Vc{
        public int v;
        public int c;

        public Vc(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Vc{" +
                    "v=" + v +
                    ", c=" + c +
                    '}';
        }
    }
}

