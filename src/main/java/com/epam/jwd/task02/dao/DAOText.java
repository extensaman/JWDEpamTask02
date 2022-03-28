package com.epam.jwd.task02.dao;

public interface DAOText {
    String readText(String filePath) throws DAOTextException;
    void writeText(String filePath, String text) throws DAOTextException;
}
