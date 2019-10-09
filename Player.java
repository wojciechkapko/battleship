import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Player{
    protected Square[][] opponentOcean;
    protected Ocean ocean;

    public Player(){
        ocean = new Ocean();
    }

    public Square[][] getOpponentBoard(){
        return ocean.getBoard();
    }

    public Ocean getOcean(){
        return ocean;
    }

    public Square[][] getOpponentOcean(){
        return opponentOcean;
    }

    public void setOpponentOcean(Square[][] opponentOcean){
        this.opponentOcean = opponentOcean.clone();
    }

    public void attack(int x, int y){
        Square cell = opponentOcean[x][y];
        if (cell.getCellStatus().equals("shippart")){
            cell.setCellStatus("hit");
        }
        else{
            cell.setCellStatus("miss");
        }
    }
}