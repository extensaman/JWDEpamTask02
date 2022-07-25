package com.epam.jwd.task02.dao.impl;

import com.epam.jwd.task02.dao.DAOText;
import com.epam.jwd.task02.dao.DAOTextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DAOTextFileImpl implements DAOText {
    private static final Logger logger = LogManager.getLogger(DAOTextFileImpl.class);

    @Override
    public String readText(String filePath) throws DAOTextException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            while (reader.ready()) {
                builder.append((char) reader.read());
            }
        } catch (IOException e) {
            throw new DAOTextException(e);
        }
        logger.trace("Text reading from file '" + filePath + "' completed");
        return builder.toString();
    }

    @Override
    public void writeText(String filePath, String text) throws DAOTextException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {
            writer.write(text);
        } catch (IOException e) {
            throw new DAOTextException(e);
        }
        logger.trace("Text writting to file '" + filePath + "' completed");
    }
}
