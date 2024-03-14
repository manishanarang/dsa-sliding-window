class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1)   return nums;
  
        int windows = nums.length - k + 1;
        int[] result = new int[windows];
        int t = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        int left=0,right = 0;
        
        for(int i = 0; i<nums.length;i++){
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.add(i);
            
            if(left > dq.peek()){
                dq.removeFirst();
            }
            
            if(right + 1 >=k){
                result[t++] = nums[dq.peek()];
                left++;
            }
            right++;
            
        }
        return result;
    }
}