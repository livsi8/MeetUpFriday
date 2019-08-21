package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A01_Example {
    public static void main(String[] args) {
        /**
         * Пакет regex состоит всего из трех классов:
         * Pattern - скомпилированное представление регулярного выражения.
         *    Для компиляции нужно вызвать статический метод compile().
         * Matcher - движок, который производит операцию сравнения (match).
         *    Объект класса Matcher может быть получен путем вызова
         *    метода matcher() на объекте класса Pattern.
         * PatternSyntaxException - указывает на синтаксическую ошибку в выражении.
         * Pattern, Matcher не содержит публичных конструкторов.
         */

        System.out.println(checkWithRegExp("vovan"));
        System.out.println(dumbCheck("vovan"));
    }

    private static boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^[a-z0-9_]{3,15}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
//        return Pattern.compile("^[a-z0-9_-]{3,15}$").matcher(userNameString).matches();
    }

    private static boolean dumbCheck(String userNameString) {
        char[] symbols = userNameString.toCharArray();
        if (symbols.length < 3 || symbols.length > 15) return false;

        String validationString = "abcdefghijklmnopqrstuvwxyz0123456789_";

        for (char c : symbols) {
            if (validationString.indexOf(c) == -1) return false;
        }
        return true;
    }
}