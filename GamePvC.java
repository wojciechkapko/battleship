public class GamePvC{
    HumanPlayer humanPlayer;
    AiPlayer aiPlayer;
    int gameDifficulty;
    GamePvC(int gameDifficulty){
        this.gameDifficulty = gameDifficulty;
        aiPlayer = new AiPlayer();
        humanPlayer = new HumanPlayer();
    }
    public void play(){
        humanPlayer.setOpponentOcean(aiPlayer.getPlayerBoard());
        aiPlayer.setOpponentOcean(humanPlayer.getPlayerBoard());
        boolean isGameWon = false;
        while(true){
            if(isGameWon){
                break;
            }
            isGameWon = Turn();
            isGameWon = Turn();
        }
    }
    private boolean Turn(){
        
    }


}