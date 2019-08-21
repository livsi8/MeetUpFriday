package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A04_QuantifierMode {
    public static void main(String[] args) {
        Pattern pattern = null;
        /** Синтаксис регулярных выражений
         * Синтаксис регулярных выражений основан на использовании символов
         * <([{\^-=$!|]})?*+.>, которые можно комбинировать с буквенными
         * символами. В зависимости от роли их можно разделить на несколько групп:
         */

        // Строка для сканирования, чтобы найти шаблон
        String str = "Егор Алла Александр Голованов";

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

        /**
         * Экранирование символов в регулярных выражениях с помощью символа "\"
         */

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\"");
        }
    }
}