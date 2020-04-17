
public class BasicArrays {
    public static void main(String[] args) {
        // The longest most drawn out way to work with arrays
        int[] badNumbers = new int[3];
        badNumbers[0] = 42;
        badNumbers[1] = 35;
        badNumbers[2] = 24;
        int sumThem = badNumbers[0] + badNumbers[1] + badNumbers[2];

        // Pass By value
        int x = 7;
        int y = 8;
        int[] stuck = stick(x, y);

        // Pass By Reference
        System.out.println("badNumbers " + badNumbers);
        System.out.println("TOTAL: " + total(badNumbers));

        int[] betterNumbers = {123, 456, 777, 321};
        String[] students = {"Andrew", "Aaron", "Chelsey", "Hannah",
            "Spencer"};
        System.out.println("betterNumbers " + betterNumbers);
    }

    public static int[] stick(int a, int b) {
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        a = 9999;
        return result;
    }

    public static int total(int[] nums) {
        System.out.println("nums " + nums);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
        }
        nums[1] = -1;
        return sum;
    }
}
