package com.epam.jwd.task02.service;

public class TextServiceProvider {
    private final TextService textService;

    public TextServiceProvider() {
        textService = new TextServiceImpl();
    }

    private static class SingletonHolder {
        private static final TextServiceProvider INSTANCE = new TextServiceProvider();

        public static TextServiceProvider getInstance() {
            return INSTANCE;
        }
    }

    public static TextServiceProvider getInstance() {
        return SingletonHolder.getInstance();
    }

    public TextService getTextService() {
        return textService;
    }
}
