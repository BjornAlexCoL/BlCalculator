package se.lexicon.java.g34.week2.bl;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExercises {
    public static void main(String[] args) {
        String[] menu = {"1.\tArray Exercise 1", "2.\tArray Exercise 2", "3.\tArray Exercise 3", "4.\tArray Exercise 4",
                "5.\tArray Exercise 5", "6.\tArray Exercise 6", "7.\tArray Exercise 7", "9.\tArray Exercise 9",
                "10.\tArray Exercise 10", "12.\tArray Exercise 12", "13.\tArray Exercise 13", "0.\tQuit"};
        Scanner inp = new Scanner(System.in);
        int menuInput;
        do {
            System.out.println("\nExercise Menu");
            for (String menuIndex : menu) {
                System.out.println(menuIndex);
            }
            System.out.print("What Exercise do you want to run?:");
            menuInput = inp.nextInt();
            switch (menuInput) {
                case 0: {
                    System.out.println("Thx for this time. Catch you later");
                    break;
                }
                case 1: {
                    exercise1();
                    break;
                }
                case 2: { //Exercise 2
                    int[] list = {1, 3, 5, 7, 11, 13};
                    exercise2(list);
                    break;
                }
                case 3: { //Exercise 3
                    String[] cities = {"Paris", "London", "New York", "Stockholm"};
                    exercise3(cities);
                    break;
                }
                case 4: { //Exercise 4
                    int[] numbers = {1, 15, 20};
                    exercise4(numbers);
                    break;
                }
                case 5: { //Exercise 5
                    String[] locations = {"France", "Paris", "Sweden", "Stockholm", "Denmark", "Copenhagen"};
                    exercise5(locations);
                    break;
                }
                case 6: {
                    int[] valueArray = {43, 5, 23, 17, 2, 14};
                    exercise6(valueArray);
                    break;
                }
                case 7: {//Excercise 7
                    int[] intArray = {1, 2, 4, 7, 9, 12};
                    exercise7(intArray);
                    break;
                }
                case 9: {
                    exercise9();
                    break;
                }
                case 10: { //Exercise 10
                    exercise10();
                    break;
                }
                case 12: {
                    exercise12();
                    break;
                }
                case 13: {
                    exercise13();
                    break;
                }
                default: {
                    break;
                }
            }
        }
        while (menuInput != 0);
    }


    /**
     * Write a program which will store elements in an array of type ‘int’ and print it out.
     * Expected output: 11 23 39 etc.
     */
    public static void exercise1() {
        int[] numbers = {11, 23, 39};

        for (int array : numbers) {
            System.out.print(array + " ");
        }
    }

    /* 2. Create a program and create a method with name
        ‘indexOf’ which will find and return the index
        of an element in the array. If the element does not
        exist your method should return -1 as value.
        Expected output: Index position of number 5 is: 2.
    */
    public static void exercise2(int[] list) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Input number to search for:");
        int iSearch = inp.nextInt();
        int index = indexOf(list, iSearch);
        if (index == -1) {
            System.out.println(iSearch + " does not exist in the list");
        } else {
            System.out.println("Index position of number " + iSearch + " is: " + index);
        }
    }

    public static int indexOf(int[] list, int find) {
        for (int index = 0; index < list.length; index++) {
            if (list[index] == find) {
                return index;
            }
        }
        return -1;
    }

    /*3. Write a program which will sort string array.
    Expected output: String array: [Paris, London, New York, Stockholm]
    Sort string array: [London, New York, Paris, Stockholm]*/
    public static void exercise3(String[] sortArray) {
        printStrings(sortArray, "String array", " [", ", ", "]");
        Arrays.sort(sortArray, String.CASE_INSENSITIVE_ORDER);
        printStrings(sortArray, "Sorted String array", " [", ", ", "]");
    }

    //Format output in Exercise 3
    public static void printStrings(String[] printArray, String label, String prefix, String seperator, String epifix) {
        System.out.print("\n" + label + prefix);
        int counter = 0;
        for (String index : printArray) {
            counter++;
            System.out.print(index);
            if (counter < printArray.length) {
                System.out.print(seperator);
            } else {
                System.out.print(epifix);
            }
        }
    }

    /* 4. Write a program which will copy the elements of one array into another array.
    Expected output: Elements from first array: 1 15 20
    Elements from second array: 1 15 20 */
    public static void exercise4(int[] numbers) {
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length);
        printInt(numbers, "Elements from first array:", " ", " ", "");
        printInt(copiedNumbers, "Elements from second array:", " ", " ", "");
    }

    public static void printInt(int[] printArray, String label, String prefix, String seperator, String epifix) {
        System.out.print("\n" + label + prefix);
        int counter = 0;
        for (int index : printArray) {
            counter++;
            System.out.print(index);
            if (counter < printArray.length) {
                System.out.print(seperator);
            } else {
                System.out.print(epifix);
            }
        }
    }


    /* 5. Create a two-dimensional string array [2][2].
        Assign values to the 2d array containing any Country and City.
        Expected output: France Paris
                         Sweden Stockholm*/
    public static void exercise5(String[] list) {
        String[][] locations = new String[list.length / 2][2];
        int listIndex = 0;
        for (String postValue : list) {
            locations[listIndex / 2][listIndex % 2] = postValue;
            listIndex++;
        }
        printStringArray(locations);
    }

    //print exercise5
    public static void printStringArray(String[][] printArray) {
        System.out.print("\n");
        for (String[] array : printArray) {
            int index = 1;
            for (String post : array) {
                System.out.print(post + " ");
                if (index == array.length) {
                    System.out.println();
                }
                index++;
            }
        }
    }

    /*6. Write a program which will set up an array to hold the next values in this
    order: 43, 5, 23, 17, 2, 14 and print the average of these 6 numbers.
    Expected output:
    Average is: 17.3*/
    public static void exercise6(int[] numbers) {
        int sum = totSum(numbers);//The sum of the numbers
        int average = sum / numbers.length;//The integerpart of the average
        int mod = sum * 10 / numbers.length % 10;//The decimal part we increase the sum with 10 for 1 decimal as we don't want to truncate it before getting the mod from it
        System.out.print("Average is: " + average + "." + mod);
    }

    public static int totSum(int[] numbers) {
        int sum = 0;
        for (int index : numbers) {
            sum += index;
        }
        return sum;
    }

    /*7. Write a program which will set up an array to hold 10 numbers and print
     out only the uneven numbers.
     Expected output:
     Array: 1 2 4 7 9 12
     Odd Array: 1 7 9*/
    public static void exercise7(int[] originalArray) {
        System.out.print("Array: ");
        printIntegers(originalArray);
        printOddIntegers(originalArray);
    }

    public static void printIntegers(int[] elementArray) {
        for (int element : elementArray) {
            System.out.print(element + " ");
        }
    }

    public static void printOddIntegers(int[] checkArray) {
        System.out.print("\nOdd Array: ");
        for (int index : checkArray) {
            if (index % 2 == 1) {
                System.out.print(index + " ");
            }
        }
    }

    /*9. Write a method which will add elements in an array.
    Remember that arrays are fixed in size so you need to come up with a
    solution to “expand” the array.*/
    public static void exercise9() {
        Scanner inp = new Scanner(System.in);
        String quitCheck;
        int[] elementArray = new int[0];
        int newElement;
        do {
            System.out.print("Elements in this Excercise are supposesed to be an integer. Please input element: ");
            newElement = getValidInt();//input a valid integer
            elementArray = addElement(elementArray, newElement);//Add the new element
            printElementArray(elementArray); //Show us what we got
            System.out.print("\nDo you want to stop entering elements?");
            quitCheck = inp.nextLine();
            if (quitCheck.isEmpty()) {
                quitCheck = "N";
                continue;
            }
            quitCheck = quitCheck.toLowerCase();
        }
        while (quitCheck.charAt(0) != 'y');
    }

    public static int getValidInt() {
        Scanner inp = new Scanner(System.in);
        String testValid;
        boolean isValid;
        do {
            isValid = true;
            testValid = inp.nextLine();
            if (testValid.isEmpty()) { /* if testValid is empty */
                System.out.println("How do you suppose I should work when not entering an integer? ");
                System.out.print("Try to input an Integer again, please:");
                isValid = false;
                continue;
            }
            try {//Check if it's and valid integer
                Integer.parseInt(testValid);
            } catch (NumberFormatException e) {
                System.out.println("Since when did " + testValid + " become an integer.");
                System.out.print("Try to input an Integer again, please:");
                isValid = false;
            }
        }
        while (!isValid);//loop until we get a valid integer.
        return Integer.parseInt(testValid);
    }

    public static int[] addElement(int[] oldArray, int element) {
        int[] newArray;
        newArray = Arrays.copyOf(oldArray, oldArray.length + 1);
        newArray[newArray.length - 1] = element;
        return newArray;
    }

    public static void printElementArray(int[] elementArray) {
        for (int element : elementArray) {
            System.out.print(element + "\t");
        }
    }

    /*10. Write a program which will represent multiplication table stored in
    multidimensional array.
    Hint: You have two-dimensional array with values
    [[1,2,3,4,5,6,7,8,9,10], [1,2,3,4,5,6,7,8,9,10]]*/
    public static void exercise10() {
        printEasyTable(16); //if we just want to have a table
        int[][] productMatris = assignProductMatris(10);//assign the two dimentional array
        printArrayTable(productMatris); //print it.
    }

    public static int[][] assignProductMatris(int size) {
        int[][] productMatris = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                productMatris[row][col] = (row + 1) * (col + 1);
            }
        }

        return productMatris;
    }

    public static void printArrayTable(int[][] productArray) {
        System.out.println();
        for (int[] row : productArray) {
            for (int col : row) {
                System.out.print(col);
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }

    public static void printEasyTable(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print(row * col);
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }

    /*12. Write a program which will print the diagonal elements of
    two-dimensional array.
    Expected output: 1 4 9
     */
    public static void exercise12() {

        int[][] sumMatris = assignProductMatris(3);//Reuse from exersize 10
        printArrayDiagonal(sumMatris); //print it.

    }

    public static void printArrayDiagonal(int[][] diagonalArray) {
        System.out.println("\n");
        for (int diagonal = 0; diagonal < diagonalArray.length; diagonal++) {
            System.out.print(diagonalArray[diagonal][diagonal] + "\t");
        }
    }

    /*13. Create two arrays with arbitrary size and fill one with random numbers.
    Then copy over the numbers from the array with random numbers so
    that the even numbers are located in the rear (the right side) part of the
    array and the odd numbers are located in the front part (the left side).*/
    public static void exercise13() {
        System.out.print("\nHow many random numbers do you want to work with?: ");
        int amount = getValidInt();
        System.out.print("\nWhat will be the highest value int the array?");
        int highValue = getValidInt();
        int[] randomArray = assignArrayWithRandoms(amount, highValue);
        int[][] sortedArray = oddEvenSortArray(randomArray);
        printArrayTable(sortedArray);
    }

    public static int[] assignArrayWithRandoms(int amount, int highValue) {
        int[] rndArray = new int[0];
        Random rnd = new Random();
        for (int index = 0; index < amount; index++) {
            rndArray = addElement(rndArray, rnd.nextInt(highValue) + 1);
            System.out.print(rndArray[index] + " ");
        }
        return rndArray;
    }

    public static int[][] oddEvenSortArray(int[] numList) {
        int[][] sortMatris = new int[2][];
        int[] evenArray=new int[0];
        int[] oddArray=new int[0];
        for (int number:numList) {
                if (number % 2 == 1) {
                    oddArray=addElement(oddArray, number);
                }
                else {
                    evenArray=addElement(evenArray, number);
                }
            }
        sortMatris[0]=Arrays.copyOf(oddArray,oddArray.length);
        sortMatris[1]=Arrays.copyOf(evenArray,evenArray.length);
        return sortMatris;
    }
}
