// The Stack class
// In this class we creat a Array of Stack that hold each
// char in Stack Last in first out
public class Stack {
    private static char element[];
    private int top;
    // No argument constructor for creat empty object
    public Stack() {
        element = new char[0];
        top = 0;
    }

    // the push method for pushing each char on top
    //our stack. the last element will be on
    // the top of the stack.

    public static void push(char x) {
        // create a new temp array with length +1 for save new char
        char temp[] = new char[element.length + 1];
        for (int i = 0; i < element.length; i++) {
            temp[i] = element[i];
        }
        temp[element.length] = x;
        element = temp;
    }
//    public static boolean check_empty(){
//        if (element.)
//
//    }
    public static char pop() {
        // char \u0000 = null in java union code
        // return null wile the stack is empty
        char output_elemetnt = '\u0000';
        if (element.length != 0) {
            char[] temp = new char[element.length - 1];
            //get the top element and then remove that form
            //the top of stack.
            output_elemetnt = element[element.length - 1];
            for (int i = 0; i < element.length - 1; i++)
            {
                // update a new element
                temp[i] = element[i];
            }
            element = temp;
        }  return output_elemetnt;
    }

}

