package com.epam.jwd.task02.service.parser;

import com.epam.jwd.task02.entity.CompositeTextComponent;

public interface Parser {
    CompositeTextComponent parse(String text);
}
