import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '(') return false;
                else stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '{') return false;
                else stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '[') return false;
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
