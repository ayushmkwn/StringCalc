public class Calc {
    public int add(String input) {

        if (input.length() == 0) {
            return 0;
        } else if (input.length() == 1) {
            return Integer.parseInt(input);
        } else {
            String[] nums=input.split(",");
            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            return sum;
        }
    }

}
