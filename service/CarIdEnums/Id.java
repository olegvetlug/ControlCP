package ru.synergyIT.service.CarIdEnums;

import java.util.Random;

public enum Id {
    zero, one, two, three, four, five, six, eight, nine;

    public static String getRandomNum() {
        Id[] values = Id.values ();
        int length = values.length;
        int randIndex = new Random ().nextInt ( length );
        return String.valueOf ( randIndex );
    }
}
