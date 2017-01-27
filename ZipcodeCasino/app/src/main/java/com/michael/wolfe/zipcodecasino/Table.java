package com.michael.wolfe.zipcodecasino;

/**
 * Created by Wolfe on 1/26/2017.
 */
import java.util.HashMap;
import java.util.Map;

public class Table {
    private Map<Integer, String> numbers;

    Table() {
        numbers = new HashMap<>();
        constructNumbers();
    }

    private void constructNumbers() {

        for (int i = 0; i < 38; i++) {
            if (i == 37) {
                numbers.put(i, "00");
            } else {
                numbers.put(i, Integer.toString(i));
            }
        }
    }

    String getNumber(Integer key) {
        return numbers.get(key);
    }

    void showTable() {
        System.out.println("" +
                "              _______     _____\n" +
                "             /       \\   /     \\\n" +
                "            /         \\ /       \\\n" +
                "            |    0     |    ∞    |\n" +
                "            |          |         |\n" +
                "----------------------------------\n" +
                "|     |     |      |      |      |\n" +
                "|  1  |     |   1  |   2  |   3  |\n" +
                "|  |  |     |      |      |      |\n" +
                "|  1  |     ----------------------\n" +
                "|  8  |  1  |      |      |      |\n" +
                "|     |  S  |   4  |   5  |   6  |\n" +
                "|     |  T  |      |      |      |\n" +
                "-------     ----------------------\n" +
                "|     |  1  |      |      |      |\n" +
                "|  E  |  2  |   7  |   8  |   9  |\n" +
                "|  V  |     |      |      |      |\n" +
                "|  E  |     ----------------------\n" +
                "|  N  |     |      |      |      |\n" +
                "|     |     |  10  |  11  |  12  |\n" +
                "|     |     |      |      |      |\n" +
                "----------------------------------\n" +
                "|     |     |      |      |      |\n" +
                "|     |     |  13  |  14  |  15  |\n" +
                "|  R  |     |      |      |      |\n" +
                "|  E  |     ----------------------\n" +
                "|  D  |  2  |      |      |      |\n" +
                "|     |  N  |  16  |  17  |  18  |\n" +
                "|     |  D  |      |      |      |\n" +
                "-------     ----------------------\n" +
                "|     |  1  |      |      |      |\n" +
                "|  B  |  2  |  19  |  20  |  21  |\n" +
                "|  L  |     |      |      |      |\n" +
                "|  A  |     ----------------------\n" +
                "|  C  |     |      |      |      |\n" +
                "|  K  |     |  22  |  23  |  24  |\n" +
                "|     |     |      |      |      |\n" +
                "----------------------------------\n" +
                "|     |     |      |      |      |\n" +
                "|     |     |  25  |  26  |  27  |\n" +
                "|  O  |     |      |      |      |\n" +
                "|  D  |     ----------------------\n" +
                "|  D  |  3  |      |      |      |\n" +
                "|     |  R  |  28  |  29  |  30  |\n" +
                "|     |  D  |      |      |      |\n" +
                "-------     ----------------------\n" +
                "|     |  1  |      |      |      |\n" +
                "|  1  |  2  |  31  |  32  |  33  |\n" +
                "|  9  |     |      |      |      |\n" +
                "|  |  |     ----------------------\n" +
                "|  3  |     |      |      |      |\n" +
                "|  6  |     |  34  |  35  |  36  |\n" +
                "|     |     |      |      |      |\n" +
                "----------------------------------\n" +
                "            |      |      |      |\n" +
                "            |  2-1 |  2-1 |  2-1 |\n" +
                "            |      |      |      |\n" +
                "            ----------------------\n");
    }

    void showTableWithHelp() {
        System.out.println("" +
                "              _______     _____\n" +
                "             /       \\   /     \\\n" +
                "            /         \\ /       \\\n" +
                "            |    0     L    ∞    |\n" +
                "            |          |         |\n" +
                "----------- J --------------------\n" +
                "|     |     |      |      |      |\n" +
                "|  1  |     |   1  |   2  |   A  |\n" +
                "|  |  |     |      |      |      |\n" +
                "E  1  |     ----------------------\n" +
                "|  8  |  1  |      |      |      |\n" +
                "|     |  S  |   4  |   5  |   6  |\n" +
                "|     |  T  |      |      |      |\n" +
                "-------     ----------------------\n" +
                "|     |  1  |      |      |      |\n" +
                "|  E  |  2  |   7  |   8  |   9  |\n" +
                "|  V  |     |      |      |      |\n" +
                "F  E  |     ----------------------\n" +
                "|  N  |     |      |      |      |\n" +
                "|     |  C  |  10  |  11  |  12  |\n" +
                "|     |     |      |      |      |\n" +
                "----------------------------------\n" +
                "|  D  |     |      |      |      |\n" +
                "|     |     |  13  |  14  G  15  |\n" +
                "|  R  |     |      |      |      |\n" +
                "|  E  |     ----------------------\n" +
                "|  D  |  2  |      |      |      |\n" +
                "|     |  N  H  16  |  17  |  18  |\n" +
                "|     |  D  |      |      |      |\n" +
                "-------     ----------------------\n" +
                "|     |  1  |      |      |      |\n" +
                "|  B  |  2  |  19  |  20  |  21  |\n" +
                "|  L  |     |      |      |      |\n" +
                "|  A  |     ----------------------\n" +
                "|  C  |     |      |      |      |\n" +
                "|  K  |     |  22  |  23  |  24  |\n" +
                "|     |     |      |      |      |\n" +
                "-------- M -----------------------\n" +
                "|     |     |      |      |      |\n" +
                "|     |     |  25  |  26  |  27  |\n" +
                "|  O  |     |      |      |      |\n" +
                "F  D  |     ----------------------\n" +
                "|  D  |  3  |      |      |      |\n" +
                "|     |  R  |  28  |  29  |  30  |\n" +
                "|     |  D  |      |      |      |\n" +
                "-------     ----------------------\n" +
                "|     |  1  |      |      |      |\n" +
                "|  1  |  2  |  31  |  32  |  33  |\n" +
                "|  9  |     |      |      |      |\n" +
                "E  |  |     K---------------------\n" +
                "|  3  |     |      |      |      |\n" +
                "|  6  |     |  34  |  35  |  36  |\n" +
                "|     |     |      |      |      |\n" +
                "----------------------------------\n" +
                "            |      |      |      |\n" +
                "            |  2-1 |  2-1 |  2-1 |\n" +
                "            |      |      |      |\n" +
                "            --- B ---- B ---- B --\n");
    }
}