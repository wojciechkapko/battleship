public class GamePvP{
    HumanPlayer humanPlayer1;
    HumanPlayer humanPlayer2;
    GamePvP(){
        humanPlayer1 = new HumanPlayer();
        humanPlayer2 = new HumanPlayer();
    }
    humanPlayer.setOpponentOcean(aiPlayer.getPlayerBoard());
    aiPlayer.setOpponentOcean(humanPlayer.getPlayerBoard());
}