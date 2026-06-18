class Solution {
    public int[] productExceptSelf(int[] nums) {

        //1,2,8,48
        //48,48,24,6

        int[] res1 = new int[nums.length];
        int[] res2 = new int[nums.length];
        res1[0] = nums[0];
        res2[nums.length-1] = nums[nums.length-1];
        for(int i = 1 ; i < nums.length; i++){
            res1[i] = res1[i-1] * nums[i];
        }
         for(int i = nums.length-2 ; i >= 0; i--){
            res2[i] = res2[i+1] * nums[i];
        }

        int[] result = new int[nums.length];
         for(int i = 0 ; i < nums.length; i++){
            int ans = 1;
            if(i-1 >= 0){
                ans = ans * res1[i-1];
            }
            if(i+1 < nums.length){
                ans = ans * res2[i+1];
            }
            result[i] = ans;
        }
        return result;

    }
}  
