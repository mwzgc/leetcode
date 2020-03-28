package com.mwz.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class T20 {

    private HashMap<Character, Character> mappings;

    public T20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (mappings.containsKey(ch)) {
                if (stack.isEmpty()) return false;
                char peekCh = stack.pop();
                if (peekCh != mappings.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }

//            if (ch == '(' || ch == '[' || ch == '{') {
//                stack.push(ch);
//            } else if (ch == ')' || ch == ']' || ch == '}') {
//                if (stack.isEmpty()) return false;
//
//                char peekCh = stack.peek();
//                if ((peekCh == '(' && ch == ')')
//                        || (peekCh == '[' && ch == ']')
//                        || (peekCh == '{' && ch == '}')){
//                    stack.pop();
//                }
//            } else {
//                return false;
//            }
        }

        return stack.isEmpty();
    }

}
