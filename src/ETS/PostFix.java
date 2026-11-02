public class PostFix {
    public static int rpm(String px) {
        Stack<Integer> s = new Stack<>();
        for(int i ==; i <px.length(); i++){
            String o = "" + px.charAt(i);
        }
        if(o.equals("+")){
            int op1 = s.pop();
            int op2 = s.pop();
            s.push(op1+op2);
        } else {
            s.push(Integer.parseInt(o));
        }
        return s.pop();
    }
}
