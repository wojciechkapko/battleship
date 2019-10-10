import java.util.Scanner;

public class Main{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        menu();
    }

    private static void menu(){
        String input = "";
        while (!(input.equals("0"))){
            System.out.println("Ahoy!");
            System.out.println("1. Game: Pirate vs. Computer");
            System.out.println("2. Game: Pirate vs. Pirate");
            System.out.println("3. Game: Computer vs. Computer");
            System.out.println("\nPress 0 to disembark, landlubber!");
            
            input = scan.next();

            switch (input){
                case "0":
                   break;
                case "1":
                    GamePvC newGamePvC = new GamePvC();
                    newGamePvC.play();
                    break;
                case "2":
                    GamePvP newGamePvP = new GamePvP();
                    newGamePvP.play();
                    break;
                case "3":
                    GameCvC newGameCvC = new GameCvC();
                    newGameCvC.play();
                    break;
                default:
                System.out.println("Blimey! I dont understand, Did ye have too much rum?");

            }
        }
    }
}