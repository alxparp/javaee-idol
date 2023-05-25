package org.example.producer;

import org.example.annotation.EightDigits;
import org.example.annotation.Random;
import org.example.annotation.ThirteenDigits;

import javax.enterprise.inject.Produces;

public class NumberProducer {
    @Produces
    @EightDigits
    private String prefix13digits = "8-";

    @Produces
    @EightDigits
    private int editorNumber = 84356;

    @Produces
    @Random
    public double random() {
        return Math.abs(new java.util.Random().nextInt());
    }
}
