class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZeros = 0;
        int product = 1;

        int[] result = new int[nums.length];
        Arrays.fill(result, 0); 

        for(int num : nums){
            if(num != 0){
                product = product * num;
            }else{
                countZeros++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(countZeros == 1){
                if(nums[i] == 0){
                    result[i] = product;
                }
            }else if(countZeros < 1){
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}  
