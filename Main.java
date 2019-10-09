public class Main{
    public static void main(String[] args){
        
        var humanPlayer = new HumanPlayer();
        var aiPlayer = new AiPlayer();
        // humanPlayer.getOcean().printBoard();
        // aiPlayer.getOcean().printBoard();
        humanPlayer.setOpponentOcean(aiPlayer.getOcean());
        aiPlayer.setOpponentOcean(humanPlayer.getOcean());
        
        System.out.println("test");
        humanPlayer.getOcean().printBoard();
        humanPlayer.getOpponentOcean().printBoard();
    }
}