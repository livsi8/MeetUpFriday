package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A03_CollectionGroups {
    public static void main(String[] args) {
        /** Группы сбора
         * Группы сбора представляют способ обращения с несколькими
         * символами как с одной единицей. Они создаются путем размещения
         * символов, которые предстоит сгруппировать, в серии круглых
         * скобок. К примеру, регулярное выражение (dog) составляет
         * отдельную группу, содержащую буквы "d", "o", и "g".
         *
         * Группы сбора нумеруются посредством определения числа
         * открывающих круглых скобок слева направо. Так, в выражении
         * ((A)(B(C))) присутствуют четыре подобные группы:
         * ((A)(B(C)))
         * (A)
         * (B(C))
         * (C)
         */

        // Строка для сканирования, чтобы найти шаблон
        String str = "Крещение Киевской Руси произошло в 988 году! Не так ли?";
        String pattern = "(.*)(\\d{3})(.*)";
//        String pattern = "(((.*)(\\d{3}))(.*))";

        // Создание Pattern объекта
        Pattern r = Pattern.compile(pattern);

        // Создание matcher объекта
        Matcher m = r.matcher(str);

        System.out.println("Количество групп: " + m.groupCount());

        if (m.find( )) {
            System.out.println("Найдено значение group(0): \"" + m.group(0) + "\"");
            System.out.println("Найдено значение group(1): \"" + m.group(1) + "\"");
            System.out.println("Найдено значение group(2): \"" + m.group(2) + "\"");
            System.out.println("Найдено значение group(3): \"" + m.group(3) + "\"");
//            System.out.println("Найдено значение group(4): \"" + m.group(4) + "\"");
//            System.out.println("Найдено значение group(5): \"" + m.group(5) + "\"");
        }else {
            System.out.println("НЕ СОВПАДАЕТ");
        }
    }
}
