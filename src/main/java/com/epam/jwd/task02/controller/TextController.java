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
    public static final String OUTPUT_FILE_PATH = "output_text.txt";
    public static final String OUTPUT_WITH_BRACE_FILE_PATH = "output_text(with_braces).txt";

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

    }


}
