import java.util.ArrayList;

public class Ocean {
    int boardLimit = 10;
    Square[][] board;
    ArrayList<Ship> ships;

    Ocean(){
        ships = new ArrayList<Ship>();
        board = new Square[boardLimit][boardLimit];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int x = 0; x < boardLimit; x++){
            for(int y = 0; y < boardLimit; y++){
                board[x][y] = new Square();
            }
        }
    }

    public void addShip(int[] coordinates, int length, boolean isHorizontal){
        Square[] shipElements = new Square[length];
        int x = coordinates[0];
        int y = coordinates[1];
        if(isHorizontal){
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x][y+i];
            }
        }
        else {
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x+i][y];
            }
        }
        Ship ship = new Ship(shipElements);
        ships.add(ship);
    }


    public void printBoard(){
        printYAxis();
        for(int x = 0; x < boardLimit; x++){
            printXAxis(x);
            for(int y = 0; y < boardLimit; y++){
                Square boardSquare = board[x][y];
                System.out.print(boardSquare);
            }
            System.out.print("\n");
        }
        System.out.println("");
        System.out.println("x");
        System.out.println("");
    }

    private void printXAxis(int x){
        if (x + 1 == 10)
            System.out.print(x+1 + " ");
        else 
            System.out.print(x+1 + "  ");
    }

    private void printYAxis(){
        System.out.println("  " + "  1  2  3  4  5  6  7  8  9  10  " + "y");
        System.out.println("");
    }
}