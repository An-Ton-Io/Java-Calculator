import java.util.Scanner;

public class JavaCalculator
{
    public static void main(String [] args)
    {
        intro();
        Scanner kb = new Scanner(System.in);
        boolean infiniteCalculations = true;

        while (infiniteCalculations)
        {
            System.out.print("Enter an Operation (+, -, *, /, or exit): ");
            String Operation = (kb.nextLine());

            if (Operation.equalsIgnoreCase("exit"))
            {
                infiniteCalculations = false;
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
                break;
            }

            System.out.print("Enter the first number: ");
            double firstNum = (kb.nextDouble());

            if (Operation.equals("/") && firstNum == 0)
            {
                System.out.println("Error: Division by zero is not allowed.");
                continue;
            }

            System.out.print("Enter the second number: ");
            double secondNum = kb.nextDouble();

            double result = performOperation(Operation, firstNum, secondNum);
            System.out.println("The result of " + firstNum + " " + Operation + " " + secondNum + " = " + result);

            kb.nextLine(); // Consume the newLine character after reading the second number

            System.out.print("Would you like to perform another Operation (yes/no)? ");
            String answer = kb.nextLine();
            if (!answer.equalsIgnoreCase("yes"))
            {
                infiniteCalculations = false;
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
            }
        }
    }

    public static void intro()
    {
        System.out.println("Welcome to the Java Calculator!");
    }

    public static double performOperation(String Operation, double a, double b)
    {
        switch (Operation)
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                System.out.println("Invalid Operation. Please enter +, -, *, /, or exit.");
                return Double.NaN; // Return NaN for non-existent operations
        }
    }
}