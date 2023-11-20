import java.util.ArrayList;
// import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

abstract class Square {
    String name;

    public Square(String name) {
        this.name = name;
    }

   

}

class Player extends Square {
    int money;
    int position;

    public Player(String name, int money) {
        super(name);
        this.money = money;
        this.position = 0; // Starting position
    }

    public void addMoney(int amount){
        money += amount;
    }

    public void subtractMoney(int cost) {
        money -= cost;
    }


   
}


class GameBoard extends Square {
    int cost;
    Player owner;
    boolean isChanceCard;

    public GameBoard(String name, int cost, boolean isChanceCard) {
        super(name);
        this.cost = cost;
        this.owner = null;
        this.isChanceCard = isChanceCard;
    }

    public void purchase(Player player) {
        if (owner == null) {
            Scanner scanner = new Scanner(System.in);
            // Field is not owned, player can purchase
            System.out.println("Cost to buy: $" + cost);
            System.out.print("Do you want to buy? Press y to purchase. If not, press anything else: ");
            
            


            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                if (player.money >= cost) {
                    player.subtractMoney(cost);
                    owner = player; // Set the owner of the field
                    System.out.println("Field purchased!");
                } else {
                    System.out.println("Not enough money to buy the field.");
                }
            }
        } else if (player == owner) {
            // Field is already owned, player needs to pay rent
            System.out.println("This field is owned by yourself. You can not buy this field");
            player.subtractMoney(cost);
            owner.addMoney(cost);
        } 
        
    
        
        else {
            System.out.println("This field is owned by " + owner.name + ". Paying rent: $" + cost);
            player.subtractMoney(cost);
            owner.addMoney(cost);
        }
        
    } 
}


class ChanceCard {
    String description;
    int effectId;

    public ChanceCard(String description, int effectId) {
        this.description = description;
        this.effectId = effectId;
    }
}
public abstract class MonopolyGame {
    static ArrayList<ChanceCard> chanceCards = new ArrayList<>();

    public static char[] createBoard(ArrayList<GameBoard> fields ){
        char[] gameBoard = new char[fields.size()];
        
        for (int i = 0; i < fields.size(); i++){
            gameBoard[i] = ' ';
            gameBoard[0] = 'X';
            
        }
        return gameBoard;
    }


    public static boolean mover(char[] gameBoard){
    

        for (int i = 0 ; i < gameBoard.length ; i++){
            
            if (gameBoard[i] == 'X'){
                if (i < gameBoard.length - 1 && gameBoard[i + 1]  == ' '){
                    gameBoard[i + 1] = 'X';
                    gameBoard[i] = ' ';
                    return true;
                } else if ( i == gameBoard.length - 1){
                    gameBoard[0] = 'X';
                    gameBoard[i] = ' ';
                    return true;
                }
            }
            
        }
        return false;
    
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


      
        int numOfPlayers;

        while (true) {
            try {
            System.out.println("Enter number of players (2-4): ");
            numOfPlayers = scanner.nextInt();

            if (numOfPlayers >= 2 && numOfPlayers <= 4) {
                break;
            } else {
                System.out.println("Invalid number of player! Try again! ");
            } 
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer. Try again! ");
            scanner.nextLine();
            }
        }

        Player[] Playere = new Player[numOfPlayers];
        scanner.nextLine();

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter the name of the player " + (i + 1) + ": ");
            String navn = scanner.nextLine();
            Playere[i] = new Player(navn, 20);
        }

