package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchReturnsPlayerIfNameFound() {
        Player searchResult = stats.search("Semenko");
        assertEquals("Semenko", searchResult.getName());
    }
    
    @Test
    public void searchReturnsNullIfNameNotFound() {
        Player searchResult = stats.search("Random");
        assertEquals(null, searchResult);
    }
    
    @Test
    public void teamListIsCorrectSize() {
        List<Player> result = stats.team("EDM");
        assertEquals(3, result.size());
    }
    
    @Test
    public void topScorersIsCorrectSize() {
        List<Player> result = stats.topScorers(2);
        assertEquals(3, result.size());
    }
    
    @Test
    public void topScorersInCorrectOrder() {
        List<Player> result = stats.topScorers(2);
        assertEquals("Gretzky", result.get(0).getName());
    }
}
