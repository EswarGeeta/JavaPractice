package org.practice.problemsolving;

import java.util.Stack;

public class ParanthesisChecker {

    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";
        System.out.println(checkParentheses(input));
    }

    private static boolean checkParentheses(String input) {
        Stack<Character> paranStack = new Stack<Character>();
        for(Character ch : input.toCharArray()) {
            if (isOpen(ch)) {
                paranStack.push(ch);
            } else if( isClosed(ch)) {
                if(paranStack.empty())
                    return false;
                Character openChar = paranStack.pop();
                if(! isMatching(openChar, ch))
                    return false;
            } else {
                //If any other invalid character comes
                return false;
            }
        }
        return (paranStack.size() == 0);
    }

    private static boolean isMatching(Character openChar, Character ch) {
        return (( openChar == '[' && ch == ']') || (openChar == '(' && ch == ')') || ( openChar == '{' && ch == '}' ));
    }

    private static boolean isOpen(Character ch) {
        return ch == '[' || ch == '(' || ch == '{';
    }

    private static boolean isClosed(Character ch) {
        return ch == ']' || ch == ')' || ch == '}';
    }



}
