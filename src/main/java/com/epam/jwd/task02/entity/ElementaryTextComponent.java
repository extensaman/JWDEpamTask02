package com.epam.jwd.task02.entity;

import java.util.Collections;
import java.util.List;

public class ElementaryTextComponent implements TextComponent {
    private final String component;

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

    @Override
    public List<String> getListRepresentation() {
        return Collections.singletonList(component);
    }
}
