import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Player{
    protected Ocean opponentOcean;
    protected Ocean ocean;

    public Player(){
        opponentOcean = new Ocean();
        ocean = new Ocean();
        ocean.isPlayerBoard = true;
    }

    public Ocean getOcean(){
        return ocean;
    }

    public Ocean getOpponentOcean(){
        return opponentOcean;
    }

    public void setOpponentOcean(Ocean opponentOcean){
        this.opponentOcean = opponentOcean;
        opponentOcean.isPlayerBoard = false;
    }

    public void attack(int x, int y){
        Square cell = opponentOcean.getBoard()[x][y];
        if (cell.getCellStatus().equals("shippart")){
            cell.setCellStatus("hit");
        }
        else{
            cell.setCellStatus("miss");
        }
    }
}