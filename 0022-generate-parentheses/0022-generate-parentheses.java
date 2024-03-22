class Solution {
    List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        Deque<Character> dq = new LinkedList<>();
        backtrack(0,0,n, dq);
        return result;
    }
    
    public void backtrack(int open, int close,int n, Deque<Character> dq){
        if(open == n && close == n){
            String s = "";
            Iterator it = dq.iterator();
            while(it.hasNext()){
                s+= it.next();
            }
            result.add(s);
        }  
        if(open<n){
            dq.add('(');
            backtrack(open+1, close, n, dq);
            dq.removeLast();
        }
        if(close<open){
            dq.add(')');
            backtrack(open, close+1, n, dq);
            dq.removeLast();
        }
    }
    
    
}