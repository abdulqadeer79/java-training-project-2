import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(integerList.toString().replace("[", "").replace("]", ""));
        System.out.println(integerList);
    }
}
