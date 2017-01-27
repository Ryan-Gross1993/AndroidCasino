package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class Main {
    public static void main(String[] args) {
        Casino init = new Casino();
        UserIO initIO = new UserIO();
        init.play(initIO);
    }
}
