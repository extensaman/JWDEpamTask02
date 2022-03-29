package com.epam.jwd.task02;

import com.epam.jwd.task02.controller.TextController;

/**
 * Information handling
 * Develop an application that parses and processes text.
 * <p>
 * You need to create an application that parses text from a programming textbook from a file
 * and allowing you to perform three different operations on text.
 * <p>
 * General requirements for the project:
 * - The parsed text should be represented as an object (text) containing,
 * for example, sentences and code blocks, a sentence can contain the words of the sentence.
 * - The words of a sentence (parts of a sentence) can be, for example, simple words and
 * punctuation marks. These classes are entity classes and should not be
 * overloaded with logic methods.
 * - The parsed text must be restored in its original form, for
 * excluding spaces between elements. Spaces and tabs in parsing can
 * replaced with a single space.
 * - To divide the text into sentences and other components, use
 * regular expressions. Don't forget that application regular expressions are
 * literal constants.
 * - The code that breaks the text into its component parts should be developed in
 * the form of parser classes.
 * - When developing parsers that parse text, you need to keep track of the number of
 * created parser objects.
 * - When implementing a task, you can use such programming patterns as Composite and Chain of
 * Responsibility.
 * - When handling exceptions, the application must use
 * logger Log4j.
 * - The created application should allow the implementation of a group of tasks for working on
 * text (tasks are given below) without “rewriting” existing code.
 * <p>
 * 1. Find the largest number of text sentences that have the same
 * words.
 * 2. Display all sentences of the given text in ascending order
 * the number of words in each.
 * 3. Find a word in the first sentence that is not in any of the others
 * offers.
 * 4. In all interrogative sentences of the text, find and print without repetition
 * words of a given length.
 * 5. In each sentence of the text, swap the first word with the last, do not
 * changing the length of the sentence.
 * 6. Type the words of the text in alphabetical order first
 * letter. Words beginning with a new letter should be printed in red.
 * 7. Sort the words of the text in ascending proportion of vowels (ratio
 * number of vowels to the total number of letters in a word).
 * 8. Sort the words of the text starting with vowels in alphabetical order by
 * the first consonant of the word.
 * 9. Sort all the words of the text in ascending order of the number of the given letter in the word.
 * Arrange words with the same number of letters in alphabetical order.
 * 10. There is a text and a list of words. For each word from the given list find,
 * how many times it occurs in each sentence, and sort the words by
 * descending total number of occurrences.
 * 11. In each sentence of the text, exclude a substring of the maximum length,
 * starting and ending with the given characters.
 * 12. Remove all words of a given length that begin with a consonant.
 * 13. Sort the words in the text in descending order of the number of occurrences of a given
 * symbol, and in case of equality - alphabetically.
 * 14. In the given text, find a substring of maximum length that is
 * palindrome, i.e. read from left to right and from right to left the same.
 * 15. Convert each word in the text, removing all subsequent ones from it
 * (previous) occurrences of the first (last) letter of this word.
 * 16. In some sentence of the text, words of a given length are replaced by the specified
 * a substring whose length may not match the length of the word.
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {
    public static void main(String[] args) {
        TextController.getInstance().execute();
    }
}
