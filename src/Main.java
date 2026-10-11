import java.util.Stack;

public class Main {
    static boolean check (String str ){
        Stack<Character> stack = new Stack<>();
        for (char a : str.toCharArray()){
            if (a=='(') {
                stack.push(')');
            } else if (a=='[') {
                stack.push(']');
            }else if (a=='{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()|| stack.pop()!=a){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    static void main(){
        System.out.println("[]" + check("[]"));
        System.out.println("[](){}" + check("[](){}"));
        System.out.println("([])" + check("([])"));
        System.out.println("[)" + check("[)"));
    }
}