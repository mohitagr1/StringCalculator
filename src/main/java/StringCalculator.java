import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String numbers) {
        if(!numbers.isEmpty()){
            List<Integer> numbersList = getIntListFromString(numbers);
            return getSumFromIntList(numbersList);
        }
        return 0;
    }

    private static int getSumFromIntList(List<Integer> numbersList) {
        return numbersList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static List<Integer> getIntListFromString(String numbers) {
        return Arrays.stream(getSplit(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] getSplit(String numbers) {
        return numbers.split(",");
    }
}
    