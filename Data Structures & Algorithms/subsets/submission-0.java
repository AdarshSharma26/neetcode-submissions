class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> candidate = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        generateSubsets(nums, 0, candidate, result);

        return result;
    }

    public void generateSubsets(int[] nums, int currentIdx, List<Integer> candidate, List<List<Integer>> result){

        if(currentIdx == nums.length){
            result.add(new ArrayList<>(candidate));

            return;
        }

        //take
        candidate.add(nums[currentIdx]);
        generateSubsets(nums, currentIdx + 1, candidate, result);

        //no take
        candidate.remove(candidate.size() - 1);
        generateSubsets(nums, currentIdx + 1, candidate, result);
    }
}
