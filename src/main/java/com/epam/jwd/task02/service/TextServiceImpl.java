package com.epam.jwd.task02.service;

import com.epam.jwd.task02.dao.DAOTextException;
import com.epam.jwd.task02.dao.DAOTextProvider;
import com.epam.jwd.task02.entity.CompositeTextComponent;
import com.epam.jwd.task02.entity.ElementaryTextComponent;
import com.epam.jwd.task02.service.parser.Parser;
import com.epam.jwd.task02.service.parser.ParserImpl;
import com.epam.jwd.task02.service.util.GivenLetterCountComparator;
import com.epam.jwd.task02.service.util.VowelLetterProportionComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Optional;

public class TextServiceImpl implements TextService {

    private static final Logger logger = LogManager.getLogger(TextServiceImpl.class);
    public static final String WORD_REGEX = "(?<= )";
    public static final String SENTENCE_REGEX = "(?<=[\\.\\?\\!]\\s)";
    public static final String PARAGRAPH_REGEX = "(?m)(?=^\\s{0})";
    public static final String BEGIN_FROM_CONSONANT_REGEX = "^[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ].+";

    @Override
    public String readText(String filePath) throws TextServiceException {
        String result = null;
        try {
            result = DAOTextProvider.getInstance()
                    .getDaoText()
                    .readText(Optional.ofNullable(filePath).orElseThrow());
        } catch (DAOTextException | NoSuchElementException e) {
            throw new TextServiceException(e);
        }
        return result;
    }

    @Override
    public CompositeTextComponent parseText(String text) {
        Parser parser = getParserChain();
        logger.trace("Parser's chain is formed");
        CompositeTextComponent components = parser.parse(text);
        logger.trace("Text is parsed");
        return components;
    }

    private Parser getParserChain() {
        Parser wordParser = new ParserImpl(WORD_REGEX);
        Parser sentenceParser = new ParserImpl(SENTENCE_REGEX, wordParser);
        Parser paragraphParser = new ParserImpl(PARAGRAPH_REGEX, sentenceParser);
        return paragraphParser;
    }

    @Override
    public void writeText(String filePath, String text) throws TextServiceException {
        try {
            text = Optional.ofNullable(text).orElseThrow();
            filePath = Optional.ofNullable(filePath).orElseThrow();
            DAOTextProvider.getInstance()
                    .getDaoText()
                    .writeText(filePath, text);
        } catch (DAOTextException | NoSuchElementException e) {
            throw new TextServiceException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompositeTextComponent sortByGivenLetter(CompositeTextComponent composite, int letter) {
        CompositeTextComponent newComposite = new CompositeTextComponent();
        Optional.ofNullable(composite)
                .ifPresent(c -> c.getListRepresentation()
                        .stream()
                        .sorted(new GivenLetterCountComparator(letter))
                        .forEach(s -> newComposite.addComponent(new ElementaryTextComponent(s))));
        logger.trace("Composite is sorted by count of letter '" + (char) letter + '\'');
        return newComposite;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompositeTextComponent removeByGivenLengthAndBegunConsonant(CompositeTextComponent composite, int length) {
        CompositeTextComponent newComposite = new CompositeTextComponent();
        Optional.ofNullable(composite)
                .ifPresent(c -> c.getListRepresentation()
                        .stream()
                        .filter(s -> !(s.length() == length && s.matches(BEGIN_FROM_CONSONANT_REGEX)))
                        .forEach(s -> newComposite.addComponent(new ElementaryTextComponent(s))));
        logger.trace("Removing all words of the length = " + length + " and that begin with a consonant is completed");
        return newComposite;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompositeTextComponent sortByVowelLetterProportion(CompositeTextComponent composite) {
        CompositeTextComponent newComposite = new CompositeTextComponent();
        Optional.of(composite).ifPresent(c -> c.getListRepresentation()
                .stream()
                .sorted(new VowelLetterProportionComparator())
                .forEach(s -> newComposite.addComponent(new ElementaryTextComponent(s))));
        logger.trace("Composite is sorted by ascending proportion of vowels in word");
        return newComposite;
    }
}
