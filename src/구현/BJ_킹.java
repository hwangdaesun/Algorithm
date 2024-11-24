package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_킹 {
    public static final int KING  = 2;
    public static final int DOL  = 1;
    public static int currentRKING = 0;
    public static int currentCKING = 0;
    public static int currentRDOL = 0;
    public static int currentCDOL = 0;

    public static List<String> c = List.of("A", "B", "C", "D", "E", "F", "G", "H");

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String kingPos = st.nextToken();
        String dolPos = st.nextToken();
        Integer n = Integer.valueOf(st.nextToken());

        int[][] chessPan = new int[9][9];
        init(kingPos, dolPos, chessPan);

        for(int i=0; i<n; i++){
            String moving = br.readLine();
            switch (moving){
                case "R":
                    move(0,1, chessPan);
                    break;
                case "L":
                    move(0,- 1, chessPan);
                    break;
                case "B":
                    move(-1, 0, chessPan);
                    break;
                case "T":
                    move(1, 0, chessPan);
                    break;
                case "RT":
                    move(1, 1, chessPan);
                    break;
                case "LT":
                    move(1, -1, chessPan);
                    break;
                case "RB":
                    move(-1, 1, chessPan);
                    break;
                case "LB":
                    move(-1, -1, chessPan);
                    break;
            }
        }



        String cK = c.get(currentCKING-1);
        String rK = String.valueOf(currentRKING);
        System.out.println(cK.concat(rK));

        String cD = c.get(currentCDOL-1);
        String rD = String.valueOf(currentRDOL);
        System.out.println(cD.concat(rD));



    }

    public static void init(String kingPos, String dolPos, int[][] chessPan){
        String kingC = kingPos.substring(0,1);
        String kingR = kingPos.substring(1);

        int kingCIdx = c.indexOf(kingC) + 1;
        chessPan[Integer.valueOf(kingR)][kingCIdx] = KING;
        currentRKING = Integer.valueOf(kingR);
        currentCKING = kingCIdx;

        String dolC = dolPos.substring(0,1);
        String dolR = dolPos.substring(1);

        int dolCIdx = c.indexOf(dolC) + 1;
        chessPan[Integer.valueOf(dolR)][dolCIdx] = DOL;
        currentRDOL = Integer.valueOf(dolR);
        currentCDOL = dolCIdx;
    }

    public static void move(int r, int c, int[][] chessPan){
        int rPos = currentRKING + r;
        int cPos = currentCKING + c;
        int dRPos = currentRDOL + r;
        int dCPos = currentCDOL + c;
        boolean flag = false;
        if(rPos == currentRDOL && cPos == currentCDOL){
            flag = true;
        }

        if(flag){
            if(rPos > 0 && rPos < 9 && cPos > 0 && cPos < 9 && dRPos > 0 && dRPos < 9 && dCPos > 0 && dCPos < 9){
                chessPan[currentRKING][currentCKING] = 0;
                chessPan[currentRDOL][currentCDOL] = 0;
                chessPan[rPos][cPos] = KING;
                chessPan[dRPos][dCPos] = DOL;
                currentRKING = rPos;
                currentCKING = cPos;
                currentRDOL = dRPos;
                currentCDOL = dCPos;
            }
        }else{
            if(rPos > 0 && rPos < 9 && cPos > 0 && cPos < 9){
                chessPan[currentRKING][currentCKING] = 0;
                chessPan[rPos][cPos] = KING;
                currentRKING = rPos;
                currentCKING = cPos;
            }
        }
    }
}
