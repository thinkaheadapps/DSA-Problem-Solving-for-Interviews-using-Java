package Stack;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] exp = {"4", "13", "5", "/", "+"};

        System.out.println(calculateRPN(exp));
    }

    public static int calculateRPN(String[] exp) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < exp.length; i++) {
            String str = exp[i];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int pop1 = st.pop();
                int pop2 = st.pop();

                st.push(solve(pop2,pop1,str));
             } else {
                st.push(Integer.parseInt(str));
            }
        }
       return st.pop();
    }

    public static int solve(int pop2, int pop1, String opt) {
        if (opt.equals("+")) {
            return pop2 + pop1;
        } else if (opt.equals("-")) {
            return pop2 - pop1;
        } else if (opt.equals("*")) {
            return pop2 * pop1;
        } else {
            return pop2 / pop1;
        }

    }
}


/*
Evaluate the value of the arithmetic expression given in Reverse Polish Notation.
Reverse Polish Notation - It is a notation in which operators follow their operand.

Note-
-The given expression always evaluate to a result.
- Operators are only +,-, * and /.

Sample input:
expression = ["2", "3", "*","4","+"]
Sample Output - 10

Infix Notation a + b => operator is in between two operands.
Polish Notation - if operator is present before the operands, its called Polish Notation. ex +1 b
Reverse Polish Notation - reverse condition when operator is present after operands - a b +

TC - O(n)
sc - O(d)- where d is no of operands
* */