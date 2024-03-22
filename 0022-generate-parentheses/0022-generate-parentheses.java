class Solution {
    List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,"", n);
        return result;
    }
    
    public void backtrack(int open, int close,String str, int n){
        if(open == n && close == n){
            result.add(str);
        }  
        if(open<n){
            backtrack(open+1, close, str+"(", n);
        }
        if(close<open){
            backtrack(open, close+1, str+")",n);
        }
    }
    
    
}