        scanner.nextLine();
        System.out.println("Welcome to Monopoly Jr. We will make a quick introduction on how the game works, and how you play it. ");
        System.out.println("There are 24 fields in the gameboard and 4 of them are chancecards. There are 15 different chancecards which will randomly be chosen. It can either be a good thing or a bad thing :) ");
        System.out.println("When its your turn, you roll with the dice and land on the field that the value of your diceroll is. You get a description on how much the field cost and if you want to buy the field you simply press 'y' and if you don't want to buy the field you press any other character on your keyboard. ");
        System.out.println("It is not possible to sell a field you bought. So choose carefully what field you want to buy :) ");
        System.out.println("If you have bought a field then if any other player accidently land on that field, they have to pay the same amount you bought the field for as a rent.");
        System.out.println("The game ends when one of you don't have any more money.");
        System.out.println("Enjoy the game! :)");
        scanner.nextLine();

        // Initialize GameBoards
        ArrayList<GameBoard> fields = new ArrayList<>();
        fields.add(new GameBoard("Start", 2, false)); 
        fields.add(new GameBoard("Odense football club", 1, false)); // Adjust costs as needed
        fields.add(new GameBoard("Aarhus football club", 1, false));
        fields.add(new GameBoard("Chance", 0, true));
        fields.add(new GameBoard("Toulouse", 1, false));
        fields.add(new GameBoard("Lyon", 1, false));
        fields.add(new GameBoard("Summer vacation: ", 0, false)); //hjørnekort????
        fields.add(new GameBoard("Wolfsburg", 2, false));
        fields.add(new GameBoard("Frankfurt", 2, false));
        fields.add(new GameBoard("Chance", 0, true));
        fields.add(new GameBoard("Brøndby", 2, false));
        fields.add(new GameBoard("Football club Copenhagen", 2, false));
        fields.add(new GameBoard("Christmas vacation", 0, false)); //Hjørnekort????
        fields.add(new GameBoard("Manchester United", 3, false));
        fields.add(new GameBoard("Chealsea", 3, false));
        fields.add(new GameBoard("Chance", 0, true));
        fields.add(new GameBoard("AC Milan", 3, false));
        fields.add(new GameBoard("Juventus", 3, false));
        fields.add(new GameBoard("Winter vacation", 0, false)); //Hjørnekort????
        fields.add(new GameBoard("Tottenham", 4, false));
        fields.add(new GameBoard("Arsenal", 4, false));
        fields.add(new GameBoard("Chance", 0, true));
        fields.add(new GameBoard("Bayern Munchen", 5, false));
        fields.add(new GameBoard("Real Madrid", 5, false));

    

        ArrayList<ChanceCard> chanceCards = new ArrayList<>();
        chanceCards.add(new ChanceCard("Advance to the start and earn your money: DKK 2", 1));
        chanceCards.add(new ChanceCard("Advance 5 spaces!", 2));
        chanceCards.add(new ChanceCard("You are late for training pay 2 to the manager", 3));
        chanceCards.add(new ChanceCard("You score a hat trick and everyone gives you 1 money", 4));
        chanceCards.add(new ChanceCard("You get a reward for coming to all the trainings and receive 2 money", 5));
        chanceCards.add(new ChanceCard("Advance to Frankfurt", 6)); // move to specific place on the board (dont know where yet)
        chanceCards.add(new ChanceCard("Advance to Chealsea", 7)); // move to specific place on the board (dont know where yet)
        chanceCards.add(new ChanceCard("Your fans hate you and smash your car. You must pay 1 money to repair it", 8));
        chanceCards.add(new ChanceCard("You renovate a grandstand at your stadium and must pay 2", 9));
        chanceCards.add(new ChanceCard("Your clubhouse is assessed at a higher value than before. Pay 1 in property tax", 10));
        chanceCards.add(new ChanceCard("An oil sheik from Saudi Arabia will sponsor your team. Receive 3", 11));
        chanceCards.add(new ChanceCard("You go on a skiing holiday, even though you are not allowed according to your contract, and get injured. Pay 1 to the manager", 12));
        chanceCards.add(new ChanceCard("You eat too much McDonald's during the summer holidays and are not ready to fight. Pay 1 to the manager", 13));
        chanceCards.add(new ChanceCard("You have played well in the youth team and will make your debut in the first team. Receive 2", 14));
        chanceCards.add(new ChanceCard("Both your parents are kidnapped by terrorists. Pay 2 in ransom.", 15));

