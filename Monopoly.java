 class Monopoly{

    public String playerName;
    public int saldo;
    public String feltname;
    private static boolean Won = false;

    public Monopoly(String playerName, int saldo , String feltname ){

        this.playerName = playerName;
        this.saldo = saldo;
        this.feltname = feltname;
    }

    public Integer getSaldo(){
        return this.saldo;
    }
    public String getNavn() {
        return playerName;
    }
    public String getFelt(){
        return this.feltname;
    }

    public String getDescription(){
        return "Du har slået: " + this.DiceSum + " og er landet på feltet: " + this.feltname + " Din saldo er nu: " + this.saldo;
    }

    public void saldo(int money){
        this.saldo += money;
    }

    public boolean hasWon(){

        return this.saldo == 40;
    } 

    

}


class Spiller extends Monopoly{

    public Spiller(String playerName, int saldo , String feltname){
        super(playerName, saldo , feltname);
    }



}