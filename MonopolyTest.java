import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MonopolyTest {
    
    @Test
    public void testMonopoly(){


        
        Player player1 = new Player("Spiller1" , 0); 
        Player player2 = new Player("Spiller2", 0);

        
        int antalGange = 1000; 
        int acceptedRange = 50;
        int[] verdier = new int[6];

        for(int i=0; i<antalGange; i++){
            int diceRoll = (int) (Math.random() * 6) + 1;
            
            verdier[diceRoll-1]++;
        }

        for(int i=0;i<verdier.length;i++){
            assertTrue(verdier[i] > (antalGange/6)-acceptedRange && verdier[i]< (antalGange/6)+acceptedRange);
        }

    }
}
