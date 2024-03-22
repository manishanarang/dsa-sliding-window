class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i= 0; i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }
            
            else{
                if(stack.isEmpty()) return false;
                char popped = stack.pop();
                if(!((popped == '(' && ch==')') || (popped == '[' && ch==']')|| (popped == '{' && ch=='}'))){
                    return false;
                }
                    
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}