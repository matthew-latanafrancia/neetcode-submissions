class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (intMap.containsKey(target - nums[i])) {
                // there is one. return current index and the one at target - number
                int[] intArray = {intMap.get(target-nums[i]), i};
                return intArray;
            }
            else {
                intMap.put(nums[i], i);
            }
        }
        return null;
    }
}
