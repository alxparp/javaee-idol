package org.example.generator;

import org.example.annotation.NumberOfDigits;
import org.example.entity.Digits;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class FromEightToThirteenDigitsDecorator implements NumberGenerator {

    @Inject
    @Delegate
    @NumberOfDigits(value = Digits.EIGHT, odd = false)
    private NumberGenerator numberGenerator;

    @Override
    public String generateNumber() {
        String issn = numberGenerator.generateNumber();
        String isbn = "13-84356" + issn.substring(1);
        return isbn;
    }
}
