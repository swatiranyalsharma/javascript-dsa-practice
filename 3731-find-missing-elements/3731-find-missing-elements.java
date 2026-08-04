class Solution {
    //1,4,2,5
    // 1, 2, 4, 5
    // .. first = 1 -> 2 -> 3 -> 4
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int first = nums[0];
        ArrayList<Integer> res= new ArrayList<>();
        int i= 0;
        while(i<nums.length){
            if(first != nums[i]){
                res.add(first);
            }else{
                i++;
            }
            first++;
            // List.of(nums[i]);
        }
        return res;
    }
}