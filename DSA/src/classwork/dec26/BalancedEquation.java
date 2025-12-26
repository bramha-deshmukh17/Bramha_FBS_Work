package classwork.dec26;

public class BalancedEquation {

    static boolean isBalancedEquation(String equation) {
        StackChar s = new StackChar(20);
        for (int i = 0; i < equation.length(); i++) {

            char ch = equation.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char topChar = s.pop();
                if ((ch == ')' && topChar != '(') ||
                        (ch == '}' && topChar != '{') ||
                        (ch == ']' && topChar != '[')) {

                    return false;
                }
            }
        }
        if (!s.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String equation = "{(a+b)*[c-d]}";

        if (isBalancedEquation(equation)) {
            System.out.println("The equation is balanced.");
        } else {
            System.out.println("The equation is not balanced.");
        }
    }
}
