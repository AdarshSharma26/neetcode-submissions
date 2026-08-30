class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> results = new ArrayList<>();
        generateCombinations(nums, 0, new ArrayList<Integer>(), target, results);

        return results;
    }


    public void generateCombinations(int[] array, int currentIdx, List<Integer> combinations, int total, List<List<Integer>> results){

        if(currentIdx == array.length){

            if(total == 0){
                results.add(new ArrayList<>(combinations));
            }

            return;
        }

        if(total < 0) return;

        //take
        combinations.add(array[currentIdx]);
        generateCombinations(array, currentIdx, combinations, total - array[currentIdx], results);


        //no-take
        combinations.remove(combinations.size() - 1);
        generateCombinations(array, currentIdx + 1 , combinations, total , results);
    }
}
