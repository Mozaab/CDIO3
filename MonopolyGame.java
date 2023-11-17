import java.util.ArrayList;
// import java.util.Collections;
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
}

class GameBoard extends Square {
    int cost;

    public GameBoard(String name, int cost) {
        super(name);
        this.cost = cost;
    }

   
}

// class ChanceCard extends Square {
//     String description;

//     public ChanceCard(String name, String description) {
//         super(name);
//         this.description = description;
//     }

    // Add methods as needed for specific actions
// }

public abstract class MonopolyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
      
        int antalSpillere;

        while (true) {
            try {
            System.out.println("Enter number of players (2-4): ");
            antalSpillere = scanner.nextInt();

            if (antalSpillere >= 2 && antalSpillere <= 4) {
                break;
            } else {
                System.out.println("Invalid number of player! Try again! ");
            } 
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer. Try again! ");
            scanner.nextLine();
            }
        }

        Player[] Playere = new Player[antalSpillere];
        scanner.nextLine();

        for (int i = 0; i < antalSpillere; i++) {
            System.out.println("Enter the name of the player " + (i + 1) + ": ");
            String navn = scanner.nextLine();
            Playere[i] = new Player(navn, 20);
        }

        // Initialize GameBoards
        ArrayList<GameBoard> fields = new ArrayList<>();
        fields.add(new GameBoard("Field 1", 4)); // Adjust costs as needed
        fields.add(new GameBoard("Field 2", 2));
        fields.add(new GameBoard("Field 3", 1));
        fields.add(new GameBoard("Field 4", 3));
        fields.add(new GameBoard("Field 5", 3));
        fields.add(new GameBoard("Field 6", 2));
        fields.add(new GameBoard("Field 7", 5));
        fields.add(new GameBoard("Field 8", 1));
        fields.add(new GameBoard("Field 9", 3));
        fields.add(new GameBoard("Field 10", 3));
        fields.add(new GameBoard("Field 11", 2));
        fields.add(new GameBoard("Field 12", 5));
        fields.add(new GameBoard("Field 13", 1));

        

       
        // Add more fields if desired

        // Initialize chance cards
        // ArrayList<ChanceCard> chanceCards = new ArrayList<>();
        // chanceCards.add(new ChanceCard("Chance Card 1", "Advance to Go. Collect $200."));
        // chanceCards.add(new ChanceCard("Chance Card 2", "Pay poor tax of $15."));
        // chanceCards.add(new ChanceCard("Chance Card 3", "Pay poor tax of $15."));
        // chanceCards.add(new ChanceCard("Chance Card 4", "Pay poor tax of $15."));
        // Add more chance cards if desired

        // Shuffle chance cards
        // Collections.shuffle(chanceCards);

        // Game loop
        int turn = 1;
        while (true) {
            System.out.println("\nTurn " + turn++);

            for (Player player : Playere) {
                System.out.println("\n" + player.name + "'s turn");
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

                if (currentField.cost > 0) {
                    // Field can be bought
                    System.out.println("Cost to buy: $" + currentField.cost);
                    System.out.print("Do you want to buy? (y/n): ");
                    String input = scanner.next();
                    if (input.equalsIgnoreCase("y")) {
                        if (player.money >= currentField.cost) {
                            player.money -= currentField.cost;
                            System.out.println("Field purchased!");
                        } else {
                            System.out.println("Not enough money to buy the field.");
                        }
                    }
                } else {
                    // Field is a chance card
                    // ChanceCard drawnCard = chanceCards.remove(0);
                    // System.out.println("Chance card: " + drawnCard.description);
                    // Implement logic for chance card actions
                }

                // Check if the game should end
                if (player.money <= 0 || player.money >= 50) {
                    System.out.println(player.name + " has reached the end condition. Game over!");
                    System.exit(0);
                }
            }
        }
    }
}

// class Spiller {
//     private String navn;
//     private int saldo;

//     public Spiller(String navn) {
//         this.navn = navn;
//         this.saldo = 0;
//     }

//     public String getNavn() {
//         return navn;
//     }

//     public int getSaldo() {
//         return saldo;
//     }

//     public void addmoney(int money) {
//         this.saldo += money;
//     }
// }


