package jp.ac.uryukyu.ie.e195744;
import java.util.Scanner;
import java.util.Random;

class Janken{
    void startMessage(){
        System.out.println("わたしにじゃんけんで勝てるかな？");
    }

    public void endMessage(){
        System.out.println("またやりましょう！");
    }

    Player player = new Player();
    CPU cpu = new CPU();
    Judge judge = new Judge();
    Retry retry = new Retry();

    public void play(){
        while (retry.getPlay()){
            System.out.println("さいしょはグー、じゃんけん?");

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
    private int hand;

    /**入力によって出す手を決める
     * 0が入力されたならグーを1が入力されたならチョキを2が入力されたならパーを出す
     */
    public void setHand(){
        System.out.println(0 + ":グー  " + 1 + ":チョキ  " + 2 + ":パー");
        Scanner scanner = new Scanner(System.in);
        try{
            hand = scanner.nextInt();
            if(hand<0 || 2<hand){
                System.out.println("0か1か2を入力してください");
                setHand();
            }
        } catch (Exception e){
            System.out.println("0か1か2を入力してください");
            setHand();
        }
    }

    public int getHand(){
        return hand;
    }
}

/**CPUが何を出すのかを決める
 */
class CPU{
    private int hand;

    /**ランダムでCPUの出す手を決める
     * 0が出ればグー1が出ればチョキ2が出ればパー
     */
    public void setHand(){
        Random rand = new Random();
        hand = rand.nextInt(3);
    }

    public int getHand(){
        return hand;
    }
}

/**
 * 勝敗を判断して勝ちとあいこと負けの数を数える
 */
class Judge {
    private int judge;
    private int win = 0;
    private int lose = 0;
    private int draw = 0;
    private String[] handList = {"グー", "チョキ", "パー"};

    /**
     * 勝ち、負け、あいこを判断する
     *
     * @param cpuHand    CPUが何を出したのか
     * @param playerHand Playerが何を出したのか
     */
    public void judgement(int cpuHand, int playerHand) {
        judge = cpuHand - playerHand + 3;
        switch (judge % 3) {
            case 0:
                System.out.println("あなた:" + handList[playerHand] + "   CPU:" + handList[cpuHand]);
                System.out.println("あいこでした");
                draw++;
                break;
            case 1:
                System.out.println("あなた:" + handList[playerHand] + "   CPU:" + handList[cpuHand]);
                System.out.println("あなたの勝ちです！");
                win++;
                break;
            case 2:
                System.out.println("あなた:" + handList[playerHand] + "   CPU:" + handList[cpuHand]);
                System.out.println("あなたの負けです！");
                lose++;
                break;
            default:
        }
    }

    public int getWin(){return win;}

    public int getLose(){return lose;}

    public int getDraw(){return draw;}

    /**
     * Playerの勝敗の数を出力する
     */
    public void result() {
        System.out.println("＊＊＊あなたの勝敗＊＊＊");
        System.out.println("勝ち：" + win + "回");
        System.out.println("あいこ" + draw + "回");
        System.out.println("負け" + lose + "回");
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊");
    }
}

/**もう一度プレイするか質問する
 * もう一度プレイするには1を入力し、終了するには0を入力する
 */
class Retry{
    private boolean play = true;
    private int re;

    public boolean getPlay(){return play;}

    public void retry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("もう一度続けるには「１」を終了するには「０」を押してください");
        try {
            re = scanner.nextInt();
            if (re<0 || 1<re){
                System.out.println("0か1を入力してください");
                retry();
            }
        } catch (Exception e){
            System.out.println("0か1を入力してください");
            retry();
        }
        switch (re){
            case 1:
                System.out.println("もう一度勝負しましょう");
                break;
            case 0:
                System.out.println("ありがとうございました！");
                play = false;
                break;
            default:
        }

    }
}

public class Main{
    public static void main(String[] args){
        Janken janken = new Janken();
        janken.startMessage();
        janken.play();
        janken.endMessage();
    }
}