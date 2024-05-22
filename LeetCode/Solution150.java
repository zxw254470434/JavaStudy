import java.util.Deque;
import java.util.LinkedList;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                int temp = a + b;
                stack.push(temp);
            } else if (s.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                int temp = a - b;
                stack.push(temp);
            } else if (s.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                int temp = a * b;
                stack.push(temp);
            } else if (s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int temp = a / b;
                stack.push(temp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        int res = new Solution150().evalRPN(tokens);
        System.out.println("res = " + res);
    }
}
