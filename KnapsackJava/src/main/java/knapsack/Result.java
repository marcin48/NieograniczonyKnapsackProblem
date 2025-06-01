package knapsack;

import java.util.*;

public class Result {

    private List<Item> finalItems;
    private int sumaWag;
    private int sumaWartosci;

    public Result(List<Item>items, int waga, int wartosc){
        this.finalItems = items;
        this.sumaWag = waga;
        this.sumaWartosci = wartosc;
    }

    @Override
    public String toString() {
        int  sortId = -1;
        StringBuilder sb = new StringBuilder();
        sb.append("Wybrane przedmioty:\n");

        for (int i = 0; i < finalItems.size(); i++) {
            Item item = finalItems.get(i);
            if(item.index != sortId){
                sortId = item.index;
                sb.append("Id: ").append(item.index)
                        .append(", Waga: ").append(item.waga)
                        .append(", Wartość: ").append(item.wartosc)
                        .append(", Użyte razy: ").append(item.usage).append("\n");
            }

        }

        sb.append("Suma wag: ").append(sumaWag).append("\n");
        sb.append("Suma wartości: ").append(sumaWartosci).append("\n");

        return sb.toString();
    }


    public List<Item> getFinalItems() {
        return finalItems;
    }

    public int getSumaWag() {
        return sumaWag;
    }

    public int getSumaWartosci() {
        return sumaWartosci;
    }
}
