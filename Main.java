public class Main{
    public static void main(String[] args){
        
        HumanPlayer humanPlayer = new HumanPlayer();
        AiPlayer aiPlayer = new AiPlayer();
        // humanPlayer.getOcean().printBoard();
        // aiPlayer.getOcean().printBoard();
        humanPlayer.setOpponentOcean(aiPlayer.getOpponentBoard());
        aiPlayer.setOpponentOcean(humanPlayer.getOpponentBoard());
        
        System.out.println("test");
        humanPlayer.getOcean().printBoard();
        humanPlayer.printOpponentBoard();
        humanPlayer.playerAttack();
        aiPlayer.getOcean().printBoard();
        humanPlayer.printOpponentBoard();
        humanPlayer.playerAttack();
        aiPlayer.getOcean().printBoard();
        humanPlayer.printOpponentBoard();
    }
}