package com.epam.jwd.task02.service;

import com.epam.jwd.task02.entity.CompositeTextComponent;

import java.util.function.Supplier;

public interface TextService {
    String readText(String filePath) throws TextServiceException;
    CompositeTextComponent parseText(String text);
    void writeText(String filePath, String text) throws TextServiceException;
}
