package com.epam.jwd.task02.service.util;

import java.util.Comparator;

public class GivenLetterCountComparator implements Comparator<String> {
    private final int letter;

    public GivenLetterCountComparator(int letter) {
        this.letter = letter;
    }

    @Override
    public int compare(String element1, String element2) {
        long letterCount1 = element1.chars().filter(ch -> ch == letter).count();
        long letterCount2 = element2.chars().filter(ch -> ch == letter).count();
        int result = (int) (letterCount1 - letterCount2);
        if (result == 0) {
            result = element1.compareTo(element2);
        }
        return result;
    }
}
