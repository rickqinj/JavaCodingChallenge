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











## Core Implementation

### Get the height of the highest building

```java
int maxHeightOfBuilding = Arrays.stream(arr).max().getAsInt();
```

### Prepare Strings to represent the  status of each layer of the buildings

```java
for (int i = 0; i < maxHeightOfBuilding; i++) {
    for (int j = 0; j < numOfBuildings; j++) {
        String stuffChar = arr[i] > i ? "1" : " ";
        sb.append(stuffChar);
    }
    sb.append(",");
}
```

### Count available spaces

```java
rainfalls = 
    strs.stream().map(str -> str.trim())
                 .map(str -> str.chars().filter(c -> c==32).count())
                 .reduce(rainfalls, Long::sum);
```






