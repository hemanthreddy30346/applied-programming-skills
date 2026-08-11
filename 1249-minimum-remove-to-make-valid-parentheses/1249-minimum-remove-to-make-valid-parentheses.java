class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        // Remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } 
            else if (c == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }

            sb.append(c);
        }

        // Remove extra '(' from the end
        StringBuilder result = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (c == '(' && balance > 0) {
                balance--;
                continue;
            }

            result.append(c);
        }

        return result.reverse().toString();
    }
}