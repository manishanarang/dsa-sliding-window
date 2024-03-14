class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1)   return nums;
  
        int[] result = new int[nums.length - k + 1];
        int t = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        int i ;
        for(i= 0; i<k;i++){
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.add(i);
        }
        
        for(;i<nums.length;i++){
            result[t++] = nums[dq.peek()];
            
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.removeFirst();
            }
            
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.add(i);
        }
        result[t++] = nums[dq.peek()];
        return result;
    }
}