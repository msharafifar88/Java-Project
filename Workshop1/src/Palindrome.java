
public class Palindrome {
    //create Stack obj
    private Stack obj = new Stack();
    private char[] element;
    //gets one string and saves it in array of Stack
    public Palindrome(String x){

        if ( !x.isEmpty() ) {

            // toCharArray ( make sting to char array )
            this.element = x.toCharArray();

            for (int i = 0; i < element.length; i++) {
                obj.push(element[i]);
            }
        }
    }
    //checks if the String is Palindrome or not
    // If the condition satisfied return true otherwise return False
    private boolean isPalindrome(){

        boolean flag = true;

        for(int i = 0 ; i < element.length ; i++){
            flag = element[i] == obj.pop();
        }
        return flag;
    }


    public static void main(String[] args) {
        if(args.length == 1 ) {
            Palindrome obj1 = new Palindrome(args[0]);

            // check the reuaargs[0] lt of
            if (obj1.isPalindrome()) {

                System.out.println("The " + args[0] + " Argument is Palindrome");

            } else {

                System.out.println("The " + args[0]  + " Argument is not Palindrome");
            }
        }else{

            System.out.println("Error: Not enough argument");
        }
    }



}