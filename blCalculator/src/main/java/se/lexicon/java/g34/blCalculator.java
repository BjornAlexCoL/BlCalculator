package se.lexicon.java.g34;

import java.util.Scanner;

/**
 Calculator
 Your assignment is to create a basic Console-based calculator. It should be able to handle basic mathematical operations (addition, subtraction, multiplication, division), and be able to present the results in a consistent way.
 Required Features:
 • The program should be able to perform basic mathematical operations
 (Math has methods for more advanced operations if you include them)
 o Addition, Subtraction, Division, Multiplication, etc…
 • The program should keep running until the user chooses to end it.
 Optional:
 • Addition and Subtraction should be able to handle any number of
 parameters
 Code Requirements:
 • Each mathematical operation should be in its own method
 • Use a loop and a menu system to keep the program running.
 */
public class blCalculator
{
    public static void main( String[] args ) {
        String sOperation;
        double dResult = 0,dAccResult=0;
        Scanner sInpStr = new Scanner(System.in);
        do {
            System.out.print("Input operator (+,-,*,/). 'C' reset acumulated result. 'E' delete latest operation. 'Q' to End.");
            sOperation = sInpStr.next();
            sOperation = sOperation.toUpperCase();
            System.out.println("Operator is: "+ sOperation);
            switch (sOperation.charAt(0)){
            case 'Q': {
                System.out.println("Welcome Back");
                break;
                }
            case 'C': {
                dAccResult = 0;
                dResult = 0;
                break;
                }
            case 'E': {
                dAccResult -= dResult;
                break;
                }
            default: {
                dResult = dDoTheMath(sOperation.charAt(0));
                break;
                }
            }
            dAccResult += dResult;
            System.out.println("The acumulated result is " + dAccResult);
        }
        while (sOperation.charAt(0) != 'Q');
    }
    public static double dDoTheMath(char cOperator) {
        double dNumber1, dNumber2, dResult;
        Scanner sInpStr = new Scanner(System.in);
        System.out.print("Input Number 1:");
        dNumber1 = sInpStr.nextDouble();
        System.out.print("Input Number 2:");
        dNumber2 = sInpStr.nextDouble();
        switch (cOperator) {
            case '+': {
                dResult = dAddition(dNumber1, dNumber2);
                break;
            }
            case '-': {
                dResult = dSubtraction(dNumber1, dNumber2);
                break;
            }
            case '*': {
                dResult = dMultiplication(dNumber1, dNumber2);
                break;
            }
            case '/': {
                dResult = dDivision(dNumber1, dNumber2);
                break;
            }
            default: {
                System.out.println("Unknown operator");
                dResult = 0;
            }
        }
        System.out.println("The Result is "+dResult);
        return dResult;
    }

    public static double dAddition(double dNumber1, double dNumber2) {
        return dNumber1 + dNumber2;
    }

    public static double dSubtraction(double dNumber1, double dNumber2) {
        return dNumber1 - dNumber2;
    }

    public static double dMultiplication(double dNumber1, double dNumber2) {
        return dNumber1 * dNumber2;
    }

    public static double dDivision(double dNumber1, double dNumber2) {
        if (dNumber2 != 0) {
            return dNumber1 / dNumber2;
        } else {
            System.out.println("Can't Divide with 0");
        }

        return dNumber1;
    }
}

