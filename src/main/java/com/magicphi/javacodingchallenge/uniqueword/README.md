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
"mache"    --> false  //Not unique, same as "moose"
"madame"   --> true
"scan"     --> false  //Not unique, same as "swan"
"salon"    --> true
"dig"      --> false  //Not unique, same as "dog"
"ding"     --> true
```

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

