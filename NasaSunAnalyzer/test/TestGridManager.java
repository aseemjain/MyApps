/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.List;
import com.premaseem.nasasunanalyzer.GridDirector;
import com.premaseem.nasasunanalyzer.GridManager;
import com.premaseem.nasasunanalyzer.ResultCell;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author ajain
 */
public class TestGridManager {

    @Test
    public void testGridWithdata1() throws FileNotFoundException {
        List<ResultCell> topResults = getTopResults("testInput1.txt");
        assert topResults.get(0).toString().equalsIgnoreCase("(3,3 score:26)");
    }

    @Test
    public void testGridWithData2() {

        List<ResultCell> topResults = getTopResults("testInput2.txt");
        assert topResults.get(0).toString().equalsIgnoreCase("(1,2 score:27)");
        assert topResults.get(1).toString().equalsIgnoreCase("(1,1 score:25)");
        assert topResults.get(2).toString().equalsIgnoreCase("(2,2 score:23)");

    }

    private List<ResultCell> getTopResults(String file) {
        return new GridDirector(file).manageGrid();
    }

    @Test
    public void testThatGridisCreated() {
        GridManager gm = new GridManager(3);
        assert null != gm.createGrid();
        assert gm.getGridSize() == 3;
        assert 2 == gm.extractFirstNumber("2 3 4 3 2 1 3");
    }
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testThatDataIsParsedFromFile1() {
        expectedEx.expect(NullPointerException.class);
        GridManager gm = new GridManager();
        gm.parseInput(null);
    }

    @Test
    public void testThatDataIsParsedFromFile() {
        GridManager gm = new GridManager();
        String parseInput = gm.parseInput("testInput1.txt");
        assert parseInput.length() != 0;
    }
}