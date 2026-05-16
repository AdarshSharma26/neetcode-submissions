class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int i = 0; i < nums.length; i++){            
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int num : map.keySet()){
            minHeap.add(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }

        return result;
    }
}
