package assignment2;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class MyCollections {
    public static void downsize(LinkedList<String> employees, int n) { // remove nth element
        ListIterator<String> iterator = employees.listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            String current = iterator.next();
            if (index % n == 0) { // remainder 0, multiple of n
                iterator.remove();
            }
            index++;
        }
    }

    public static boolean isBalanced(String statement) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < statement.length(); i++) {
            char character = statement.charAt(i);

            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty()) { // can't be balanced, nothing to balance right side
                    return false;
                }
                Character check = stack.pop();
                if ((character == ')' && check != '(')
                        || (character == ']' && check != '[')
                        || (character == '}' && check != '{')) {
                    return false;
                }
            }
        } // made it all the way through and still ok
        return stack.isEmpty();
    }
}
