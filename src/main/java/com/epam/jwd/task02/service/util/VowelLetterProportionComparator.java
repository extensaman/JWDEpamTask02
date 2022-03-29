package com.epam.jwd.task02.service.util;

import java.util.Comparator;

public class VowelLetterProportionComparator implements Comparator<String> {
    @Override
    public int compare(String element1, String element2) {
        long vowelCount1 = element1.chars().filter(this::isVowel).count();
        long vowelCount2 = element2.chars().filter(this::isVowel).count();
        return Double.compare(vowelCount1 / (double) element1.length(), vowelCount2 / (double) element2.length());
    }

    private boolean isVowel(int ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                return true;
            default:
                return false;
        }
    }
}
