import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

record Denomination(String name, double value, String form, String img){}

class Purse {
    private final Map<Denomination, Integer> money = new HashMap<>();

    public void add(Denomination type, int num) {
        money.put(type, money.getOrDefault(type, 0) + num);
    }

    public double remove (Denomination type, int num) {
        int currentNum = money.getOrDefault(type, 0);
        money.put(type, currentNum - num);
        return type.value() * num;
    }

    public double getValue(){
        return money.entrySet().stream().mapToDouble(entry -> entry.getKey().value() * entry.getValue()).sum();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : money.entrySet()) {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();
            if (count > 0){
                sb.append(count).append(" ").append(denomination.name()).append("(s)\n");
            }
        }
        return sb.toString();
    }
}

public class Register {
    private static final List<Denomination> denominations = Arrays.asList(
            new Denomination("Fifty Dollar",50.00,"Bill", "fifty_note.png"),
            new Denomination("Twenty Dollar",20.00, "Bill","twenty_note.png"),
            new Denomination("Ten Dollar", 10.00, "Bill","ten_note.png"),
            new Denomination("Five Dollar", 5.00, "Bill","five_note.png"),
            new Denomination("One Dollar",1.00, "Bill","one_note.png"),
            new Denomination("Quarter", 0.25,"Coin","quarter.png"),
            new Denomination("Dime", 0.10,"Coin","dime.png"),
            new Denomination("Nickle", 0.05,"Coin","nickle.png"),
            new Denomination("Penny", 0.01, "Coin","penny.png")
    );

    public static Purse makeChange(double amt){
        Purse purse = new Purse();
        double remaining = Math.round (amt * 100.0) / 100.0;

        for (Denomination denomination : denominations) {
            int count = (int) (remaining / denomination.value());
            if (count > 0){
                purse.add(denomination, count);
                remaining -= denomination.value() * count;
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        Register register = new Register();

        System.out.println("Enter the amount you'd like to convert to dollars and change: ");
        double amt = scan.nextDouble();
        Purse change = register.makeChange(amt);

        System.out.println("Your Purse contains: \n" + change);

        if (amt <= 0){
            System.out.println("Empty Purse");
        }
    }

}
