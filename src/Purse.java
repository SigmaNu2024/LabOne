public class Purse {
    private final Denomination[] denominations;
    private final int[] count;

    public Purse(Denomination[] denominations) {
        this.denominations = denominations;
        this.count = new int[denominations.length];
    }

    public void addDenomination(int index, int count){
        this.count[index] += count;
    }

    public Denomination[] getDenomination(){
        return denominations;
    }

    public int[] getCount(){
        return count;
    }
}
