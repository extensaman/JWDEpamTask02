package com.epam.jwd.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextComponent implements TextComponent{
    private final List<TextComponent> components = new ArrayList<>();

    public void addComponent(TextComponent component) {
        components.add(component);
    }

    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public String getStringRepresentation() {
        StringBuilder builder = new StringBuilder();
        components.forEach(c -> builder.append(c.getStringRepresentation()));
        return builder.toString();
    }

    @Override
    public String getStringInBraceRepresentation() {
        StringBuilder builder = new StringBuilder();
        components.forEach(c -> builder.append(c.getStringInBraceRepresentation()));
        return builder.toString();
    }
}
