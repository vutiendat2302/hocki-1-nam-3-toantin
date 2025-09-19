package rvmidterm;

public class StackUtils {
    /**
     *
     * @param formula to calculate a formula
     * @return value evaluated with formula
     */
    public static double evaluateFormula(String formula) {
        String [] tokens = formula.split("\\s+");
        StackImpl<Double> itemStack = new StackImpl<>();
        StackImpl<String> operatorStack = new StackImpl<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                itemStack.push(Double.parseDouble(token));
            }
            if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                while (!operatorStack.isEmpty() && getPriority(operatorStack.peek()) >= getPriority(token)) {
                    double value2 = itemStack.pop();
                    double value1 = itemStack.pop();
                    itemStack.push(calculate(value1, operatorStack.pop(), value2));
                }
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    double value2 = itemStack.pop();
                    double value1 = itemStack.pop();
                    itemStack.push(calculate(value1, operatorStack.pop(), value2));
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            double value2 = itemStack.pop();
            double value1 = itemStack.pop();
            itemStack.push(calculate(value1, operatorStack.pop(), value2));
        }

        return itemStack.pop();
    }

    private static int getPriority(String opt) {
        if (opt.equals("+") || opt.equals("-")) {
            return 4;
        }

        if (opt.equals("*") || opt.equals("/")) {
            return 5;
        }

        return -1;
    }

    private static double calculate(double val1, String opt, double val2) {
        return switch (opt) {
            case "+" -> val1 + val2;
            case "-" -> val1 - val2;
            case "*" -> val1 * val2;
            case "/" -> val1 / val2;
            default -> throw new ArithmeticException("Unrecognized operator: " + opt);
        };
    }


    /**
     *
     * @param expression a string describe input
     * @return whether this string is valid expression or not (boolean)
     */
    public boolean isValidExpression(String expression) {
        char [] tokens = expression.toCharArray();
        StackImpl<Character> exprStack = new StackImpl<>();

        for (char token : tokens) {
            if (token == '(' || token == '{' || token == '[') {
                exprStack.push(token);
            } else if (token == ')' || token == '}' || token == ']') {
                if (exprStack.isEmpty()) {
                    return false;
                }

                char negToken = exprStack.peek();
                if ((negToken == '(' && token == ')')
                || (negToken == '{' && token == '}')
                || (negToken == '[' && token == ']')) {
                    exprStack.pop();
                } else {
                    return false;
                }
            }
        }

        return exprStack.isEmpty();
    }

    /**
     *
     * @param stack
     */
    public void reverseStack(StackImpl<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverseStack(stack);
        insertHelper(stack, top);
    }

    public void insertHelper(StackImpl<Integer> stack, int item) {
        if (stack == null || stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int top = stack.pop();
        insertHelper(stack, item);
        stack.push(top);
    }
}
