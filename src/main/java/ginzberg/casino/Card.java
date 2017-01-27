package ginzberg.casino;

/**
 * Created by williammattern on 1/24/17.
 */
public class Card {
    private Suits suit;
    private Ranks rank;

    Card(Ranks rank, Suits suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public void seeCard(){
        System.out.print(getRank() + " of ");
        System.out.println(getSuit());
    }
}
