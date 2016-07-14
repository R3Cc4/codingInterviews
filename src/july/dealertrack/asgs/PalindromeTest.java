package july.dealertrack.asgs;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by Vamsi on 7/9/2016.
 */

// Null String is a palindrome?
public class PalindromeTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Optional<String> inputString = Optional.of(input.nextLine());
        System.out.println(inputString);
        inputString.ifPresent(PalindromeTest::testPalindrome);
    }
    public static String cleanInputString(String input){
        String lowerInput= input.toLowerCase();
        lowerInput.replaceAll("[^\\w]", "");
        return lowerInput;
    }
    public static boolean testPalindrome(String input){
        String lowerInput = cleanInputString(input);

        Objects.requireNonNull(input);

        int i =0;
        int j= lowerInput.length()-1;
        while(i<j){
            if(lowerInput.charAt(i)!= lowerInput.charAt(j)){
                System.out.println(input+ " is not a Palindrome");
                return false;
            }
            i++;j--;
        }
        System.out.println(input+ " is a Palindrome");
        return true;
    }
}
