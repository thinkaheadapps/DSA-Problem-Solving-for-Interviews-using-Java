package Stack;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "{{[[(())]]}}";

        System.out.println("Test 1 is " + (isValid(test1) == 1 ? "valid" : "invalid"));
        System.out.println("Test 2 is " + (isValid(test2) == 1 ? "valid" : "invalid"));
        System.out.println("Test 3 is " + (isValid(test3) == 1 ? "valid" : "invalid"));
    }

    public static int isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch =='[') {
                st.push(ch);
            } else {
                if(st.size()== 0) {
                    return 0;
                }

                if(ch == ')' && st.peek() == '(') {
                    st.pop();
                } else if(ch == '}' && st.peek() == '{') {
                    st.pop();
                } else if(ch == ']' && st.peek() == '[') {
                    st.pop();
                } else {
                    return 0;
                }
            }
        }
        if(st.size()== 0) {
            return 1;
        }
        else {
            return 0;
        }

    }
}
