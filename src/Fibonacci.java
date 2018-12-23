import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        final int size = 3;
        List<Integer> results = fibonacci(size);
        System.out.println(results);
    }

    private static List<Integer> fibonacci(int size) {
        List<Integer> result = new ArrayList<>();
        if(size < 3) {
            for (int index = 0; index < size; index++) {
                result.add(1);
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (index < 2) {
                    result.add(1);
                } else {
                    result.add((result.get(index - 2) + result.get(index - 1)));
                }
            }
        }
        return result;
    }
}
