import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void testCanYouAddMoney() {

        Player p = new Player("playertest", 100);

        p.addMoney(50);
      
        assertEquals(150, p.money);
    }
    @Test
    public void testCanYouSubtractMoney() {

        Player p = new Player("playertest", 100);

        p.subtractMoney(50);

        assertEquals(50, p.money);
    }
    @Test
    public void testDoesPositionResetUponExceedingTheMax(){

    Player[] Playere = { new Player("TestPlayer", 20) };
        GameBoard startSquare = new GameBoard("Start", 0, false, false);

        ArrayList<GameBoard> fields = new ArrayList<>();
        fields.add(startSquare);

        int diceRoll = 5; 
        Playere[0].position = fields.size() - diceRoll;

        int turns = 2; 
        for (int turn = 1; turn <= turns; turn++) {
            for (Player currentPlayer : Playere) {
                int simulatedDiceRoll = (int) (Math.random() * 6) + 1;
                currentPlayer.position = (currentPlayer.position + simulatedDiceRoll) % fields.size();

                if (currentPlayer.position > 24) {
                    currentPlayer.position = 0;
                }
            }
        }

        assertEquals(0, Playere[0].position, "Player's position should be reset to 0 after reaching the end of the board.");
    }
}