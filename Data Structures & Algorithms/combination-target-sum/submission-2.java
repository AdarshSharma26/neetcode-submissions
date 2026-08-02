class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        generateCombinations(nums, 0, target, candidates, result);
        return result;
    }

    public void generateCombinations(int[] array, int currentIdx, int target, List<Integer> subArray, List<List<Integer>> ans){

        if(currentIdx == array.length){
            if(target == 0){
                ans.add(new ArrayList<>(subArray));
            }
            return;
        }

        if(currentIdx == array.length || target < 0){
            return;
        }

        //take
        subArray.add(array[currentIdx]);
        generateCombinations(array, currentIdx, target - array[currentIdx], subArray, ans);

        //no-take
        subArray.remove(subArray.size() - 1);
        generateCombinations(array, currentIdx + 1, target, subArray, ans);
    }
}
