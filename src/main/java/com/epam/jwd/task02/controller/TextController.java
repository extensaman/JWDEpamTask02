package com.epam.jwd.task02.controller;

import com.epam.jwd.task02.entity.CompositeTextComponent;
import com.epam.jwd.task02.service.TextService;
import com.epam.jwd.task02.service.TextServiceException;
import com.epam.jwd.task02.service.TextServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextController {
    private static final Logger logger = LogManager.getLogger(TextController.class);
    public static final String INPUT_FILE_PATH = "input_text.txt";
    public static final String OUTPUT_FILE_PATH = "output_restored_text.txt";
    public static final String OUTPUT_WITH_BRACE_FILE_PATH = "output_restored_text(with_braces).txt";
    public static final String OUTPUT_SORTED_BY_GIVEN_LETTER_FILE_PATH = "output_text_sorted_by_given_letter.txt";
    public static final String OUTPUT_REMOVE_BY_GIVEN_LENGTH_AND_BEGUN_CONSONANT_FILE_PATH =
            "output_text_remove_by_given_length_and_begun_consonant.txt";
    public static final String OUTPUT_SORT_BY_VOWEL_LETTER_PROPORTION_FILE_PATH =
            "output_text_sort_by_vowel_letter_proportion.txt";
    public static final char GIVEN_LETTER = 'f';
    public static final int GIVEN_LENGTH = 4;

    private static class SingletonHolder {
        private static final TextController INSTANCE = new TextController();

        public static TextController getInstance() {
            return INSTANCE;
        }
    }

    private TextController() {
    }

    public static TextController getInstance() {
        return SingletonHolder.getInstance();
    }

    public void execute() {
        TextService service = TextServiceProvider.getInstance().getTextService();

        // Read original text from file
        String originalText = null;
        try {
            originalText = service.readText(INPUT_FILE_PATH);
        } catch (TextServiceException e) {
            logger.error("Exception in service.readText()", e);
            return;
        }

        // Parse text to composite component
        CompositeTextComponent composite = service.parseText(originalText);

        // Write composite string representation (with braces) to file
        try {
            service.writeText(OUTPUT_WITH_BRACE_FILE_PATH, composite.getStringInBraceRepresentation());
        } catch (TextServiceException e) {
            logger.error("Exception in service.writeText()", e);
            return;
        }

        // Compare original text and composite string representation
        if (originalText.equals(composite.getStringRepresentation())) {
            logger.trace("Original text and composite string representation are equal");
        } else {
            logger.trace("Original text and composite string representation are NOT equal");
        }

        // Write composite string representation to file
        try {
            service.writeText(OUTPUT_FILE_PATH, composite.getStringRepresentation());
        } catch (TextServiceException e) {
            logger.error("Exception in service.writeText()", e);
            return;
        }

        // TASK 9. Sort all the words of the text in ascending order of the number of the given letter in the word.
        // Arrange words with the same number of letters in alphabetical order.
        CompositeTextComponent sortedByLetterComposite = service.sortByGivenLetter(composite, GIVEN_LETTER);

        // Write 'sortedByLetterComposite' to file
        try {
            service.writeText(OUTPUT_SORTED_BY_GIVEN_LETTER_FILE_PATH, sortedByLetterComposite.getStringInBraceRepresentation());
        } catch (TextServiceException e) {
            logger.error("Exception in service.writeText()", e);
            return;
        }

        // TASK 12. Remove all words of a given length that begin with a consonant
        CompositeTextComponent removedByGivenLengthAndBegunConsonantComposite =
                service.removeByGivenLengthAndBegunConsonant(composite, GIVEN_LENGTH);

        // Write 'removedByGivenLengthAndBegunConsonantComposite' to file
        try {
            service.writeText(OUTPUT_REMOVE_BY_GIVEN_LENGTH_AND_BEGUN_CONSONANT_FILE_PATH,
                    removedByGivenLengthAndBegunConsonantComposite.getStringInBraceRepresentation());
        } catch (TextServiceException e) {
            logger.error("Exception in service.writeText()", e);
            return;
        }

        // TASK 7. Sort the words of the text in ascending proportion of vowels (ratio
        // number of vowels to the total number of letters in a word).
        CompositeTextComponent sortedByVowelLetterProportionComposite =
                service.sortByVowelLetterProportion(composite);

        // Write 'sortedByVowelLetterProportionComposite' to file
        try {
            service.writeText(OUTPUT_SORT_BY_VOWEL_LETTER_PROPORTION_FILE_PATH,
                    sortedByVowelLetterProportionComposite.getStringInBraceRepresentation());
        } catch (TextServiceException e) {
            logger.error("Exception in service.writeText()", e);
            return;
        }
    }


}
