package 구현;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_큐 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        Integer n = Integer.valueOf(br.readLine());
        for(int i = 0; i<n; i++){
            String[] s = br.readLine().split(" ");
            if(s.length > 1){
                deque.offer(Integer.valueOf(s[1]));
            }else{
                switch (s[0]){
                    case "pop" :
                        if(deque.isEmpty()){
                            sb.append("-1");
                        }else{
                            sb.append(deque.poll());
                        }
                        sb.append('\n');
                        break;
                    case "size":
                        sb.append(deque.size());
                        sb.append('\n');
                        break;
                    case "empty":
                        if(deque.isEmpty()){
                            sb.append("1");
                        }else{
                            sb.append("0");
                        }
                        sb.append('\n');
                        break;
                    case "front":
                        if (deque.isEmpty()){
                            sb.append("-1");
                        }else{
                            Integer peek = deque.peek();
                            sb.append(peek);
                        }
                        sb.append('\n');
                        break;
                    case "back":
                        if (deque.isEmpty()){
                            sb.append("-1");
                        }else{
                            sb.append(deque.peekLast());
                        }
                        sb.append('\n');
                        break;
                }
            }
        }
        System.out.println(sb);
    }
}
