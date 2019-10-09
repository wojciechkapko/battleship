import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Player{
    protected Square[][] opponentBoard;
    protected Ocean ocean;

    public Player(){
        ocean = new Ocean();
    }

    public Square[][] getPlayerBoard(){
        return ocean.getBoard();
    }

    public Ocean getOcean(){
        return ocean;
    }

    public Square[][] getOpponentBoard(){
        return opponentBoard;
    }
    

    public void setOpponentOcean(Square[][] opponentOcean){
        this.opponentBoard = opponentOcean.clone();
    }

    public boolean attack(int x, int y){
        Square cell = opponentBoard[x][y];
        if (cell.getCellStatus().equals("shippart")){
            cell.setCellStatus("hit");
            return true;
        }
        else{
            cell.setCellStatus("miss");
            return false;
        }
    }
}