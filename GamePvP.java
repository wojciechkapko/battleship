import java.util.List;

public class GamePvP {
    Player player1;
    Player player2;
    // int gameDifficulty;
    List<Ship> player1Ships;
    List<Ship> player2Ships;

    GamePvP(){
        // this.gameDifficulty = gameDifficulty;
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
        player1Ships = player1.getOcean().getShips();
        player2Ships = player2.getOcean().getShips();
    }
    public void play(){
        player1.setOpponentOcean(player2.getPlayerBoard());
        player2.setOpponentOcean(player1.getPlayerBoard());
        boolean player1Won = false;
        boolean player2Won = false;
        System.out.println("Look out! Battle commences!\n\n");
        while(!(player1Won || player2Won)){
            System.out.println("Pirate1 turn:\n");
            player1.getOcean().printBoard();
            player1.printOpponentBoard();
            player1Won = TurnLogic.playTurn(player1, player2Ships);
            System.out.println("Pirate2 turn:\n");
            player2.getOcean().printBoard();
            player2.printOpponentBoard();
            player2Won = TurnLogic.playTurn(player2, player1Ships);
        }

        if(player1Won){
            System.out.println("Pirate1 won!");
        } else {
            System.out.println("Pirate2 won!");
        }
    }
}