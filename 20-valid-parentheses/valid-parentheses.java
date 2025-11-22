public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false; // odd length can't be valid

        char[] stack = new char[n]; // simulate stack
        int top = -1; // stack is empty

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c; // push opening bracket
            } else {
                if (top == -1) return false; // no matching opening

                char open = stack[top--]; // pop top
                if (c == ')' && open != '(') return false;
                if (c == '}' && open != '{') return false;
                if (c == ']' && open != '[') return false;
            }
        }

        return top == -1; // valid if stack is empty
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));      // true
        System.out.println(sol.isValid("()[]{}"));  // true
        System.out.println(sol.isValid("(]"));      // false
        System.out.println(sol.isValid("([)]"));    // false
        System.out.println(sol.isValid("{[]}"));    // true
    }
}
