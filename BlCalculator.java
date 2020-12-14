
/*
 Calculator
 Your assignment is to create a basic Console-based calculator. It should be able to handle basic mathematical operations (addition, subtraction, multiplication, division), and be able to present the results in a consistent way.
 Required Features:
 • The program should be able to perform basic mathematical operations
 (Math has methods for more advanced operations if you include them)
 o Addition, Subtraction, Division, Multiplication, etc…
 • The program should keep running until the user chooses to end it.\r\n Optional:
 • Addition and Subtraction should be able to handle any number of
 parameters
 Code Requirements:
 • Each mathematical operation should be in its own method
 • Use a loop and a menu system to keep the program running.*/
package se.lexicon.java.g34;
import java.util.Scanner;

public class BlCalculator {

    public static void main(String[] args) {
        Scanner sInpStr = new Scanner(System.in);
        String sOperation;
        double dResult , dAccResult = 0;
        do {
            dResult = doTheMath();
            dAccResult += dResult;
            System.out.println("The accumulated result is " + dAccResult);
            System.out.print("'R' to run again. 'C' reset accumulated result. 'E' delete latest operation. 'Q' to End.");
            sOperation = sInpStr.nextLine();
            sOperation = sOperation.toUpperCase();
            /* Empty String Sets the Input to R to run the program again */
            if (sOperation.isEmpty()) {
                sOperation = "R";
                }

            switch (sOperation.charAt(0)) {
                case 'Q': {/* Q=Quit */
                    System.out.println("Welcome Back");
                    return; /* Forced ending */
                    }
                case 'C': { /* C=C Clear */
                    dAccResult = 0;
                    System.out.println("The accumulated result is " + dAccResult);
                    break;
                    }
                case 'E': { /* E=CE Clear last */
                    dAccResult -= dResult;
                    System.out.println("Latest result " + dResult+ " removed. The accumulated result is " + dAccResult);
                    break;
                    }
                default: { /* Continue the Loop */
                    break;
                    }
                }
            }
        while (sOperation.charAt(0) != 'Q') ; /* Continue forever as the Case 'Q' returns.*/
    }

    public static double doTheMath(){
        Scanner inpStr = new Scanner(System.in);
        String sOperation;
        double dNumber1 ,  dResult;
        int iNumberCount=0;
        dNumber1 = getValidDouble(++iNumberCount);
        do {
            System.out.print("Input operator (+,-,*,/)." );
            sOperation = inpStr.nextLine();
            /* Return first number if no operator is entered */
            if (sOperation.isEmpty()) {
                return dNumber1;
                }

            switch (sOperation.charAt(0)) {
                case '+': {
                    dResult = doAddition(dNumber1,getValidDouble(++iNumberCount));
                    break;
                    }
                case '-': {
                    dResult = doSubtraction(dNumber1, getValidDouble(++iNumberCount));
                    break;
                    }
                case '*': {
                    dResult = doMultiplication(dNumber1, getValidDouble(++iNumberCount));
                    break;
                    }
                case '/': {
                    dResult = doDivision(dNumber1, getValidDouble(++iNumberCount));
                    break;
                    }
                default: {
                    System.out.println("Unknown operator"); /* Remind if no operator */
                    dResult=dNumber1;
                    break;
                    }
                }
            System.out.println("The Result is "+dResult);
            }
        while (dResult == 0);
        return dResult;
    }

    public static double getValidDouble(int iNumCount) {
        Scanner sInpStr = new Scanner(System.in);
        String sNumber;
        boolean boolIsNumeric;
        System.out.print("Input number no " + iNumCount + ":");
        do {
            boolIsNumeric = true;
            sNumber = sInpStr.nextLine();
            if (sNumber.isEmpty()) { /* if Empty string return 0 */
                return 0;
                }
            try {
                Double.parseDouble(sNumber);
                    }
                catch (NumberFormatException e){
                        System.out.println("Since when did " + sNumber + " become a number. Try again please");
                        boolIsNumeric = false;
                        }
                }
            while (!boolIsNumeric);
        return Double.parseDouble(sNumber);
    }

    public static double doAddition(double dNumber1, double dNumber2) {
        return dNumber1 + dNumber2;
        }

    public static double doSubtraction(double dNumber1, double dNumber2) {
        return dNumber1 - dNumber2;
        }

    public static double doMultiplication(double dNumber1, double dNumber2){
        return dNumber1 * dNumber2;
        }

    public static double doDivision(double dNumber1, double dNumber2) {
        if (dNumber2 != 0) {
            return dNumber1 / dNumber2;
            }
        else {
            System.out.println("Can't Divide with 0");
            }
        return dNumber1;
        }
}
