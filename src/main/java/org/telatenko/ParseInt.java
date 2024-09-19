package org.telatenko;

import java.util.function.Function;

//Преобразование строки в число
//Необходимо реализовать метод,
//который преобразует строку в целое число.
//Например, строку “123” преобразует в число 123.
//Поведение метода должно быть аналогично поведению метода Integer.parseInt
public class ParseInt {

    public static int parseIntCastom(String input) {
        Function<String, Integer> parseInt = str -> {
            int result = 0;
            int index = 0;

            while (index < str.length()) {
                char c = str.charAt(index);
                int digit = c - '0';
                result = result * 10 + digit;
                index++;
            }
            return result;
        };
        return parseInt.apply(input);
    }

    public static void main(String[] args) {
        String string = "1234";
        int intValue = parseIntCastom(string);

        System.out.println(string);
        System.out.println(intValue);

    }
}
