import java.util.ArrayList;
import java.util.List;

public class Ocean {
    private int boardLimit = 10;
    Square[][] board;
    ArrayList<Ship> ships;
    List<Square> unavailableCells;

    Ocean(){
        ships = new ArrayList<Ship>();
        board = new Square[boardLimit][boardLimit];
        unavailableCells = new ArrayList<>();
        initializeBoard();
    }

    public Square[][] getBoard(){
        return board;
    }

    public ArrayList<Ship> getShips(){
        return ships;
    }

    private void initializeBoard(){
        for(int x = 0; x < boardLimit; x++){
            for(int y = 0; y < boardLimit; y++){
                board[x][y] = new Square(x, y);
            }
        }
    }

    public boolean addShip(int[] coordinates, int length, boolean isHorizontal, String name){
        Square[] shipElements = new Square[length];
        int x = coordinates[0];
        int y = coordinates[1];

        if(!validateSpawnPoint(x, y))
            return false;

        if(!isSpaceAvailable(isHorizontal, x, y, length))
            return false;

        if(isHorizontal)
            createHorizontalShip(x, y, length, shipElements);
        else
            createVerticalShip(x, y, length, shipElements);
        Ship ship = new Ship(shipElements, name);

        updateUnavailableCells(shipElements);
        ships.add(ship);
        return true;
    }

    private void updateUnavailableCells(Square[] shipElements){
        for(Square cell: shipElements){
            int x = cell.getX();
            int y = cell.getY();
            unavailableCells.add(cell);
            if(0 <= x-1)
                unavailableCells.add(board[x-1][y]);

            if(board.length > x + 1)
                unavailableCells.add(board[x+1][y]);

            if(0 <= y-1)
                unavailableCells.add(board[x][y-1]);

            if(board[x].length > y + 1)
                unavailableCells.add(board[x][y+1]);
        }
    }

    private void createHorizontalShip(int x, int y, int length, Square[] shipElements) {
        try{
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x][y+i];
            }
        } catch(ArrayIndexOutOfBoundsException e){
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x][y-i];
            }
        }
    }

    private void createVerticalShip(int x, int y, int length, Square[] shipElements) {
        try{
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x+i][y];
            }
        } catch(ArrayIndexOutOfBoundsException e){
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x-i][y];
            }
        }
    }

    private boolean validateSpawnPoint(int x, int y) {
        if(board[x][y].getIsShipPart()){
            return false;
        }
        if(board.length > x + 1 && 0 <= x-1){
            if(board[x-1][y].getIsShipPart() || board[x+1][y].getIsShipPart()){
                return false;
            } 
        }
        if(board[x].length > y + 1 && 0 <= y-1){
            if(board[x][y-1].getIsShipPart() || board[x][y+1].getIsShipPart()){
                return false;
            }
        }
        return true;
    }

    private boolean isSpaceAvailable(boolean orientation, int x, int y, int size) {
        if(orientation){
            for (int i = 0; i < size; i++) {
                // if(board[x].length > y + size && 0 <= y-size)
                if(board[x].length > y + size){
                    if(unavailableCells.contains(board[x][y+i])){
                        return false;
                    }
                } else {
                    if(unavailableCells.contains(board[x][y-i])){
                        return false;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                // if(board.length > x + size && 0 <= x-size)
                if(board.length > x + size){
                    if(unavailableCells.contains(board[x+i][y])){
                        return false;
                    }
                } else {
                    if(unavailableCells.contains(board[x-i][y])){
                        return false;
                    }
                }
            }
        }
        return true;
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

    public void printXAxis(int x){
        if (x + 1 == 10)
            System.out.print(x+1 + " | ");
        else 
            System.out.print(x+1 + "  | ");
    }

    public void printYAxis(){
        System.out.println("  " + "    1  2  3  4  5  6  7  8  9  10  " + "y");
        System.out.println("-----------------------------------");
    }

    public int getBoardLimit(){
        return boardLimit;
    }
}