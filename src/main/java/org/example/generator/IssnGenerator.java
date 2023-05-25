package org.example.generator;

import org.example.annotation.EightDigits;
import org.example.annotation.ThirteenDigits;
import org.example.entity.Digits;
import org.example.annotation.NumberOfDigits;

import javax.inject.Inject;
import java.util.Random;

@NumberOfDigits(value = Digits.EIGHT, odd = false)
public class IssnGenerator implements NumberGenerator {
    @Inject
    @EightDigits
    private String prefix;

    @Inject
    @EightDigits
    private int editorNumber;

    @Inject
    @org.example.annotation.Random
    private double postfix;

    @Override
    public String generateNumber() {

        return prefix + editorNumber + postfix;
    }
}
