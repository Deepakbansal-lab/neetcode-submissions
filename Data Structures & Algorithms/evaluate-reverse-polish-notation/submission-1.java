class Solution {
    public int evalRPN(String[] tokens) {


        Stack<Integer> stk = new Stack<>();

        for(String str : tokens){
            if(str.equals("+")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(a + b);

            }else if(str.equals("-")){

                int a = stk.pop();
                int b = stk.pop();
                stk.push(b - a);

            }else if(str.equals("/")){

                int a = stk.pop();
                int b = stk.pop();
                stk.push((b / a));

            }else if(str.equals("*")){

                int a = stk.pop();
                int b = stk.pop();
                stk.push(a * b);

            }else{
                stk.push(Integer.valueOf(str));
            }
        }

        return stk.pop();
    }
}
