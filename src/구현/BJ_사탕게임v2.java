package 구현;

import java.io.*;
public class BJ_사탕게임v2 {

    static char game[][];
    static int MAX = 0;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        game = new char[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                game[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<game.length; i++){
            for(int j=0; j<game[i].length; j++){
                swapRL(i,j,n);
                swapUD(i,j,n);
            }
        }
        System.out.println(MAX);
    }

    public static void swapRL(int i, int j, int n){
        int ii = i+1;
        int jj = j;
        if(ii >=0 && ii < n && jj >=0 && jj <n){
            char temp = game[i][j];
            game[i][j] = game[ii][jj];
            game[ii][jj] = temp;

            countR(n);
            countC(n);

            char temp1 = game[ii][jj];
            game[ii][jj] = game[i][j];
            game[i][j] = temp1;
        }
    }

    public static void swapUD(int i, int j, int n){
        int ii = i;
        int jj = j + 1;
        if(ii >=0 && ii < n && jj >=0 && jj <n){
            char temp = game[i][j];
            game[i][j] = game[ii][jj];
            game[ii][jj] = temp;

            countR(n);
            countC(n);

            char temp1 = game[ii][jj];
            game[ii][jj] = game[i][j];
            game[i][j] = temp1;
        }
    }

    public static void print(){
        for(int i=0; i<game.length; i++){
            for(int j=0; j<game[i].length; j++){
                System.out.print(game[i][j]);
            }
            System.out.println();
        }
    }

    public static void countR(int n){
        int max = 0;
        for(int i=0; i<n; i++){
            int count = 1;
            char first = game[i][0];
            for(int j=1; j<n; j++){
                if(first == game[i][j]){
                    count++;
                }else{
                    first = game[i][j];
                    max = (max > count) ? max : count;
                    count = 1;
                }
            }
            max = (max > count) ? max : count;
        }
        MAX = (MAX > max) ? MAX : max;
    }

    public static void countC(int n){
        int max = 0;
        for(int i=0; i<n; i++){
            int count = 1;
            char first = game[0][i];
            for(int j=1; j<n; j++){
                if(first == game[j][i]){
                    count++;
                }else{
                    first = game[j][i];
                    max = (max > count) ? max : count;
                    count = 1;
                }
            }
            max = (max > count) ? max : count;
        }
        MAX = (MAX > max) ? MAX : max;
    }


}
