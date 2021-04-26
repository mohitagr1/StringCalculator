import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        if(numbers.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            if(matcher.matches()){
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new RuntimeException("Wrong Custom Delimiter Format");
        }
        return numbers.split(",|\n");
    }
}
    