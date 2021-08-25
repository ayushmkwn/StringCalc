public class Calc {
    public int add(String input) {

        if (input.length() == 0) {
            return 0;
        } else if (input.length() == 1) {
            return Integer.parseInt(input);
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
            return i;
        }
    }
    private int sum(String[] nums){
        int sum=0;
        for(String values:nums){
            sum+=Integer.parseInt(values);
        }
        return sum;
    }
}