package assignments.algorithms;

public class Fibonacci {
    /**
     * Compute Fibonacci numbers.
     */

    public static int fibonacci(int n)
    {
        if(n == 1) return 1;

        int last = 1;
        int nextToLast = 1;
        int answer = 1;

        for(int i = 2; i <= n; i++)
        {
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }

        return answer;


    }
    //This is my recursion from the book
    public static long fib(int n)
    {
        if(n <= 1) return 1;
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }
    //This is Binots formula.
    public static long Binots(int n)
    {
        double sqrt5 = Math.sqrt(5);
        double x = (1 + sqrt5) / 2;
        double y = (1 - sqrt5) / 2;

        double result = (Math.pow(x,n) - Math.pow(y,n)) / sqrt5;

        return Math.round(result);
    }


    //my main

    public static void main(String[] args) 
    {
        for(int n = 1; n <= 100; n++)
        {
            long start = System.nanoTime();
            fib(n);
            long end = System.nanoTime();
            double duration = (end - start) / 1e9;
            System.out.println(n + "\t" + duration);

        }
        
    }


}
