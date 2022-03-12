package com.company;

import java.util.Objects;

public enum RomanNumeral {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);
    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isRoman(String[] str) throws IncorrectExpressionException {
        int countOfRoman = 0;
        for (String s : str) {
            for (RomanNumeral romanNumeral : RomanNumeral.values()) {
                if (Objects.equals(s, romanNumeral.name())) {
                    countOfRoman++;
                }
            }
        }
        if (countOfRoman < str.length) {
            throw new IncorrectExpressionException("разные форматы чисел");
        }
        return countOfRoman == str.length;
    }

    public static String[] convertToRoman(String[] num) {
        String[] result = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            for (RomanNumeral romanNumeral : RomanNumeral.values()) {
                if (Objects.equals(num[i], romanNumeral.name())) {
                    result[i] = String.valueOf(romanNumeral.getValue());
                }
            }
        }
        return result;
    }

    public static String convertToArab(double num) throws IncorrectExpressionException {
        String result = "";
        if (num % 1 == 0 && num > 0) {
            int convertNum = (int) num;
            if (convertNum == 100) {
                return "C";

            } else {

                if (convertNum < 10) {
                    for (RomanNumeral romanNumeral : RomanNumeral.values()) {
                        if (convertNum == romanNumeral.getValue()) {
                            return romanNumeral.name();
                        }
                    }
                }

                if (convertNum >= 10 && convertNum < 100) {
                    int bIndex = convertNum / 10;
                    int sIndex = convertNum % 10;
                    if (bIndex < 4) {
                        while (bIndex != 0) {
                            result += "X";
                            bIndex--;
                        }
                    }
                    switch (bIndex) {
                        case (4):
                            result = "XL";
                            break;
                        case (5):
                            result = "L";
                            break;
                        case (6):
                            result = "LX";
                            break;
                        case (7):
                            result = "LXX";
                            break;
                        case (8):
                            result = "LXXX";
                            break;
                        case (9):
                            result = "XC";
                            break;
                    }

                    for (RomanNumeral romanNumeral : RomanNumeral.values()) {
                        if (sIndex != 0 && romanNumeral.getValue() == sIndex) {
                            result += romanNumeral.name();
                        }
                    }
                }
            }
        } else {
            throw new IncorrectExpressionException("Недопустимое значения для римских чисел");
        }
        return result;
    }
}
