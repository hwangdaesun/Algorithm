package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_큐2 {
    static Deque<Integer> deque = new LinkedList<>();
    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++){
            String[] reqs = br.readLine().split(" ");
            if(reqs.length > 1){
                deque.offer(Integer.valueOf(reqs[1]));
            }else{
                switch (reqs[0]){
                    case "pop":
                        if(deque.isEmpty()){
                            sb.append("-1").append("\n");
                        }else{
                            Integer poll = deque.poll();
                            sb.append(poll).append("\n");
                        }
                        break;
                    case "size":
                        if(deque.isEmpty()){
                            sb.append("0").append("\n");
                        }else{
                            sb.append(deque.size()).append("\n");
                        }
                        break;
                    case "empty":
                        if(deque.isEmpty()){
                            sb.append("1").append("\n");
                        }else{
                            sb.append("0").append("\n");
                        }
                        break;
                    case "front":
                        if(deque.isEmpty()){
                            sb.append("-1").append("\n");
                        }else{
                            sb.append(deque.peek()).append("\n");
                        }
                        break;
                    case "back":
                        if(deque.isEmpty()){
                            sb.append("-1").append("\n");
                        }else{
                            sb.append(deque.peekLast()).append("\n");
                        }
                        break;
                }
            }
        }
        System.out.println(sb);
    }
}
