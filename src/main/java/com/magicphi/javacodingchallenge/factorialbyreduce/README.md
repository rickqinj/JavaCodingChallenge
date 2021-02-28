# Do Factorial Calculation by Java Stream API

## Content

- [Question](#question)
- [Solution](#solution)
- [Core Implementation](#core-implementation)

## Question

There are several approaches to do a factorial calculation in Java.

## Solution

*I definitely sure that there must be some much more efficient solution to solve this problem. Discussion on performance is not the focus of this post.*

From my understanding and according to the description, it is a comparison and match question that asks you to look for the same abbreviation of a given word among those words in a dictionary. The pattern of the word abbreviation has already shown in the Question part.

Let's have the word "**mache**" for an example. The abbreviation of the word is "**m3e**", so words in the dictionary that comply with the pattern are all qualified candidates for the comparison. Of course there's no need to iterate all words in the dictionary. we just need to filter out all qualified words from the dictionary first. Actually, for this case we don't need to work out a pattern for your word, the only three factors we care about are:

- The **length** of the word
- **Initial letter** of the word
- **Last letter** of the word

The length of the word we entered is **5**, the initial letter is "**m**" and the last letter is "**e**", so in the dictionary the word "moose" is perfectly matched. Therefore, the result is "False" meaning that the abbreviation of the word "mache" is not unique in the dictionary.

## Core Implementation

```java
//case-insensitive evaluation.
String wordUpperCase = word.toUpperCase();
int lenOfWord = wordUpperCase.length();
String firstLetter = String.valueOf(wordUpperCase.charAt(0));
String lastLetter = String.valueOf(wordUpperCase.charAt(lenOfWord - 1));
Stream<String> stream = DICT.stream().filter((entry) -> {
    String dWord = entry.toUpperCase();
    return dWord.length() == lenOfWord 
           && dWord.startsWith(firstLetter)   
           && dWord.endsWith(lastLetter);
});
Optional<String> result = stream.findAny();
```

