package src;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


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
    boolean isPurchasable;

    public GameBoard(String name, int cost, boolean isChanceCard, boolean isPurchasable) {
        super(name);
        this.cost = cost;
        this.owner = null;
        this.isChanceCard = isChanceCard;
        this.isPurchasable = isPurchasable;
    }

    public void purchase(Player player) {
                if (!isPurchasable) {
            System.out.println("You decide to take a deserved vacation :)");
            System.out.println("\n" + "Press enter to continue");
            return;
        }
        if (owner == null) {
            Scanner scanner = new Scanner(System.in);
            // Field is not owned, player can purchase
            System.out.println("Cost to buy: $" + cost);
            System.out.print("Do you want to buy? Press 'y' and then enter to purchase. If not, press 'n' and enter: ");
            
            


            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                if (player.money >= cost) {
                    player.subtractMoney(cost);
                    owner = player; // Set the owner of the field
                    System.out.println("\n"+ "Field purchased!");
                    System.out.println("\n"+ "Press enter to continue");
                } else {
                    System.out.println("Not enough money to buy the field.");
                    System.out.println("\n"+ "Press enter to continue");
                }
            }


            if (input.equalsIgnoreCase("n")){
                System.out.println("\n"+ "Field not purchased!");
                System.out.println("\n" + "Press enter to continue");
                scanner.nextLine();
            }
        } else if (player == owner) {
            // Field is already owned, player needs to pay rent
            System.out.println("This field is owned by yourself. You can not buy this field");
            player.subtractMoney(cost);
            owner.addMoney(cost);
            System.out.println("\n" + "Press enter to continue");
        } 
        
    
        
        else {
            System.out.println("This field is owned by " + owner.name + ". Paying rent: $" + cost);
            player.subtractMoney(cost);
            owner.addMoney(cost);
            System.out.println("\n" + "Press enter to continue");
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
            Playere[i] = new Player(navn, 20); // players start money
        }
        System.out.println("\n"+ "Press enter to continue");
        scanner.nextLine();
        System.out.println("Welcome to Monopoly Jr. We will make a quick introduction on how the game works, and how you play it.");
        System.out.println("There are 24 fields in the gameboard and 4 of them are chancecards. There are 15 different chancecards which will randomly be chosen. It can either be a good thing or a bad thing :)");
        System.out.println("When its your turn, you roll with the dice and land on the field that the value of your diceroll is. "); 
        System.out.println("You get a description on how much the field cost and if you want to buy the field you simply press 'y' and then enter. If you don't want to buy the field you press any other character on your keyboard and then enter."); 
        System.out.println("It is not possible to sell a field you bought. So choose carefully what field you want to buy :)");
        System.out.println("If you have bought a field and any other player accidentally land on that field, they have to pay the same amount you bought the field for as a rent.");
        System.out.println("Every player start with 20 money in the bank.");
        System.out.println("The game ends when one of you don't have any more money or when one of you reach 50 money.");
        System.out.println("Enjoy the game! :)");
        System.out.println("\n" + "Press enter to continue");
        scanner.nextLine();

        // Initialize GameBoards
        ArrayList<GameBoard> fields = new ArrayList<>();
        fields.add(new GameBoard("Start", 0, false, false)); 
        fields.add(new GameBoard("Odense Football Club", 1, false, true)); 
        fields.add(new GameBoard("Aarhus Football Club", 1, false, true));
        fields.add(new GameBoard("Chance", 0, true, false));
        fields.add(new GameBoard("Toulouse", 1, false, true));
        fields.add(new GameBoard("Lyon", 1, false, true));
        fields.add(new GameBoard("Summer vacation: ", 0, false, false)); //hjørnekort????
        fields.add(new GameBoard("Wolfsburg", 2, false, true));
        fields.add(new GameBoard("Frankfurt", 2, false, true));
        fields.add(new GameBoard("Chance", 0, true, false));
        fields.add(new GameBoard("Broendby", 2, false, true));
        fields.add(new GameBoard("Copenhagen Football Club", 2, false, true));
        fields.add(new GameBoard("Christmas vacation", 0, false, false)); //Hjørnekort????
        fields.add(new GameBoard("Manchester United", 3, false, true));
        fields.add(new GameBoard("Chelsea", 3, false, true));
        fields.add(new GameBoard("Chance", 0, true, false));
        fields.add(new GameBoard("AC Milan", 3, false, true));
        fields.add(new GameBoard("Juventus", 3, false, true));
        fields.add(new GameBoard("Winter vacation", 0, false, false)); //Hjørnekort????
        fields.add(new GameBoard("Tottenham", 4, false, true));
        fields.add(new GameBoard("Arsenal", 4, false, true));
        fields.add(new GameBoard("Chance", 0, true, false));
        fields.add(new GameBoard("Bayern Munchen", 5, false, true));
        fields.add(new GameBoard("Real Madrid", 5, false, true));

    

        ArrayList<ChanceCard> chanceCards = new ArrayList<>();
        chanceCards.add(new ChanceCard("Advance to the start and earn your money: 2 money", 1));
        chanceCards.add(new ChanceCard("Advance 5 spaces!", 2));
        chanceCards.add(new ChanceCard("You are late for training pay 2 money to the manager", 3));
        chanceCards.add(new ChanceCard("You score a hat trick and the other players give you 3 money each", 4));
        chanceCards.add(new ChanceCard("You get a reward for coming to all the trainings and receive 2 money", 5));
        chanceCards.add(new ChanceCard("Advance to Frankfurt", 6)); // move to specific place on the board (dont know where yet)
        chanceCards.add(new ChanceCard("Advance to Chelsea", 7)); // move to specific place on the board (dont know where yet)
        chanceCards.add(new ChanceCard("Your fans hate you and smash your car. You must pay 1n money to repair it", 8));
        chanceCards.add(new ChanceCard("You renovate a grandstand at your stadium and must pay 2 money", 9));
        chanceCards.add(new ChanceCard("Your clubhouse is assessed at a higher value than before. Pay 1 money in property tax", 10));
        chanceCards.add(new ChanceCard("An oil sheik from Saudi Arabia will sponsor your team. Receive 6 money", 11));
       
        chanceCards.add(new ChanceCard("You have played well in the youth team and will make your debut in the first team. Receive 2 money", 12));
        

        

        int turn = 1;
        while (true) {
            System.out.println("\nTurn " + turn++);

            for (Player player : Playere) {
                System.out.println("\n" + player.name + "'s turn");
                System.out.println("\n" + "Press enter to roll the dice");
                scanner.nextLine();
                System.out.println("Current position: " + player.position);
                System.out.println("Money: $" + player.money);

                // Simulate dice roll
                int diceRoll = (int) (Math.random() * 6) + 1;
                System.out.println("Dice roll: " + diceRoll);

                // Move player og checke om de passere start
                int oldposition = player.position;
                player.position = (player.position + diceRoll) % fields.size();

                if (player.position < oldposition){
                    System.out.println("You passed 'Start'! Collect 2 money!");
                    player.addMoney(2);
                }

                // Process field
                GameBoard currentField = fields.get(player.position);
                System.out.println("Landed on: " + currentField.name);
                // scanner.nextLine(); maybe?
                


                if (currentField.isChanceCard) {
                    int CardIndex = (int) (Math.random() * chanceCards.size());
                    ChanceCard drawnCard = chanceCards.get(CardIndex);
                    System.out.println("Chance card: " + drawnCard.description);
                    applyChanceCardEffect(drawnCard, player, Playere, fields);
                    System.out.println("\n" + "Press enter to continue");
                } else {
                currentField.purchase(player);
                }
                scanner.nextLine();
                // Check if the game should end
                if (player.money <= 0) {
                    System.out.println(player.name + " you have no more money to play this game any further... You have unfortunately lost the game... :-(");
                    System.out.println("Congratulations to you other players!");
                    System.exit(0);
                } else if (player.money >= 50){
                    System.out.println(player.name + " you reached the maximum amount of money! :-o You just won the game!!");
                    System.out.println("Big congratulations!");
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
                                player.subtractMoney(3); // Each player gives 1 money
                                currentPlayer.addMoney(3); // Current player receives the money
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
                        currentPlayer.addMoney(6); // Receive 3 from an oil sheik sponsor
                        break;
                    
                    case 12:
                        currentPlayer.addMoney(2); // Receive 2 for playing well in the youth team
                        break;
                    

        }
    }
    
}





