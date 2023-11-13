abstract class Monopoly{

    public String playerName;
    public int DiceSum;
    public int saldo;
    public String feltname;
    private static boolean Won = false;

    public Monopoly(String playerName , int DiceSum , int saldo , String feltname ){

        this.playerName = playerName;
        this.DiceSum = DiceSum;
        this.saldo = saldo;
        this.feltname = feltname;
    }

    public Integer getsaldo(){
        return this.saldo;
    }

    public String getFelt(){
        return this.feltname;
    }

    public static void main(String[] args) {

        String[][] felter = new String[1][16];

        felter[0][0] = "Odense Boldklub";
        felter[0][1] = "AGF Fodbold";
        felter[0][2] = "Lyon FC";
        felter[0][3] = "Toulouse FC";
        felter[0][4] = "VFL Wolfsburg";
        felter[0][5] = "Eintracht Frankfurt";
        felter[0][6] = "Brøndby IF";
        felter[0][7] = "FC København";
        felter[0][8] = "Manchester United FC";
        felter[0][9] = "Chelsea FC";
        felter[0][10] = "AC Milan";
        felter[0][11] = "Juventus FC";
        felter[0][12] = "Tottenham Hotspur FC";
        felter[0][13] = "Arsenal FC";
        felter[0][14] = "FC Bayern Munich";
        felter[0][15] = "Real Madrid CF";

    }


    public String getDescription(){
        return "Du har slået: " + this.DiceSum + " og er landet på feltet: " + this.feltname + " Din saldo er nu: " + this.saldo;
    }

    public void saldo(int money){

    }

    public boolean hasWon(){

        return this.saldo == 40;
    } 

    

}


class Player1 extends Monopoly{

    public Player1(String playerName , int DiceSum , int saldo , String feltname){
        super(playerName , DiceSum , saldo , feltname);
    }



}