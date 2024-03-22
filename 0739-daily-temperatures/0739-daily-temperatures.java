class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        
        int ans[] = new int[n];
        Arrays.fill(ans,0);

        for(int i = 0; i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int pos = stack.pop();
                ans[pos] = i - pos;             
            }
            stack.push(i);    
        }
        return ans;
    }
}