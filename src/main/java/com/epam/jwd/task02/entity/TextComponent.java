package com.epam.jwd.task02.entity;

import java.util.List;

public interface TextComponent {
    String getStringRepresentation();

    String getStringInBraceRepresentation();

    List<String> getListRepresentation();
}
