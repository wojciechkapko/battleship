import java.util.List;

public class GameCvC {
    Player player1;
    Player player2;
    // int gameDifficulty;
    List<Ship> player1Ships;
    List<Ship> player2Ships;

    GameCvC(){
        // this.gameDifficulty = gameDifficulty;
        player1 = new AiPlayer();
        player2 = new AiPlayer();
        player1Ships = player1.getOcean().getShips();
        player2Ships = player2.getOcean().getShips();
    }
    public void play(){
        player1.setOpponentOcean(player2.getPlayerBoard());
        player2.setOpponentOcean(player1.getPlayerBoard());
        boolean player1Won = false;
        boolean player2Won = false;

        while(!(player1Won || player2Won)){
            System.out.println("Game started\n");
            player1.getOcean().printBoard();
            player2.getOcean().printBoard();
            player1Won = TurnLogic.playTurn(player1, player2Ships);
            player2Won = TurnLogic.playTurn(player2, player1Ships);
        }

        if(player1Won){
            System.out.println("Player1 won!");
        } else {
            System.out.println("Player2 won!");
        }
    }
}