package july.microsoft.questions;

import java.util.Scanner;

/**
 * Created by Vamsi on 7/14/2016.
 */
public class Sqrt {



public static void main(String[] args){

    System.out.println("Please enter a number :");
    Scanner scanner = new Scanner(System.in);

    double inputValue = Double.parseDouble(scanner.nextLine());

    Sqrt sqrt= new Sqrt();
    Double squareroot = sqrt.getSquareRoot(inputValue);
    if(squareroot>=0.0) {
        System.out.println("Square Root of the Input number is : " + squareroot.intValue());
    }else{
        System.out.printf(" Square Root of Negative number is Not possible");
    }
}

public Double getSquareRoot(double input){
    if(input<0.0){
        System.out.println("Invalid Entry !! Please Enter number >0 ");
        return -1.0;
    }

    if(input==1.0 || input ==0.0)
        return input;

    double sqrt =0;
    // Find the square root using binary search of integers between 0 and input/2
   double leftEnd =0;
   double rightEnd=Math.floor(input/2);
   double midPoint = leftEnd+Math.floor((rightEnd-leftEnd/2));
    //System.out.println("mid point is : " + midPoint);
    int i =0;
    while(true){
        i++;
        if(midPoint*midPoint>input){
            rightEnd=midPoint;

        }else if(midPoint*midPoint<input){
            leftEnd=midPoint;
        }else if(midPoint*midPoint==input){
            sqrt= midPoint;
            break;

        }

        midPoint = leftEnd+Math.floor((rightEnd - leftEnd)/2);

        if(midPoint==leftEnd || midPoint==rightEnd){
            sqrt= midPoint;
            break;
        }

      //  System.out.println("midpoint is :"+midPoint + " Left End is : "+leftEnd+ " Right End is : "+rightEnd);

    }

    //System.out.println("Number of Iterations : "+ i);
    return sqrt;
}



}
