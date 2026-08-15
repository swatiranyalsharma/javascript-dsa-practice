class Solution {
    public int longestSubsequence(int[] nums) {
        int length = 0;
        int xor = 0;
        boolean isZero = true;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
            if(nums[i] !=0) isZero = false;
        }
        if(isZero) return 0;
        if(xor !=0){
            length= nums.length;
        }else{
            length = nums.length -1;
        }
        return length;
    }
}