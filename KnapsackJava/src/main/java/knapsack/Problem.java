package knapsack;
import java.util.*;


public class Problem {

    private int n;
    private int seed;
    private int lowerBound;
    private int upperBound;

    private List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;

        this.items = new ArrayList<>();
        Random rand = new Random(seed);

        for (int i = 0; i < n; i++) {
            int wartosc = rand.nextInt(lowerBound, upperBound);
            int waga = rand.nextInt(lowerBound, upperBound);
            items.add(new Item(i, waga, wartosc));
        }
    }
    public List<Item> getItems() {
        return items;
    }

    public Result Solve(int capacity){
        List<Item> sortedItems = new ArrayList<>(items);
        sortedItems.sort((a, b) -> Double.compare(b.Proportion(), a.Proportion()));

        List<Item> finalItems = new ArrayList<>();
        int wagaAll = 0;
        int wartoscAll = 0;

        for (int i = 0; i < sortedItems.size(); i++) {
            Item item = sortedItems.get(i);

            while(wagaAll + item.waga <= capacity) {
                finalItems.add(item);
                wagaAll += item.waga;
                wartoscAll += item.wartosc;
                item.usage+=1;
            }
        }

        return new Result(finalItems, wagaAll, wartoscAll);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wygenerowane przedmioty:\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i)).append("\n");
        }
        return sb.toString();
    }
}