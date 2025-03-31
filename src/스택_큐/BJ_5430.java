package 스택_큐;
import java.io.*;
import java.util.*;
public class BJ_5430 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            char[] commands = br.readLine().toCharArray();
            Integer n = Integer.valueOf(br.readLine());
            boolean isFront = true;
            String input = br.readLine();
            Deque<Integer> deque = new LinkedList<>();

            if(n != 0){
                String substring = input.substring(1, input.length() - 1);
                int[] array = Arrays.stream(substring.split(",")).mapToInt(Integer::valueOf).toArray();
                for(int kk : array){
                    deque.offer(kk);
                }
            }

            boolean flag = false;
            for(char c : commands){
                if(c == 'R'){
                    isFront = !isFront;
                }else{
                    if(deque.isEmpty()){
                        flag = true;
                        break;
                    }else{
                        if(isFront){
                            deque.poll();
                        }else{
                            deque.pollLast();
                        }
                    }
                }
            }

            if(flag){
                sb.append("error\n");
            }else{
                if(isFront){
                    String ans = deque.toString();
                    String trim = ans.replace(" ", "");
                    sb.append(trim);
                }else{
                    List<Integer> temp = new ArrayList();
                    while(!deque.isEmpty()){
                        temp.add(deque.pollLast());
                    }
                    String ans = temp.toString();
                    String trim = ans.replace(" ", "");
                    sb.append(trim);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
