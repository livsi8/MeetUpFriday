package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A05_RegularExpressionSyntax {
    public static void main(String[] args) {
        Pattern pattern = null;
        /**
         * Синтаксис регулярных выражений основан на использовании символов
         * <([{\^-=$!|]})?*+.>, которые можно комбинировать с буквенными
         * символами. В зависимости от роли их можно разделить на несколько групп:
         */

        // Строка для сканирования, чтобы найти шаблон
        String str = "Егор Алла Александр \t1859г. \nГолованов \u2028 Одесса";


        /** Жадный режим квантификатора
         * 1. Ищем "А" = 5я позиция
         * 2. "." - ищем один любой символ = "Ал".
         * 3. "+" - ищем один и более предыдущих символов = "Алла Голованов"
         * 4. "а" - поскольку дошли до конца строки, ищем "а" в обратном порядке = Алла Голова
         */
        pattern = Pattern.compile("А.+а");


        /** Сверх жадный режим квантификатора
         * Тоже что и жадный, только поиска в обратном направлении не происходит
         * В данном случае ничего не выведет, поскольку "a" не найдена
         */
//        pattern = Pattern.compile("А.++а");


        /** Ленивый режим квантификатора
         * В отличие от жадного режима, в ленивом ищется самое короткое совпадение
         * в тексте, поэтому после нахождения совпадения со вторым символом шаблона,
         * который задан точкой и соответствует "л", Matcher будет проверять
         * соответствие текста остатку шаблона – символу «а».
         * И посскольку найдет совпадение, но конец текста ещё не достигнут, поэтому
         * с позиции №9 проверка начинается с поиска первого символа шаблона по
         * аналогичному алгоритму и далее повторяется вплоть до окончания текста.
         */
//        pattern = Pattern.compile("А.+?а");


        /** Метасимволы для поиска символьных классов
         * \d 	цифровой символ
         * \D 	нецифровой символ
         * \s 	символ пробела
         * \S 	непробельный символ
         * \w 	буквенно-цифровой символ или знак подчёркивания
         * \W 	любой символ, кроме буквенного, цифрового или знака подчёркивания
         * . 	любой символ
         */
//        pattern = Pattern.compile("\\d+г.");
//        pattern = Pattern.compile("\\sО\\W+е");


        /** Метасимволы для обозначения количества символов – квантификаторы.
         * Квантификатор всегда следует после символа или группы символов.
         * ? 	    один или отсутствует
         * * 	    ноль или более раз
         * + 	    один или более раз
         * {n} 	    n раз
         * {n,} 	n раз и более
         * {n,m} 	не менее n раз и не более m раз
         */
//        pattern = Pattern.compile("Ал+а");
//        pattern = Pattern.compile("О\\W+ес{1,2}.");


        /** Метасимволы для поиска совпадений границ строк или текста
         * ^ 	начало строки
         * $ 	конец строки
         * \b 	граница слова
         * \B 	не граница слова
         * \A 	Начало целой строки
         * \G 	конец предыдущего совпадения
         * \Z 	Конец целой строки
         * \z 	конец ввода
         */
//        pattern = Pattern.compile("^.{4}");
//        pattern = Pattern.compile(".{4}\\b");


        /** Метасимволы для поиска символов редактирования текста
         * \t 	символ табуляции
         * \n 	символ новой строки
         * \r 	символ возврата каретки
         * \f 	переход на новую страницу
         * \u0085 	символ следующей строки
         * \u2028 	символ разделения строк
         * \u2029 	символ разделения абзацев
         */
//        pattern = Pattern.compile("\\t.+");
//        pattern = Pattern.compile("\\n.+");
//        pattern = Pattern.compile("\\u2028.+");

        /** Метасимволы для группировки символов
         * [абв] 	любой из перечисленных (а,б, или в)
         * [^абв] 	любой, кроме перечисленных (не а,б, в)
         * [a-zA-Z] 	слияние диапазонов (латинские символы от a до z без учета регистра )
         * [a-d[m-p]] 	объединение символов (от a до d и от m до p)
         * [a-z&&[def]] 	пересечение символов (символы d,e,f)
         * [a-z&&[^bc]] 	вычитание символов (символы a, d-z)
         */
//        pattern = Pattern.compile("[0-9]");
//        pattern = Pattern.compile("[ге]");
//        pattern = Pattern.compile("[^АаЕеИиОоУу\\.\\d\\s]");
//        pattern = Pattern.compile("[^а-я\\s\\t\\d\\.]");

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\"");
        }
    }
}
