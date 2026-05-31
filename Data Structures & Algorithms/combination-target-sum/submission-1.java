class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> candidate = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        generateSubsets(nums, 0, target, candidate, result);

        return result;
    }

    public void generateSubsets(
        int[] nums, int currentIdx, int target, List<Integer> candidate, List<List<Integer>> result) {
        if (currentIdx == nums.length) {

            if(target == 0){
                result.add(new ArrayList<>(candidate));
            }
            return;
        }

        if (target < 0) {
            return;
        }

        // take
        candidate.add(nums[currentIdx]);
        generateSubsets(nums, currentIdx, target - nums[currentIdx], candidate, result);

        // no take
        candidate.remove(candidate.size() - 1);
        generateSubsets(nums, currentIdx + 1, target, candidate, result);
    }
}
