class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        Arrays.sort(candidates);

        genrateCombinations(candidates, 0, unique, target, res);
        return res;
    }

    public void genrateCombinations(int[] candidates, int currentIdx, List<Integer> unq, int target, List<List<Integer>> res ){

        if(currentIdx == candidates.length){

            if(target == 0){
                res.add(new ArrayList<>(unq));
            }

            return;
        }


        if(target < 0) return;

        //take
        unq.add(candidates[currentIdx]);
        genrateCombinations(candidates, currentIdx + 1, unq, target - candidates[currentIdx], res);

        //no take
        unq.remove(unq.size() - 1);
        
         while (currentIdx + 1 < candidates.length && candidates[currentIdx] == candidates[currentIdx+1]){  
            currentIdx++;
        }


        genrateCombinations(candidates, currentIdx + 1, unq, target, res);

    }

}
