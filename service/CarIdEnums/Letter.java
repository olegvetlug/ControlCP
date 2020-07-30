package ru.synergyIT.service.CarIdEnums;

import java.util.Random;

public enum Letter {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    public static String getRandomLetter() {
        Letter[] values = Letter.values ();
        int length = values.length;
        int randIndex = new Random ().nextInt ( length );
        return String.valueOf ( values[randIndex] );
    }
}
