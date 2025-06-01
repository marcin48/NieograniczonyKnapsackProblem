package knapsack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ProblemTest {

    @Test
    public void testOneSelected() {
        Problem problem = new Problem(5, 1234, 1, 10);
        Result result = problem.Solve(10);

        assertFalse(result.getFinalItems().isEmpty(), "Lista wybranych przedmiotów nie powinna być pusta");
    }

    @Test
    public void testNoFit() {
        Problem problem = new Problem(3, 1234, 5, 10);
        Result result = problem.Solve(1);

        assertTrue(result.getFinalItems().isEmpty(), "Lista wybranych przedmiotów powinna być pusta");
        assertEquals(0, result.getSumaWag(), "Suma wag powinna być 0");
        assertEquals(0, result.getSumaWartosci(), "Suma wartości powinna być 0");
    }

    @Test
    public void testSum() {
        int lower = 1;
        int upper = 10;
        Problem problem = new Problem(20, 1234, lower, upper);

        List<Item> items = problem.getItems();
        for (Item item : items) {
            assertTrue(item.waga >= lower && item.waga < upper, "Waga poza zakresem");
            assertTrue(item.wartosc >= lower && item.wartosc < upper, "Wartość poza zakresem");
        }
    }


    @Test
    public void testInstance() {
        Problem problem = new Problem(0, 0, 0, 0);
        problem.getItems().clear();
        problem.getItems().add(new Item(0, 2, 10));//stosunek 5
        problem.getItems().add(new Item(1, 3, 9));//3
        problem.getItems().add(new Item(2, 5, 10));//2

        int capacity = 5;
        Result result = problem.Solve(capacity);

        assertEquals(4, result.getSumaWag(), "Suma wag niepoprawna");
        assertEquals(20, result.getSumaWartosci(), "Suma wartości niepoprawna");
    }
}
