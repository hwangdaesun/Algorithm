package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_수열 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int max = 0;
        int flag = 0;
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        stack.push(Integer.valueOf(st.nextToken()));
        if(n>1){
            Integer nextValue = Integer.valueOf(st.nextToken());

            if(nextValue > stack.peek()){
                flag = 1;
                stack.push(nextValue);
            } else if (nextValue < stack.peek()) {
                flag = -1;
                stack.push(nextValue);
            }else{
                flag = 0;
                stack.push(nextValue);
            }

            max = stack.size();

            for(int i=2; i<n; i++){
                max = Math.max(stack.size(), max);
                Integer next = Integer.valueOf(st.nextToken());
                if(flag == 0){
                    if(next > stack.peek()){
                        stack.push(next);
                        flag = 1;
                        continue;
                    } else if (next < stack.peek()) {
                        stack.push(next);
                        flag = -1;
                        continue;
                    }else{
                        stack.push(next);
                    }
                }

                if(flag == 1){
                    if(next > stack.peek()){
                        stack.push(next);
                    } else if (next < stack.peek()) {
                        renew(stack);
                        stack.push(next);
                        flag = -1;
                        continue;
                    }else{
                        stack.push(next);
                    }
                }

                if(flag == -1){
                    if(next > stack.peek()){
                        renew(stack);
                        stack.push(next);
                        flag = 1;
                    } else if (next < stack.peek()) {
                        stack.push(next);
                    }else{
                        stack.push(next);
                    }
                }

            }
            max = Math.max(max, stack.size());
        }else{
            max = stack.size();
        }

        System.out.println(max);
    }

    public static void renew(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        // 처음이랑 같은 거 있으면 남겨둔다.
        int first = stack.pop();
        temp.push(first);

        while(!stack.isEmpty()){
            if(temp.peek() == stack.peek()){
                temp.push(stack.pop());
            }else{
                stack.clear();
            }
        }

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
}
