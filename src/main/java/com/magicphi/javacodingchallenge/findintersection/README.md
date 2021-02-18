# Find Out The Same Elements From Two Arrays

## Content

- [Question](#question)
- [Solution](#solution)
- [Core Implementation](#core-implementation)

## Question

There is an array of string stored in `strArr` and it contains two elements. One element is a string which represents a series of comma-separated numbers. The other is also a string which represents another series of comma-separated numbers. These numbers are all sorted in ascending order. Now, your mission is to find out those numbers existed in both two string elements, in other words, to find out an intersection of these two series of numbers, and put these numbers together in a comma-separated and ascending order in a string. If there is no qualified numbers you can find, then return a string "**false**".

**Example 1**:

Input: {"1, **6**, 7, **9**, 21, 22, **30**, **50**", "2, 3, **6**, 8, **9**, 10, 20, **30**, 40, **50**"}

Output: "6, 9, 30, 50"

**Example 2**:

Input: {"1, 6, 9", "5, 6, 7"}

Output: "6"

**Example 3**:

Input: {"2, 4, 6, 8", "1, 3, 5, 7"}

Output: "false"

## Solution

*I definitely sure that there must be some much more efficient solution to solve this problem. Discussion on performance is not the focus of this post.*

So let's simplify the issue a little bit. It sounds like to find one thing from another group of things.

![numbers_in_intersection](README.assets/numbers_in_intersection.png)

**Solution 1 - Java Stream API**

We can make use of `List.contains()` method to see whether the target set of number contains the tested number or not. To do so, we need the following steps:

- Convert two string elements to two lists of Integer
- Evaluate `List.contains(obj)` statement
- Output a comma-separated string as a result, if any. Otherwise, output "false".

**Note**:

The solution has a **performance issue** because the method `List.contains(obj)` will go to a comparison throughout the whole two sets of numbers. In the worst case, the comparison will go (N x M) times, which N is the size of one set of numbers and M represents the size of the other set of numbers. However, as we have already known that all numbers have been sorted in ascending order, we can alleviate dramatically the impact on performance by reducing the overhead of loop. For example, we may introduce the binary search algorithm to get rid of at least 50% effort on comparison.

Here, I'd like to leave this for you to optimize.

## Core Implementation

```java
//1. Convert two elements into two lists of numbers.
Stream<Integer> intList1 = Arrays.stream(strArr[0].split(","))
        .mapToInt((e) -> {return Integer.parseInt(e.trim());})
        .distinct().sorted().boxed();
List<Integer> intList2 = Arrays.stream(strArr[1].split(","))
        .mapToInt((e) -> {return Integer.parseInt(e.trim());})
        .distinct().sorted().boxed()
        .collect(Collectors.toList());

//2. Evaluate contains() statement.
StringBuilder sb = new StringBuilder();
intList1.filter(intList2::contains).forEach((str) -> {
    sb.append(str);
    sb.append(",");
});

//3. Output
if (sb.length() <= 0) {
    System.out.println("false");
} else {
    System.out.print(sb.deleteCharAt(sb.length() - 1).toString());
}
```
