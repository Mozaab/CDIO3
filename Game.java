import java.util.Random;
import java.util.Scanner;
 class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int antalSpillere;

        while (true) {
            System.out.println("Enter number of players (2-4): ");
            antalSpillere = scanner.nextInt();

            if (antalSpillere >= 2 && antalSpillere <= 4) {
                break;
            } else {
                System.out.println("invalid number of players. Try again");
            }
        }

        Spiller[] spillere = new Spiller[antalSpillere];
        scanner.nextLine();

        for (int i = 0; i < antalSpillere; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            spillere[i] = new Spiller(playerName, saldo, feltname);
        }
        scanner.close();
    }
}
    public Integer Win = 40;

    public static String[] feltname = {"OB: Your fans hate you and they smash your car. Pay 1 to repair it!",
                            "AGF: You ate too much McDonalds on your holiday, and you are not fit for the season. Pay 1 ",
                            "Olympique Lyon: You went to the Alps for skiing without permission. You get fined 1!", 
                            "Toulouse: You get fined for going out on a matchday. You get fined 1! " ,
                            "Wolfsburg: You came late for training. Pay 2",
                            "Frankfurt: The club renovates the stadium. Pay 2 " ,
                            "Broendby: The southside are not satisfied with your work. They ruin your reputation. Pay 2 for making them happy", 
                            "FCK: You won the Danish Superliga, and you are going out with the squad. The dinner cost 2.",
                            "Man United: Just pay 3. You are shite", 
                            "Chelsea: Just pay 3. You are shite",
                            "AC Milan: The fans are everything. Pay 3 for their trip for the away game against Juventus.",
                            "Juventus: You heard they paid 3 for their fans in AC Milan. You do the same to keep your fans' respect " ,
                            "Tottenham: WHAT DO YOU THINK OF SHIT? <<TOTTENHAM>> WHAT DO YOU THINK OF TOTTENHAM? <<SHIT>>. pay 4", 
                            "Arsenal: You are back in the top. You bottled being first for 10 games last season. Pay 4.", 
                            "Bayern Munich: It is expensive being the best club in the world, you need to extend the contract with your start player. Pay 5",
                            "Real Madrid: Bellingham requests bonuses for his goals. Pay 5! " };


    Random random = new Random();                           

    public void Spil(){

        System.out.println("Velkommen til Monopoly");




        public int dice(){

        }

    }
}
