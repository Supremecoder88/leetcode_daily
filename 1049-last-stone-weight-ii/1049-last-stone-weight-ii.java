class Solution {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;

        for(int stone : stones)
            sum += stone;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int stone : stones){

            for(int s = target;
                s >= stone;
                s--){

                dp[s] =
                    dp[s] || dp[s-stone];
            }
        }

        // Find the closest possible subset sum to sum/2
        for(int s = target; s >= 0; s--){

            if(dp[s]){

                return sum - 2*s;
            }
        }

        return 0;
    }
}