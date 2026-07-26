class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hr = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hr.contains(nums[i])){
                return true;
            }else{
                hr.add(nums[i]);
            }
        }
        return false;
    }
}