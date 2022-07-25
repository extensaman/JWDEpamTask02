package com.epam.jwd.task02.dao;

import com.epam.jwd.task02.dao.impl.DAOTextFileImpl;

public class DAOTextProvider {
    private static final DAOTextProvider INSTANCE = new DAOTextProvider();

    private DAOTextProvider() {
    }

    public static DAOTextProvider getInstance() {
        return INSTANCE;
    }

    private final DAOText daoText = new DAOTextFileImpl();

    public DAOText getDaoText() {
        return daoText;
    }
}
