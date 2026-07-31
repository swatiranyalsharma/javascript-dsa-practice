class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return lis(0, nums, -1, dp);
        
    }
    public int lis(int i,int[] nums,int prev, int[][] dp){
        if(i == nums.length) return 0;
        if(prev!=-1 && dp[i][prev+1] !=-1) return dp[i][prev+1];
        int res;
        if(prev == -1 || nums[i] > nums[prev]){
            int c1 = 1 + lis(i+1,nums, i, dp);
            int c2 = lis(i+1, nums, prev, dp);
            res = Math.max(c1,c2);
        }else{
             res = lis(i+1, nums, prev, dp);
        }
       
        return dp[i][prev+1] = res;
    }
}