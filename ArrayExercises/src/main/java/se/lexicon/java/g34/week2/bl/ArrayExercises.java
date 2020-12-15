package se.lexicon.java.g34.week2.bl;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercises {
    public static void main(String[] args) {
        String[] menu = {"1. Exercise 1", "2. Exercise 2", "3. Exercise 3", "4. Exercise 4",
                "5. Exercise 5", "0. Quit"};
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
        Scanner inp=new Scanner(System.in);
        System.out.print("Input number to search for:");
        int iSearch = inp.nextInt();
        int index = indexOf(list, iSearch);
        if (index == -1) {
            System.out.println(iSearch + " does not exist in the list");
            }
            else {
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
            locations[listIndex/2][listIndex % 2] = postValue;
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

}





