class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int[] minus = new int[n];
        int[] pos = new int[n];
        int a = 0;
        int b =0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                minus[a]=nums[i];
                a++;
            }

            if(nums[i]>0){
                pos[b]=nums[i];
                b++;
            }
            
        }
        
        int[] neww= new int[n];
        int i = 0;
        int j = 0;

        for(int k = 0;k < n;k++){
            if(i == j){
                neww[k] = pos[i];
                i++;
            }else{
                neww[k] = minus[j];
                j++;
            }

            
        }
        return neww;
        
    }
}