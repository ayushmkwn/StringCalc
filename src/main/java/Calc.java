import java.util.ArrayList;
import java.util.List;

public class Calc {
    public int add(String input){
        if(input.isEmpty()) {
            return 0;
        }
        String[] nums;
        String delimiter;
        String newIP=input;
        if(input.startsWith("//")) {
            if(isMultiDelimiterCheck(input)) {
                delimiter = Character.toString(input.charAt(2));
                newIP = input.substring(4);
            } else {
                List<Integer> lst = new ArrayList<>();
                int begin = input.indexOf('[');
                while (begin >= 0) {
                    lst.add(begin);
                    begin = input.indexOf('[',begin + 1);
                }

                List<Integer> lst2 = new ArrayList<>();
                int end=input.indexOf(']');
                while(end>=0){
                    lst2.add(end);
                    end=input.indexOf(']',end+1);
                }
                //int len;
                int last = lst2.get(lst.size() - 1);

                StringBuilder s = new StringBuilder();
                int n = lst.size();
                for(int i=0; i<n; i++) {
                    int right = lst.get(i);
                    int left = lst2.get(i);
                    String temp = input.substring(right+1, left);
                    if(temp.charAt(0) == '$' || temp.charAt(0) == '.' || temp.charAt(0) == '+' || temp.charAt(0) == '?' || temp.charAt(0) == '^' || temp.charAt(0) == '*') {
                        int tempSize = temp.length();
                        StringBuilder tempStr = new StringBuilder();
                        for(int j=0; j<tempSize; j++) {
                            tempStr.append("\\").append(temp.charAt(j));
                        }
                        s.append(tempStr);
                    } else {
                        s.append(temp);
                    }

                    if(i < n-1) {
                        s.append("|");
                    }
                }
                delimiter = s.toString();
                newIP = input.substring(last + 2);

//
//                if(lst.size() > 1) {
//                    delimiter = new StringBuilder("[");
//                    len = lst.size();
//
//                    for(int i = 0; i < len; i++) {
//                        int right = lst.get(i);
//                        delimiter.append(input.charAt(right + 1));
//                    }
//                    delimiter.append("]");
//                    int left = lst.get(len-1);
//                    newIP = input.substring(left + 4);
//                } else {
//                    delimiter = new StringBuilder(delimiterSplitter(input));
//                    newIP = substringGenerator(input);
//                }

            }
        }
        else {
            delimiter = ("[,\n]");
        }
        nums=newIP.split(delimiter);
        return sum(nums);
    }

    private Boolean isMultiDelimiterCheck(String input) {
        return input.charAt(2) != '[';
    }

//    private String delimiterSplitter(String input) {
//        int begin = input.indexOf('[');
//        int last = input.indexOf(']');
//        return input.substring(begin+1, last);
//    }
//
//    private String substringGenerator(String input) {
//        int last = input.indexOf(']');
//        return input.substring(last+2);
//    }

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