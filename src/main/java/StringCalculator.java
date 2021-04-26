import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String numbers) {
        if(!numbers.isEmpty()){
            List<Integer> numbersList = Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return numbersList.stream().mapToInt(Integer::intValue).sum();
        }
        return 0;
    }
}
