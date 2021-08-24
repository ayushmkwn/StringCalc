public class Calc {
    public int add(String input) {

        if (input.length() == 0) {
            return 0;
        } else if (input.length() == 1) {
            return Integer.parseInt(input);
        } else {
            String[] nums=input.split(",");
            return sum(nums);
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
