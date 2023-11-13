abstract class Monopoly{

    public String Playername;
    public int saldo;
    public String feltname;
    private static boolean Won = false;

    public Monopoly(String Playername , int saldo , String feltname ){

        this.Playername = Playername;
        this.saldo = saldo;
        this.feltname = feltname;
    }

    public Integer getSaldo(){
        return this.saldo;
    }

    public String getFelt(){
        return feltname;
    }

    public String getDescription(){
        return "Du er landet på feltet: " + this.feltname + " Din saldo er nu: " + this.saldo;
    }

    public void saldo(int money){

    }

    public boolean hasWon(){

        return this.saldo == 40;
    } 

    
}