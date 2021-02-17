# Determine Whether the Word Is Unique in Ditionary

## Content

- [Question](#question)
- [Solution](#solution)
- [Core Implementation](#core-implementation)

## Question

Every English word can be shortened as the pattern like **a letter plus a positive integer and a letter**. For example, the word "**internationalization**" can be shortened as "**i18n**". Let's call "i18n" is an abbreviation form of the word "internationalization". 

Now, let's assume that we have a dictionary which is full of English words. And you will be determining whether the abbreviation of a word given to you is unique among those word entries in the dictionary.

Example:

Given dictionary {"**elephant**", "**donkey**", "**moose**", "**swan**",  "**dog**"}, the test result will be the following:

```plain
"emergent" --> false  //Not unique, same as "elephant". "elephant" is "e6t", the same as "emergent".
"earhart"  --> true
"damply"   --> false  //Not unique, same as "donkey"
"deanery"  --> true
"macle"    --> false  //Not unique, same as "moose"
"madame"   --> true
"scan"     --> false  //Not unique, same as "swan"
"salon"    --> true
"dig"      --> false  //Not unique, same as "dog"
"ding"     --> true
```

## Solution

*I definitely sure that there must be some much more efficient solution to solve this problem. Discussion on performance is not the focus of this post.*

I would love to go for a VISUAL COUNTING (not really) solution to solve this riddle. Beforehand, let's re-draw the above picture with 1 and a space character, and put them all into a matrix.

![Snipaste_2021-02-12_13-15-31](README.assets/Snipaste_2021-02-12_13-15-31.png)

I will give you an explain later why a space is used here to fill up the blanks in the matrix.

Okay, now here's the five strings we can get from the matrix:

![Snipaste_2021-02-12_14-43-10](README.assets/Snipaste_2021-02-12_14-43-10.png)

We can easily find out the amout of all spaces marked in **BLUE** is the answer to this problem. Let's look back the reason why I used spaces to fill up the blanks. It just because I can get rid of all spaces in **RED** easily by calling the String's `trim()` method.

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






