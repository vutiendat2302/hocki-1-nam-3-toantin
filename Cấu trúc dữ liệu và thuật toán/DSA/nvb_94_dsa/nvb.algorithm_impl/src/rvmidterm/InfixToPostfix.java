package rvmidterm;

public class InfixToPostfix {
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StackImpl<Character> optStack = new StackImpl<>();

        for (char token : infix.toCharArray()) {
            if (Character.isLetterOrDigit(token)) {
                postfix.append(token).append(" ");
            } else if (token == '(') {
                optStack.push(token);
            } else if (token == ')') {
                while (!optStack.isEmpty() && optStack.peek() != '(') {
                    postfix.append(optStack.pop()).append(" ");
                }
                optStack.pop();
            } else {
                while (!optStack.isEmpty() && getPriority(optStack.peek()) >= getPriority(token)) {
                    postfix.append(optStack.pop()).append(" ");
                }
                optStack.push(token);
            }
        }

        while (!optStack.isEmpty()) {
            postfix.append(optStack.pop()).append(" ");
        }

        return postfix.toString();
    }

    private static int getPriority(char opt) {
        return switch (opt) {
            case '+','-' -> 4;
            case '*','/' -> 5;
            case '^' -> 6;
            default -> -1;
        };
    }
}
