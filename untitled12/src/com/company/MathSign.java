package com.company;

public enum MathSign {
    div("/"),
    mult("*"),
    plus("+"),
    mines("-");
    private String sign="";

    MathSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static String contains(String line) throws IncorrectExpressionException {
        String sign = "";
        int countOfSign=0;
        for (MathSign mathSign : MathSign.values()) {
            if (line.contains(mathSign.getSign())) {
                sign = mathSign.getSign();
                countOfSign++;
            }
        }
        if (line.replace(sign,"").length()!=line.length()-1)
        {
            throw new IncorrectExpressionException("Выражение должно содержать один оператор");
        }
        if (sign.equals("")) {
            throw new IncorrectExpressionException("Не является математическим выражением");
        }
        if (countOfSign>1){
            throw new IncorrectExpressionException("Выражение должно содержать один оператор");
        }
        return sign;
    }
}
