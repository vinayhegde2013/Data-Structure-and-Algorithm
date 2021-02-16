class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1)
			return Integer.valueOf(tokens[0]);
        int result=0;
        String expression="+-*/";
        Stack<String> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if (expression.contains(tokens[i])){
                if(!st.isEmpty()){
                    int right=Integer.valueOf(st.pop());
                    int left =Integer.valueOf(st.pop());
                   switch(tokens[i]){
                     case "+": result=left+right;
                           break;
                     case "-": result=left-right;
                           break;
                     case "*": result=left*right;
                           break;
                     case "/": result=left/right;
                           break;
                  }
                 st.push(String.valueOf(result));
                }
            }else{
                st.push(tokens[i]);
            }
        }
        return result;
    }
}
