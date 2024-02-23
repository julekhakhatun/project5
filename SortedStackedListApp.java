
/**
 *
 * @author julekhakhatun
 */
import java.util.Stack;
import java.util.Scanner;

// SortedStackedListApp class contains list of numbers.
public class SortedStackedListApp {

    /**
     * Adds a number to the stack in sorted order.
     *
     * <p>
     * If the list is empty or the given number is greater than top number, then
     * the given number will push in the stack directly. If the stack is not
     * empty and pop all the number that are greater than given number and push
     * to a temporary stack. then push given number to stack. and then pop all
     * the numbers from top of the stack and push to stack.
     *
     * @param stack the list to insert,
     * @param num the number to be inserted into the list in sorted order.
     */
    public static void addNumberInSortedOrder(Stack<Integer> stack, int num) {
        // check if the stack is empty, or the given number is larger than the 
        // top number, then push the number to the stack.
        if (stack.isEmpty() || num > stack.peek()) { 
            stack.push(num);
        } else {
            // pop all the numbers greater than given number and push to temporay stack
            Stack<Integer> temp = new Stack<Integer>();
            while (!stack.isEmpty() && num < stack.peek()) {
                temp.push(stack.pop());
            }
            // push given number to the stack.  
            stack.push(num);
            // pop all the element from temporary stack and push to stack 
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }

    /**
     * main method takes user input and comma separate the string and split user
     * input by ','. then convert the each string of number to integer, then add
     * to the stack in sorted order using addNumberInSortedOrder. Finally print
     * the elements of list in sorted order.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Enter a list of integer numbers separated by comma: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Integer> stacklist = new Stack<>();
        String[] numberAsString = input.split(",");

        for (String s : numberAsString) {
            int num = Integer.parseInt(s.trim());
            addNumberInSortedOrder(stacklist, num);
        }

        System.out.println("Sorted List: " + stacklist);

    }

}
