import java.util.ArrayList;
import java.util.List;

public class Calc {
    public int add(String input){
        if(isEmptyCheck(input)) {
            return 0;
        }
        String[] nums=null;
        String delimiter=null;
        String newIP=input;
        if(input.startsWith("//")) {
            if(isMultiDelimiterCheck(input)) {
                delimiter = Character.toString(input.charAt(2));
                newIP = input.substring(4);
            } else {
                delimiter = delimiterSplitter(input);
                newIP = substringGenerator(input);
            }
        }
        else {
            delimiter = "[,\n]";
        }
        nums=newIP.split(delimiter);
        return sum(nums);
    }

    private boolean isEmptyCheck(String input) {
        return input.isEmpty();
    }

    private Boolean isMultiDelimiterCheck(String input) {
        if(input.charAt(2) == '[') {
            return false;
        } else {
            return true;
        }
    }

    private String delimiterSplitter(String input) {
        int begin = input.indexOf('[');
        int last = input.indexOf(']');
        return input.substring(begin+1, last);
    }

    private String substringGenerator(String input) {
        int last = input.indexOf(']');
        return input.substring(last+2);
    }

    private int sum(String[] nums) {
        int sum = 0;
        checkAndIgnoreNegative(nums);
        for(String values:nums) {
            if(Integer.parseInt(values) <= 1000){
                sum += Integer.parseInt(values);
            }
        }
        return sum;
    }

    private void checkAndIgnoreNegative(String[] nums) {
        String checkNegative = negativeChecker(nums);
        if(!isEmptyCheck(checkNegative)) {
            throw new IllegalArgumentException("Negative numbers are not allowed: "+checkNegative);
        }
    }

    private String negativeChecker(String[] nums) {
        List<String> number = new ArrayList<String>();
        for(String val:nums) {
            if(Integer.parseInt(val) < 0) {
                number.add(val);
            }
        }
        return lstToStr(number);
    }

    private String lstToStr(List<String> nums) {
        return String.join(",",nums);
    }
}