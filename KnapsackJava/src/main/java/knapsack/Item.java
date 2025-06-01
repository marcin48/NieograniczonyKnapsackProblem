package knapsack;

public class Item {

    public int index;
    public int waga;
    public int wartosc;
    public int usage;

    public Item(int Id, int waga, int wartosc){
        this.index = Id;
        this.waga = waga;
        this.wartosc = wartosc;
        this.usage = 0;

    }

    public double Proportion(){
        return (double)wartosc/waga;
    }

    @Override
    public String toString(){
        return "Id: "+index+", Waga: "+waga+", Wartosc: "+wartosc;
    }
}
