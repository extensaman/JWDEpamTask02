package com.epam.jwd.task02.entity;

public class ElementaryTextComponent implements TextComponent{
    private String component;

    public ElementaryTextComponent(String component) {
        this.component = component;
    }

    @Override
    public String getStringRepresentation() {
        return component;
    }

    @Override
    public String getStringInBraceRepresentation() {
        return '{' + component + '}';
    }
}
