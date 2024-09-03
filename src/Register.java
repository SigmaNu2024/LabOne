import java.util.Scanner;

record Denomination(String name, double value, String form, String img){}


public class Register {
    private static final Denomination[] denominations = {
            new Denomination("Fifty Dollar",50.00,"Bill", "fifty_note.png"),
            new Denomination("Twenty Dollar",20.00, "Bill","twenty_note.png"),
            new Denomination("Ten Dollar", 10.00, "Bill","ten_note.png"),
            new Denomination("Five Dollar", 5.00, "Bill","five_note.png"),
            new Denomination("One Dollar",1.00, "Bill","one_note.png"),
            new Denomination("Quarter", 0.25,"Coin","quarter.png"),
            new Denomination("Dime", 0.10,"Coin","dime.png"),
            new Denomination("Nickle", 0.05,"Coin","nickle.png"),
            new Denomination("Penny", 0.01, "Coin","penny.png"),
    };

    public static Purse makeChange(double amt){
        Purse purse = new Purse();
        double remaining = amt;

        for (Denomination denomination : denominations) {
            int count = (int) (remaining / denomination.value());
            if (count > 0){
                purse.add(denomination, count);
                remaining -= denomination.value() * count;
            }
        }
        return purse;
        /*Purse purse = new Purse(Register.denominations);

        for (int i = 0; i < Register.denominations.length; i++){
            Denomination denomination = Register.denominations[i];
            int count = (int)(amt / denomination.value());
            if (count > 0){
                purse.addDenomination(i,count);
                amt -= (count * denomination.value());
                amt = (amt * 100.0) / 100.0;
            }
        }
        return purse;*/
    }

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        Register register = new Register();

        System.out.println("Enter the amount you'd like to convert to dollars and change: ");
        double amt = scan.nextDouble();
        Purse change = Register.makeChange(amt);

        System.out.println("Your Purse contains: " + change);

        if (amt <= 0){
            System.out.println("Empty Purse");
        }
        /*Denomination[] denominations = purse.getDenomination();
        int[] count = purse.getCount();
        for (int i = 0;i < denominations.length;i++){
            if (count[i] > 0){
                System.out.println(denominations[i].name() + " " + denominations[i].form() + "(s): " + count[i]);
            }
        }*/
    }

}
