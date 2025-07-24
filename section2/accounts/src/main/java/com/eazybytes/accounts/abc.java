package com.eazybytes.accounts;

public class abc {

    public static void main(String[] args) {
        int i = 10;

        for (int idx = 0; idx < i; idx++) {
            System.out.println("Index: " + idx);
        }
    }


    public void test() {
        System.out.println("Test method in abc class");
    }

    public void anotherTest() {
        System.out.println("Another test method in abc class");
    }

    public void yetAnotherTest() {
        System.out.println("Yet another test method in abc class");
    }


    // generate method printing numbers from 1 to 9 with documentation in form of Javadoc comments

    /**
     * Calculates the sum of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n the number to calculate the factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Checks if a given number is prime.
     *
     * @param n the number to check
     * @return true if n is prime, false otherwise
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the GCD of a and b
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param arr the array to sort
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
