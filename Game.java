public class Game{
    int gameType;
    int gameDifficulty;
    HumanPlayer humanPlayer = new HumanPlayer();
    AiPlayer aiPlayer = new AiPlayer();
    Game(int gameType){
        this.gameType = gameType;
        switch(this.gameType){
            case 1:
                humanPlayer = new HumanPlayer();
                aiPlayer = new AiPlayer();
                break;
            case 2:
                humanPlayer1 = new HumanPlayer();
                humanPlayer2 = new HumanPlayer();
                break;
            case 3:
                aiPlayer1 = new AiPlayer();
                aiPlayer2 = new AiPlayer();
                break;
        }
       
    }
    // humanPlayer.getOcean().printBoard();
    // aiPlayer.getOcean().printBoard();
    humanPlayer.setOpponentOcean(aiPlayer.getPlayerBoard());
    aiPlayer.setOpponentOcean(humanPlayer.getPlayerBoard());
    
    System.out.println("test");
    humanPlayer.getOcean().printBoard();
    humanPlayer.printOpponentBoard();
    humanPlayer.playerAttack(aiPlayer.getOcean().getShips());
    aiPlayer.getOcean().printBoard();
    humanPlayer.printOpponentBoard();
    humanPlayer.playerAttack(aiPlayer.getOcean().getShips());
    aiPlayer.getOcean().printBoard();
    humanPlayer.printOpponentBoard();
}