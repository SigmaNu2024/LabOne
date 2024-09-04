/*import java.util.HashMap;
import java.util.Map;

public class Purse {
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
*/