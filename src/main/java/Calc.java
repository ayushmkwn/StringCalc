import java.util.ArrayList;
import java.util.List;

public class Calc {
    public int add(String input){
        if(input.isEmpty()) {
            return 0;
        }
        String[] nums;
        StringBuilder delimiter;
        String newIP=input;
        if(input.startsWith("//")) {
            if(isMultiDelimiterCheck(input)) {
                delimiter = new StringBuilder(Character.toString(input.charAt(2)));
                newIP = input.substring(4);
            } else {
                List<Integer> lst = new ArrayList<>();
                int len;
                int begin = input.indexOf('[');
                while (begin >= 0) {
                    lst.add(begin);
                    begin = input.indexOf('[',begin + 1);
                }

                if(lst.size() > 1) {
                    delimiter = new StringBuilder("[");
                    len = lst.size();

                    for(int i = 0; i < len; i++) {
                        int right = lst.get(i);
                        delimiter.append(input.charAt(right + 1));
                    }
                    delimiter.append("]");
                    int left = lst.get(len-1);
                    newIP = input.substring(left + 4);
                } else {
                    delimiter = new StringBuilder(delimiterSplitter(input));
                    newIP = substringGenerator(input);
                }
            }
        }
        else {
            delimiter = new StringBuilder("[,\n]");
        }
        nums=newIP.split(delimiter.toString());
        return sum(nums);
    }

    private Boolean isMultiDelimiterCheck(String input) {
        return input.charAt(2) != '[';
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
        int sum;
        sum = 0;
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
        if(!checkNegative.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers are not allowed: "+checkNegative);
        }
    }

    private String negativeChecker(String[] nums) {
        List<String> number = new ArrayList<>();
        for(String val:nums) {
            if(Integer.parseInt(val) < 0) {
                number.add(val);
            }
        }
        return String.join(",",number);
    }
}