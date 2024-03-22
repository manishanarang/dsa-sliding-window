class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = nge(nums2);
        
        int result[] = new int[nums1.length];
        
        for(int i = 0; i<nums1.length;i++){
            result[i] = ngeMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }
    
    Map<Integer,Integer> nge(int[] nums){
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i<nums.length;i++){
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                int nge = stack.pop();
                ngeMap.put(nge, nums[i]);
            }
            stack.push(nums[i]);
        }
        
        while(!stack.isEmpty()){
            ngeMap.put(stack.pop(), -1);
        }
        return ngeMap;
    }
}