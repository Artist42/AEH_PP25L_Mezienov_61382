package pl.pp;
import java.util.Scanner;

public class mojaSzostaAplikacja {

    static long factorial(long n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer number and I'll calculate a factorial \n Don't use more than 25 and without 0 - SAVE YOUR IMPORTANT WORK BEFORE LAUNCH: ");
        long number = scanner.nextLong();
        long startTime = System.nanoTime();
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result=result*i;
        }

        long endTime = System.nanoTime();
        System.out.println("Iterationally you get: " + result);
        System.out.println("Recurrently you get: " + factorial(number));
        long executionTime = (endTime - startTime);
        System.out.println("Counting all of that stuff took me " + executionTime + " nano seconds");
        scanner.close();
    }


    }






 /*
.
// Java Program to demonstrate use
// of System.nanoTime() method
import java.io.*;

// Driver class
public class ExecutionTimeExample {
    // main function
    public static void main(String[] args)
    {
        // Start measuring execution time
        long startTime = System.nanoTime();

        count_function(10000000);

        // Stop measuring execution time
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
        long executionTime
            = (endTime - startTime) / 1000000;

        System.out.println("Counting to 10000000 takes "
                           + executionTime + "ms");
    }

    // A dummy function that runs a loop x times
    public static void count_function(long x)
    {
        System.out.println("Loop starts");
        for (long i = 0; i < x; i++)
            ;
        System.out.println("Loop ends");
    }
}


  */