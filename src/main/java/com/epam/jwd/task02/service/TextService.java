package com.epam.jwd.task02.service;

import com.epam.jwd.task02.entity.CompositeTextComponent;

public interface TextService {
    String readText(String filePath) throws TextServiceException;

    CompositeTextComponent parseText(String text);

    void writeText(String filePath, String text) throws TextServiceException;

    /**
     * TASK 9. Sort all the words of the text in ascending order of the number of the given letter in the word.
     * Arrange words with the same number of letters in alphabetical order.
     *
     * @param composite
     * @param letter
     * @return new instance of TextComponent, sorted by number of the <i>letter</i> in the word
     */
    CompositeTextComponent sortByGivenLetter(CompositeTextComponent composite, int letter);

    /**
     * TASK 12. Remove all words of a given length that begin with a consonant
     *
     * @param composite
     * @param length
     * @return new instance of TextComponent without words of <i>length</i> that begin with a consonant
     */
    CompositeTextComponent removeByGivenLengthAndBegunConsonant(CompositeTextComponent composite, int length);

    /**
     * TASK 7. Sort the words of the text in ascending proportion of vowels (ratio
     * number of vowels to the total number of letters in a word).
     *
     * @param composite
     * @return
     */
    CompositeTextComponent sortByVowelLetterProportion(CompositeTextComponent composite);

}
