package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().replace(" ","");
        in.close();
        String sign = "";

        try {
            sign = MathSign.contains(line);
        } catch (IncorrectExpressionException e) {
            e.printStackTrace();
        }
        String[] num = line.split(String.format("\\%s", sign));
        double result = 0;
        try {
            if (Figure.isArabic(num)) {
                System.out.println(Figure.calculationsArab(sign, num));
            } else {
                if (RomanNumeral.isRoman(num)) {
                    System.out.println(RomanNumeral.convertToArab(Figure.calculationsArab(sign, RomanNumeral.convertToRoman(num))));
                }
            }
        } catch (IncorrectExpressionException e) {
            e.printStackTrace();
        }
    }
}
