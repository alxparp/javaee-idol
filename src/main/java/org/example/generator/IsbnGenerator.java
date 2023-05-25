package org.example.generator;

import org.example.entity.Digits;
import org.example.annotation.NumberOfDigits;

import java.util.Random;

@NumberOfDigits(value = Digits.THIRTEEN, odd = false)
public class IsbnGenerator implements NumberGenerator {


    @Override
    public String generateNumber() {
        return "13-84356-" + Math.abs(new Random().nextInt());
    }
}
