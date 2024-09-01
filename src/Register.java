import java.util.Scanner;

public class Register {
    private static final Denomination[] denominations = {
            new Denomination("Twenty Dollar Bill", 20.00),
            new Denomination("Ten Dollar Bill", 10.00),
            new Denomination("Five Dollar Bill", 5.00),
            new Denomination("One Dollar Bill", 1.00),
            new Denomination("Quarter", 0.25),
            new Denomination("Nickle", 0.05),
            new Denomination("Dimes", 0.10),
            new Denomination("Penny", 0.01),
    };

    public Purse makeChange(double amt){
        Purse purse = new Purse(denominations);

        for (int i = 0;i < denominations.length;i++){
            Denomination denomination = denominations[i];
            int count = (int)(amt / denomination.values());
            if (count > 0){
                purse.addDenomination(i,count);
                amt -= (count * denomination.values());
                //amt = (amt * 100.0) / 100.0;
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        Register register = new Register();

        System.out.println("Enter the amount you'd like to convert to dollars and change: ");
        double amt = scan.nextDouble();
        Purse purse = register.makeChange(amt);

        System.out.println("Your Purse contains:");
        Denomination[] denominations = purse.getDenomination();
        int[] count = purse.getCount();
        for (int i = 0;i < denominations.length;i++){
            if (count[i] > 0){
                System.out.println(denominations[i].name() + "(s): " + count[i]);
            }
        }
    }

}
