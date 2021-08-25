public class Calc {
    StringBuffer checkNegativeNumber = new StringBuffer();

    public int add(String input) {
        if (input.length() == 0) {
            return 0;
        } else if (input.length() == 1) {
            int j = Integer.parseInt(input);
            if(j < 0) {
                throw new IllegalArgumentException("Negative not allowed: "+String.valueOf(j));
            }
            return j;
        } else {
            int i = 0;
            if(input.matches("//(.)\n(.*)")) {
                char delimiter = input.charAt(2);
                String newStr = input.substring(4);
                String[] nums = newStr.split(Character.toString(delimiter));
                i = sum(nums);
            } else {
                String[] nums=input.split(",|\n");
                i = sum(nums);
            }
            if(!checkNegativeNumber.toString().isEmpty()) {
                throw new IllegalArgumentException("Negative not allowed: "+checkNegativeNumber.toString());
            }
            return i;
        }
    }
    private int sum(String[] nums){
        int sum=0;
        for(String values:nums){
            if(Integer.parseInt(values) < 0) {
                if(checkNegativeNumber.toString().isEmpty()) {
                    checkNegativeNumber.append(values.toString());
                } else {
                    checkNegativeNumber.append(","+values.toString());
                }
            }
            if(Integer.parseInt(values) > 1000) {
                continue;
            }
            sum+=Integer.parseInt(values);
        }
        return sum;
    }
}