import java.util.Scanner;

abstract class Spil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int antalSpillere;

        while (true) {
            System.out.println("Enter numbers of players (2-4): ");
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
            String navn = scanner.nextLine();
            spillere[i] = new Spiller(navn);
        }
        scanner.close();
    }
}

class Spiller {
    private String navn;
    private int saldo;

    public Spiller(String navn) {
        this.navn = navn;
        this.saldo = 0;
    }

    public String getNavn() {
        return navn;
    }

    public int getSaldo() {
        return saldo;
    }

    public void addmoney(int money) {
        this.saldo += money;
    }
}