        char[] gameBoard = createBoard(fields);

        int turn = 1;
        while (true) {
            System.out.println("\nTurn " + turn++);

            for (Player player : Playere) {
                System.out.println("\n" + player.name + "'s turn");
                scanner.nextLine();
                System.out.println("Current position: " + player.position);
                System.out.println("Money: $" + player.money);

                // Simulate dice roll
                int diceRoll = (int) (Math.random() * 6) + 1;
                System.out.println("Dice roll: " + diceRoll);

                // Move player
                player.position = (player.position + diceRoll) % fields.size();


                // Process field
                GameBoard currentField = fields.get(player.position);
                System.out.println("Landed on: " + currentField.name);

                System.out.println(Arrays.toString(gameBoard));


                if (currentField.isChanceCard) {
                    int CardIndex = (int) (Math.random() * chanceCards.size());
                    ChanceCard drawnCard = chanceCards.get(CardIndex);
                    System.out.println("Chance card: " + drawnCard.description);
                    applyChanceCardEffect(drawnCard, player, Playere, fields);
                } else {
                currentField.purchase(player);
                }
                

                for (int i = 0 ; i < numOfPlayers ; i++){
                    if (mover(gameBoard)){
                        // Det kan være det er her vi kan skrive noget kode som bevæger X'et ud fra player position?
                        // Hvis man fjerner det her snippet så rykker X'et ikke
                    } else {
                        System.out.println("Place occupied");
                    }
                }

                // Check if the game should end
                if (player.money <= 0 || player.money >= 50) {
                    System.out.println(player.name + " has reached the end condition. Game over!");
                    System.exit(0);
                }
            }
        }
        }

    
            public static void applyChanceCardEffect(ChanceCard card, Player currentPlayer, Player[] allPlayers, ArrayList<GameBoard> fields) {
                switch (card.effectId) {
                    case 1:
                        currentPlayer.position = 0;
                        currentPlayer.addMoney(2);
                        break;
                        case 2:
                        currentPlayer.position = (currentPlayer.position + 5) % fields.size(); // Advance 5 spaces
                        break;
                    case 3:
                        currentPlayer.subtractMoney(2); // Pay 2 to the manager
                        break;
                    case 4:
                        for (Player player : allPlayers) {
                            if (player != currentPlayer) {
                                player.subtractMoney(1); // Each player gives 1 money
                                currentPlayer.addMoney(1); // Current player receives the money
                            }
                        }
                        break;
                    case 5:
                        currentPlayer.addMoney(2); // Receive 2 money for training
                        break;
                    case 6:
                        currentPlayer.position = 9; // move to specific place on the board (dont know where yet)
                        
                        break;
                    case 7:
                        currentPlayer.position =15; // move to specific place on the board (dont know where yet)
                        break;
                    case 8:
                        currentPlayer.subtractMoney(1); // Pay 1 money for car repair
                        break;
                    case 9:
                        currentPlayer.subtractMoney(2); // Pay 2 for renovating a grandstand
                        break;
                    case 10:
                        currentPlayer.subtractMoney(1); // Pay 1 in property tax
                        break;
                    case 11:
                        currentPlayer.addMoney(3); // Receive 3 from an oil sheik sponsor
                        break;
                    case 12:
                        currentPlayer.subtractMoney(1); // Pay 1 for ski holiday injury
                        break;
                    case 13:
                        currentPlayer.subtractMoney(1); // Pay 1 for eating too much McDonald's
                        break;
                    case 14:
                        currentPlayer.addMoney(2); // Receive 2 for playing well in the youth team
                        break;
                    case 15:
                        currentPlayer.subtractMoney(2); // Pay 2 ransom for kidnapped parents
                        break;
        }
    }
    
}





