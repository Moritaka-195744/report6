package jp.ac.uryukyu.ie.e195744;
import java.util.Scanner;
import java.util.Random;

class Janken{
    void startMessage(){
        System.out.println("わたしにじゃんけんで勝てるかな？");
    }

    void endMessage(){
        System.out.println("またやりましょう！");
    }

    Janken(){
        Player player = new Player();
        CPU cpu = new CPU();
        Judge judge = new Judge();
        Retry retry = new Retry();

        while (retry.play){
            System.out.println("さいしょはグー、じゃんけんぽん");

            cpu.setHand();
            player.setHand();
            judge.judgement(cpu.getHand(),player.getHand());
            judge.result();
            retry.retry();
        }
    }
}

/**プレイヤーが何を出すのかを決める
 */
class Player{
    int hand;

    /**入力によって出す手を決める
     * 0が入力されたならグーを1が入力されたならチョキを2が入力されたならパーを出す
     */
    void setHand(){
        System.out.println(0 + ":グー" + 1 + ":チョキ" + 2 + ":パー");
        Scanner scanner = new Scanner(System.in);
        hand = scanner.nextInt();
    }

    int getHand(){
        return hand;
    }
}

/**CPUが何を出すのかを決める
 */
class CPU{
    int hand;

    /**ランダムでCPUの出す手を決める
     * 0が出ればグー1が出ればチョキ2が出ればパー
     */
    void setHand(){
        Random rand = new Random();
        hand = rand.nextInt(3);
    }

    int getHand(){
        return hand;
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
            default:
        }
    }

    /**Playerの勝敗の数を出力する
     */
    void result(){
        System.out.println("＊＊＊あなたの勝敗＊＊＊");
        System.out.println("勝ち：" + win + "回");
        System.out.println("勝ち" + lose + "回");
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊");
    }
}

/**もう一度プレイするか質問する
 * もう一度プレイするには1を入力し、終了するには0を入力する
 */
class Retry{
    boolean play = true;
    void retry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("もう一度続けるには「１」を終了するには「０」を押してください");
        int re = scanner.nextInt();
        switch (re){
            case 1:
                System.out.println("もう一度勝負しましょう");
            case 0:
                System.out.println("ありがとうございました！");
                play = false;
        }

    }
}

public class Main{
    public static void main(String[] args){

    }
}
