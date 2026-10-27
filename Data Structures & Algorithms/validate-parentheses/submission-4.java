class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for(char character: array) {
            if (character == '(') {
                stack.push('(');
            }
            if (character == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '(') {
                    return false;
                }
            }
            // {}
            if (character == '{') {
                stack.push('{');
            }
            if (character == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.isEmpty() && stack.pop() != '{') {
                    return false;
                }
            }

            // []
            if (character == '[') {
                stack.push('[');
            }
            if (character == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
