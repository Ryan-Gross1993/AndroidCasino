package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */

public class PokerInputParser {
    String[] items;
    int[] results;
    public int[] parseUserInput(String input){
        items = input.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        results = new int[items.length];
        for (int i = 0; i < results.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                System.out.println(nfe);
            }
        }
        return results;
    }
//Thanks stack overflow
    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
}
