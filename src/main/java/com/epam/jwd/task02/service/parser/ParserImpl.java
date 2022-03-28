package com.epam.jwd.task02.service.parser;

import com.epam.jwd.task02.entity.CompositeTextComponent;
import com.epam.jwd.task02.entity.ElementaryTextComponent;

public class ParserImpl implements Parser {
    private final String regex;
    private final Parser nextParser;

    public ParserImpl(String regex, Parser nextParser) {
        this.regex = regex;
        this.nextParser = nextParser;
    }

    public ParserImpl(String regex) {
        this.regex = regex;
        this.nextParser = null;
    }

    @Override
    public CompositeTextComponent parse(String text) {
        CompositeTextComponent components = new CompositeTextComponent();

        for (String element : text.split(regex)) {
            if (nextParser == null) {
                components.addComponent(new ElementaryTextComponent(element));
            } else {
                components.addComponent(nextParser.parse(element));
            }
        }
        return components;
    }
}
