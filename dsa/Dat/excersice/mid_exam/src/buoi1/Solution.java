package buoi1;

import java.util.Stack;

public class Solution {
    // Cho trước một biểu thức hâậu tố, tính giá trị biểu thức;
    public double evaluate(String ex) {
        // Biểu thức hậu tố là biểu thứ có dạng 3 4 5 + *
        // Nó thực hiện phép tính theo kiểu lấy ra stack:
        String[] tokens = ex.trim().split("\\s+");
        Stack<String> opp = new Stack<>();
        Stack<Double> values = new Stack<>();

        for (String token : tokens) {
            if (token.equals("(")) {
                continue;
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                opp.push(token);
            } else if (token.equals(")")) {
                if (!opp.isEmpty()) {
                    String op = opp.pop();
                    double v2 = values.pop();
                    double v1 = values.pop();
                    double result = 0;
                    switch (op) {
                        case "+": result = v1 + v2; break;
                        case "-": result = v1 - v2; break;
                        case "*": result = v1 * v2; break;
                        case "/": result = v1 / v2; break;
                    }
                    values.push(result);
                }
            } else {
                values.push(Double.parseDouble(token));
            }
        }

        return values.pop();
    }
}
