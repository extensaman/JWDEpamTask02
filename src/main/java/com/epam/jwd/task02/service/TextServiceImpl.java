package com.epam.jwd.task02.service;

import com.epam.jwd.task02.dao.DAOTextException;
import com.epam.jwd.task02.dao.DAOTextProvider;
import com.epam.jwd.task02.entity.CompositeTextComponent;
import com.epam.jwd.task02.service.parser.Parser;
import com.epam.jwd.task02.service.parser.ParserImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Optional;

public class TextServiceImpl implements TextService {

    private static final Logger logger = LogManager.getLogger(TextServiceImpl.class);
    public static final String WORD_REGEX = "(?<= )";
    public static final String SENTENCE_REGEX = "(?<=[\\.\\?\\!]\\s)";
    public static final String PARAGRAPH_REGEX = "(?m)(?=^\\s{0})";

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
}
