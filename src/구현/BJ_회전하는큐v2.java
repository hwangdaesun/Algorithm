package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ_회전하는큐v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++){
            deque.offer(i);
        }

        int ans = 0;

        for(int i=0; i<m; i++){
            int find = Integer.valueOf(st1.nextToken());

            boolean right = isRight(deque, find);
            if(right){
                while(deque.peekFirst() != find){
                    deque.offerFirst(deque.pollLast());
                    ans+= 1;
                }
            }else{
                while(deque.peekFirst() != find){
                    deque.offer(deque.poll());
                    ans+=1;
                }
            }
            deque.poll();
        }

        System.out.println(ans);


    }

    public static boolean isRight(Deque<Integer> deque, Integer find){
        int size = deque.size();
        int bound = size/2;

        List<Integer> list = deque.stream().collect(Collectors.toList());
        int idx = list.indexOf(find);

        if(idx > bound){
            return true;
        }
        return false;
    }
}
