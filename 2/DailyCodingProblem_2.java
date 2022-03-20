package dailycodingproblem_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**[Hard]
 * Good morning! Here's your coding interview problem for today. This problem
 * was asked by Uber. Given an array of integers, return a new array such that
 * each element at index i of the new array is the product of all the numbers in
 * the original array except the one at i. For example, if our input was [1, 2,
 * 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input
 * was [3, 2, 1], the expected output would be [2, 3, 6]. Follow-up: what if you
 * can't use division?
 */
public class DailyCodingProblem_2 {
    public static void main(String[] args) {
        List<Long> array = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String userInput;
        System.out.print("Input first number: ");
        while (!(userInput = s.nextLine().trim()).equalsIgnoreCase("d")) {//Get user input and continue looping when user input is not "d".
            array.add(Long.parseUnsignedLong(userInput));
            System.out.print("Array: " + array.toString() + 
                    "\nInput next number(Enter d to end): ");
        }
        System.out.println("Array: " + array.toString() + 
                "\nThe result is: \nFuntion 1: " + Arrays.toString(function1(array.toArray(new Long[0]))) + 
                "\nFuntion 2: " + Arrays.toString(function2(array.toArray(new Long[0]))) + 
                "\nFuntion 3: " + Arrays.toString(function3(array.toArray(new Long[0]))));
    }
    public static Long[] function1(Long[] array){//The product of all numbers in the original array divided by the number at index i is the product of all numbers in the original array except at index i.
        Long[] result = new Long[array.length];
        Long temp=1L;
        for (Long i : array) {
            temp *= i;
        }
        for (int i = 0; i < array.length; i++) {
            result[i] = temp/array[i];
        }
        return result;
    }
    public static Long[] function2(Long[] array){//Avoiding division.
        Long[] result = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = 1L;
            for (int j = 0; j < array.length; j++) {//Multiply all numbers in the original array except the number at index i.
                if (i != j) {
                    result[i] *= array[j];
                }
            }
        }
        return result;
    }
    public static Long[] function3(Long[] array){//Avoid division, and optimize time complexity.
        Long[] result = new Long[array.length];
        Long[] temp = new Long[array.length];
        result[0] = 1L;
        temp[0] = 1L;
        for (int i = 1; i < array.length; i++) {
            //The variable result is the product of all the numbers in the 
            //original array whose index is less than i, and the variable temp 
            //is the product of all the numbers in the original array whose 
            //index is greater than the length of the original array minus i. 
            //Reversing the variable temp is the product of all the numbers in 
            //the original array with indices greater than i.
            result[i] = result[i-1]*array[i-1];
            temp[i] = temp[i-1]*array[array.length-i];
        }
        for(int i = 0; i < array.length; i++){
            //Multiply each digit of the variable result by each digit of the 
            //inverted variable temp in turn. This is equivalent to multiplying 
            //the product of all numbers with indices less than i in the 
            //original array by the product of all numbers with indices greater 
            //than i, which is the product of all numbers in the original array 
            //except for index i.
            result[i] *= temp[array.length-1-i];
        }
        return result;
    }
}
