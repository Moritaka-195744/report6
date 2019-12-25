package jp.ac.uryukyu.ie.e195744;
import java.util.Scanner;
import java.util.Random;

class Janken{
    int gu = 0;
    int choki = 1;
    int pa = 2;
    boolean retry = true;

    void startMessage(){
        System.out.println("わたしにじゃんけんで勝てるかな？");
    }

    void endMessage(){
        System.out.println("またやりましょう！");
    }
}

/**
 * 勝敗を判断して勝ちと負けの数を数える
 */
class Judge {
    int judge;
    int win = 0;
    int lose = 0;

    /**勝ち、負け、あいこを判断する
     *
     * @param cpuHand CPUが何を出したのか
     * @param playerHand Playerが何を出したのか
     */
    void judgement(int cpuHand, int playerHand) {
        judge = cpuHand - playerHand + 3;
        switch (judge % 3) {
            case 0:
                System.out.println("あ〜いこで");
                break;
            case 1:
                System.out.println("あなたの勝ちです！");
                win++;
                break;
            case 2:
                System.out.println("あなたの負けです！");
                lose++;
                break;
        }
    }
}
public class Main{
}
