import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static int addCounter = 0;

    public int add(String numbers) {
        addCounter++;
        if(!numbers.isEmpty()){
            List<Integer> numbersList = getIntListFromString(numbers);
            negatives(numbersList);
            return getSumFromIntList(numbersList);
        }
        return 0;
    }

    private void negatives(List<Integer> numbersList) {
        StringBuilder negativeNumbers = new StringBuilder();
        numbersList.stream().filter(number -> number < 0).forEach(number -> negativeNumbers.append(" ").append(number));
        if(!negativeNumbers.toString().isEmpty()){
            throw new RuntimeException("negatives not allowed :"+ negativeNumbers);
        }
    }

    private int getSumFromIntList(List<Integer> numbersList) {
        return numbersList.stream()
                .mapToInt(Integer::intValue)
                .filter(number -> number < 1001)
                .sum();
    }

    private List<Integer> getIntListFromString(String numbers) {
        return Arrays.stream(getSplit(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] getSplit(String numbers) {
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

    public int getCalledCount() {
        return addCounter;
    }
}
    