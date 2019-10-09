import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Player{
    protected Ocean opponentOcean;
    protected Ocean ocean;

    public Player(){
        opponentOcean = new Ocean();
        ocean = new Ocean();
    }

    public Ocean getOcean(){
        return ocean;
    }

    public void setOpponentOcean(Ocean opponentOcean){
        this.opponentOcean = opponentOcean;
    }
}