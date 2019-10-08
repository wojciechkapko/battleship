public class Main{
    public static void main(String[] args){
        // var player1 = new Player();
        Player humanPlayer = new HumanPlayer();
        AiPlayer aiPlayer = new AiPlayer();
        humanPlayer.getOcean().printBoard();
        aiPlayer.getOcean().printBoard();
        // player1.setOpponentOcean(aiPlayer.getOcean());
        // aiPlayer.setOpponentOcean(player1.getOcean());
    }
}