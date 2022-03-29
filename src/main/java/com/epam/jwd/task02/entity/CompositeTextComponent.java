package com.epam.jwd.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextComponent implements TextComponent {
    private final List<TextComponent> components = new ArrayList<>();

    public void addComponent(TextComponent component) {
        components.add(component);
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

    @Override
    public List<String> getListRepresentation() {
        List<String> list = new ArrayList<>();
        components.stream().map(TextComponent::getListRepresentation).forEach(list::addAll);
        return list;
    }
}
