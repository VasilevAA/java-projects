package functional;

import java.util.Stack;

public class func {


    private static String parse_string(String str) {

        StringBuilder b = new StringBuilder(str.trim().replaceAll("\\s", ""));
        System.out.println(str.replaceAll("\\s", ""));


        char[] symb = {'+', '*', '/', '(', ')', '-', '%'};

        for (char aSymb : symb) {
            int a = -2;
            while ((a = b.indexOf(String.valueOf(aSymb), a + 2)) != -1) {
                b.insert(a, ' ');
                b.insert(a + 2, ' ');
            }
        }

        return b.toString().trim();
    }


    private static boolean is_notation_correct(String[] tokens) {

        if (tokens.length == 0)
            return false;

        int count_brack = 0;
        boolean is_last_tocken_symbol = false;
        for (String str : tokens) {

            switch (str) {

                case "+":
                case "-":
                case "*":
                case "/":
                case "%":

                    if (!is_last_tocken_symbol)
                        return false;
                    is_last_tocken_symbol = false;

                    break;

                case "(":

                    if (is_last_tocken_symbol)
                        return false;
                    count_brack++;
                    break;

                case ")":

                    if (!is_last_tocken_symbol)
                        return false;
                    count_brack--;
                    break;

                default:

                    if (is_last_tocken_symbol)
                        return false;
                    is_last_tocken_symbol = true;
            }
        }
        return count_brack == 0;
    }


    public static String inf_to_pstf(String infx) {

        String[] tokens = parse_string(infx).split(" +");

        if (!is_notation_correct(tokens))
            return "-+-";

        Stack<String> stack = new Stack<>();

        StringBuilder ret = new StringBuilder();

        for (String str : tokens) {
            switch (str) {

                case "+":
                case "-":

                    while (!stack.empty()) {
                        if (stack.lastElement().equals("(")) {
                            break;
                        }
                        ret.append(stack.pop()).append(" ");
                    }

                    stack.push(str);
                    break;

                case "*":
                case "/":
                case "%":

                    while (!stack.empty()) {
                        if (stack.lastElement().equals("(") || stack.lastElement().equals("+")
                                || stack.lastElement().equals("-")) {
                            break;
                        }

                        ret.append(stack.pop()).append(" ");
                    }
                    stack.push(str);
                    break;

                case "(":

                    stack.push(str);
                    break;

                case ")":

                    while (!stack.lastElement().equals("(")) {

                        ret.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                    break;

                default:

                    ret.append(str).append(" ");
            }
        }

        while (!stack.empty()) {
            ret.append(stack.pop()).append(" ");
        }

        return ret.toString();
    }
}
