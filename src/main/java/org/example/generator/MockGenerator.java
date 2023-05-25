package org.example.generator;

import org.example.entity.Digits;
import org.example.annotation.NumberOfDigits;

import javax.enterprise.inject.Alternative;

@Alternative
@NumberOfDigits(value = Digits.THIRTEEN, odd = false)
public class MockGenerator implements NumberGenerator {
    @Override
    public String generateNumber() {
        return "MOCK";
    }
}
