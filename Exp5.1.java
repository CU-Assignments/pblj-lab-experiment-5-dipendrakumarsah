import java.util.ArrayList;
import java.util.List;

public class SumCalculator {

    public static Integer parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str); 
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + str);  
            return null;
        }
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            if (number != null) {
                sum += number;  
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        
        List<Integer> numbers = new ArrayList<>();
        
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Parsing strings and adding them to the list
        numbers.add(parseStringToInteger("40"));
        numbers.add(parseStringToInteger("50"));

        // Calculating the sum of the list
        int sum = calculateSum(numbers);
        System.out.println("The sum of the list is: " + sum);

        // Test case with strings only
        List<Integer> stringParsedNumbers = new ArrayList<>();
        stringParsedNumbers.add(parseStringToInteger("100"));
        stringParsedNumbers.add(parseStringToInteger("200"));
        stringParsedNumbers.add(parseStringToInteger("300"));
        
        sum = calculateSum(stringParsedNumbers);
        System.out.println("The sum of the list is: " + sum);

        // Test case with invalid input
        List<Integer> invalidInputTest = new ArrayList<>();
        invalidInputTest.add(parseStringToInteger("50"));
        invalidInputTest.add(parseStringToInteger("invalid"));
        invalidInputTest.add(parseStringToInteger("70"));
        
        sum = calculateSum(invalidInputTest);
        System.out.println("The sum of the list is: " + sum);
    }
}


//OUTPUT

Test Cases:

Test Case 1:
Input: 10, 20, 30, "40", "50"
Expected Output: The sum of the list is: 150
Description: The list contains a mix of primitive integers and integers parsed from strings.

Test Case 2:
Input: "100", "200", "300"
Expected Output: The sum of the list is: 600
Description: All values are parsed from strings, and the sum is calculated.

Test Case 3:
Input: "50", "invalid", "70"
Expected Output:
Invalid number format: invalid
The sum of the list is: 120
Description: One of the inputs is not a valid integer, so it's skipped, and the sum of valid values is calculated.
