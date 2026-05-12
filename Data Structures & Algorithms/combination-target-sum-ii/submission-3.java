class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        Arrays.sort(candidates);
        
        genrateSubsets(candidates,0,0,candidate,result, target);

        return result;

    }

    public void genrateSubsets(int[] array, int currentIndex, int currentSum,List<Integer> candi, List<List<Integer>> ans, int target){

        if(currentIndex == array.length){

            if(currentSum == target){
                ans.add(new ArrayList<>(candi));
            }

            return;
        }

        if (currentIndex == array.length || currentSum > target) {
            return;
        }

        //take
        candi.add(array[currentIndex]);
        genrateSubsets(array, currentIndex + 1, currentSum + array[currentIndex], candi, ans, target);

        //no take
        candi.remove(candi.size() - 1);

        while(currentIndex + 1 < array.length && array[currentIndex] == array[currentIndex + 1]){
            currentIndex++;
        }
        genrateSubsets(array, currentIndex + 1, currentSum , candi, ans, target);
    }
}
