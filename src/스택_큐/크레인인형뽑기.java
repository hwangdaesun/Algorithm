package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 크레인인형뽑기 {

    public static Stack<Integer> stack = new Stack<>();
    public static int ans = 0;

    public static void main(String arsg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int [][] arr = new int[n][n];
        List<Stack<Integer>> stacks = new ArrayList<>();

        for(int i=0; i<n; i++){
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            arr[i] = array;
        }

        for (int j=0; j<n; j++) {
            Stack<Integer> stack1 = new Stack<>();
            stack1.clear();
            for (int i = n-1;  i>=0  ; i--) {
                if (arr[i][j] != 0) {
                    stack1.push(arr[i][j]);
                }
            }
            stacks.add(stack1);
        }

        Integer m = Integer.valueOf(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for(int i=0; i<m; i++){
            if(!stacks.get(input[i]-1).isEmpty()){
                Integer pop = stacks.get(input[i] - 1).pop();
                bottle(pop);
            }
        }

        System.out.println(ans * 2);

    }

    public static void bottle(int e){
        if(stack.isEmpty()){
            stack.push(e);
        }else{
            if(stack.peek() == e){
                stack.pop();
                ans++;
            }else{
                stack.push(e);
            }
        }
    }

}
