public class Main{
    public static void main(String[] args){
        
        var humanPlayer = new HumanPlayer();
        var aiPlayer = new AiPlayer();
        // humanPlayer.getOcean().printBoard();
        // aiPlayer.getOcean().printBoard();
        humanPlayer.setOpponentOcean(aiPlayer.getOpponentBoard());
        aiPlayer.setOpponentOcean(humanPlayer.getOpponentBoard());
        
        System.out.println("test");
        humanPlayer.getOcean().printBoard();
        humanPlayer.printOpponentBoard();
    }
}