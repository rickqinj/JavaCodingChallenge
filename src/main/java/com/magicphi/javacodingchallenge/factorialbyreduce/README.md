# Factorial Calculation in Java

## Content

- [Question](#question)
- [Solution](#solution)
- [Core Implementation](#core-implementation)

## Question

Giving a whole number, you are going to implement the factorial calculation of it in Java.

## Solution

*I definitely sure that there must be some much more efficient solution to solve this problem. Discussion on performance is not the focus of this post.*

As we all know, the Factorial Calculation formula looks as follows: `f(n) = n * f(n - 1)`. 

For example, `3! = 3 * (3 - 1)! = 3 * 2 * (2 - 1)! = 3 * 2 * 1 = 6`.

If you are no stranger to *[Recursion](https://introcs.cs.princeton.edu/java/23recursion/)* functionality in a programming language, you must be not surprising to find out that we can make use of the *Recursion* to carry out the Factorial calculation. 

However, there's still yet another solution to implement the calculation.

Since `4! = 4 * 3 * 2 * 1` or `1 * 2 * 3 * 4`,  we can go for the loop structure to implement the calculation.

### Sol-1

Let's go for the most straightforward way, **Loop structure**, first.

```java
public static long getFactorial(long num) {
    long result = 1;
    for (int i = 1; i <= num; i++) {
        result *= i;
    }
    return result;
}
```

**Note that**, the above code has a big problem that the method cannot calculate the factorial of the whole number which is greater than 20. It is because the Long variable length is not enough to hold such big numbers as a result. For solving the problem, we may take advantage of the datatype `BigInteger` instead.

### Sol-2

Let's go to the *Recursion* as the second solution. This approach is a little bit mind-twisting and risky as you have to make sure that there must be a return statement which will end the recursive method calling finally. Otherwise, you may be stuck in the endless recursive calling and run into a stack overflow error at last. Let's see the implementation shown as below.

```java
public static long getFactorial(long num) {
    if (1 == n) {
        return 1;
    }
    return n * getFactorial(n-1); 
}
```

The approach has also the over-length problem that I mentioned in Sol-1.

### Sol-3

Let's have a look at the third solution. Personally speaking, I wouldn't like to say this is a solution totally different to the second one. The solution is a variant of the **Sol-1** which is by using Stream APIs to shorten the recursion code. Let's see how it works.

```java
public static long getFactorial(long num) {
    return LongStream.rangeClosed(1, num)
                     .reduce(1, (long a, long b) -> a * b);
}
```

The method `rangeClosed(1, num)` is to generate a series whole integers  from 1 to `num`.  Then the method `reduce(1, (long a, long b) -> a * b)` is to do the calculation of "1 x 2 x 3 x...x `num`".

