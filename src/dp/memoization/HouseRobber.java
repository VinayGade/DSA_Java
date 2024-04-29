package dp.memoization;

//LeetCode 198: HouseRobber
public class HouseRobber {

    static int rob(int[] nums){
        int n = nums.length;

        // only 1 house
        if(n < 2)
            return nums[0];

        // max loot in every house
        int[] loots = new int[n];

        //loots at first 2 index
        loots[0] = nums[0];
        loots[1] = Math.max(nums[0], nums[1]);

        //use them to fill loots array
        for(int i=2; i<n; i++){

            //formula for core logic
            loots[i] = Math.max(loots[i-2]+nums[i], loots[i-1]);
        }
        return loots[n-1];
    }
    public static void main(String[] args) {

        int[] amounts = {2, 7, 3, 1, 4, 2, 1, 8};
        int maxLoot = rob(amounts);
        System.out.println("Robber can rob Maximum loot ="+maxLoot);
    }
}
