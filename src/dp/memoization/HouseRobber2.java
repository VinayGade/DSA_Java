package dp.memoization;

//LeetCode 213: HouseRobber2 (... House Robber in Circular houses)
public class HouseRobber2 {

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return nums[0];

        //create 2 new arrays
        int[] skipLast = new int[n-1];
        int[] skipFirst = new int[n-1];

        for(int i=0; i < n-1; i++){
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i+1];
        }

        //get the loot from boyh cases
        int lootSkipLast = robHelper(skipLast);
        int lootSkipFirst = robHelper(skipFirst);

        //return max of 2 loots
        return Math.max(lootSkipLast, lootSkipFirst);
    }

    static int robHelper(int[] nums){
        if (nums.length < 2)
            return nums[0];

        int[] loots = new int[nums.length];

        loots[0] = nums[0];
        loots[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            loots[i] = Math.max(loots[i - 2] + nums[i], loots[i - 1]);
        }

        return loots[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] amounts = {2, 7, 3, 1, 4, 2, 1, 8};
        int maxLoot = rob(amounts);
        System.out.println("in circular houses Robber can rob Maximum loot ="+maxLoot);
    }
}
