package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class A02_Methods {
    public static void main(String[] args) {
        Pattern pattern = null;
        Matcher matcher = null;
        /* ~~~~~~~~~~~~~~~~ Основные методы класса Pattern ~~~~~~~~~~~~~~~~ */

        /** pattern()
         * возвращает исходное строковое представление регулярного выражения,
         * из которого был создан объект Pattern:
         */
        pattern = Pattern.compile("abc");
        System.out.println(pattern.pattern());  //"abc"


        /** static boolean matches(String regex, CharSequence input)
         * позволяет проверить регулярное выражение, переданное в параметре
         * regex на соответствие тексту, переданному в параметре input.
         */
//        System.out.println(Pattern.matches("А.+а", "Алла"));                 //true
//        System.out.println(Pattern.matches("А.+а", "Егор Алла Александр"));  //false
        /**
         * Оба метода matches и lookingAt направлены на попытку поиска соответствия
         * вводимой последовательности с шаблоном. Разница, однако, заключается в
         * том, что для метода matches требуется вся вводимая последовательность,
         * в то время как lookingAt этого не требует.
         */
//        matcher = Pattern.compile("Pro").matcher("ProgLang");
//        System.out.println("matcher.lookingAt() = " + matcher.lookingAt());  // true

        /** flags()
         * возвращает значения параметра flags шаблона, которые были установлены
         * при его создании, или 0, если этот параметр не был установлен.
         * Подробнее о флагах: http://spec-zone.ru/RU/Java/Tutorials/essential/regex/pattern.html
         */
//        pattern = Pattern.compile("abc");
//        System.out.println(pattern.flags());    // 0
//        pattern = Pattern.compile("abc", Pattern.CASE_INSENSITIVE); // Нечувствителен к регистру.
//        System.out.println(pattern.flags());    // 2


        /** String[] split(CharSequence text, int limit)
         * разбивает текст, переданный в качестве параметра на массив элементов String.
         * Параметр limit определяет предельное количество совпадений, которое ищется в тексте:
         * при limit>0 – выполняется поиск limit-1 совпадений;
         * при limit<0 – выполняется поиск всех совпадений в тексте
         * при limit=0 – выполняется поиск всех совпадений в тексте, при этом пустые
         *     строки в конце массива отбрасываются;
         */
//        String text = "Егор Алла Анна Роман Кирилл Святослав";
//        pattern = Pattern.compile("\\s");
//        String[] strings = pattern.split(text, 2);
//        for (String s : strings) {
//            System.out.println(s);
//        }
//        System.out.println("---------");
//        String[] strings1 = pattern.split(text);
//        for (String s : strings1) {
//            System.out.println(s);
//        }


        /* ~~~~~~~~~~~~~~~~ Основные методы класса Matcher ~~~~~~~~~~~~~~~~ */

        /** рublic Matcher matcher(CharSequence input)
         * этот метод предусмотрен в классе Pattern для создания объекта Matcher.
         * В качестве аргумента метод принимает последовательность символов, в котором будет
         * производиться поиск. Это объекты классов, реализующих интерфейс CharSequence. в
         * качестве аргумента можно передать не только String, но и StringBuffer,
         * StringBuilder, Segment и CharBuffer.
         */
//        Pattern p = Pattern.compile("a*b");// скомпилировали регулярное выражение в представление
//        matcher = p.matcher("aaaaabcd");//создали поисковик в тексте “aaaaab” по шаблону "a*b"
//        while (matcher.find()) {
//            System.out.println("\"" + matcher.group() + "\"");
//        }


        /** boolean find()
         * ищет очередное совпадение в тексте с шаблоном. С помощью этого метода и оператора
         * цикла можно производить анализ всего текста по событийной модели (осуществлять
         * необходимые операции при наступлении события – нахождении совпадения в тексте).
         * Например, с помощью методов этого класса int start() и int end() можно определять
         * позиции совпадения в тексте, а с помощью методов String replaceFirst(String replacement) и
         * String replaceAll(String replacement) заменять в тексте совпадения на другой текст replacement.
         */
//        String text = "Егор Алла Анна";
//        pattern = Pattern.compile("А.+?а");
//        matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            int start=matcher.start();
//            int end=matcher.end();
//            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
//        }
//        System.out.println(text);
//        System.out.println(matcher.replaceFirst("Ира"));
//        System.out.println(matcher.replaceAll("Ольга"));

        /* Методы индексов */
        /** public int start()
         * Возврат начального индекса к предыдущему совпадению.
         */
//        String str = "Егор Алла Александр Голованов";
//        Pattern p = Pattern.compile("А*а");
//        matcher = p.matcher(str);
//        while (matcher.find()) {
//            System.out.println("\"" + matcher.start() + "\"");
//        }

        /* ~~~~~~~ Основные методы класса PatternSyntaxException ~~~~~~~~~~~ */

//        String regex = "***";
//        PatternSyntaxException exc = null;
//        try {
//            Pattern.compile(regex);
//        } catch (PatternSyntaxException e) {
//
//            System.out.println("~~~~~~~~~~~~~~~~~~");
//            System.out.println("getDescription() Представляет описание ошибки:");
//            System.out.println(e.getDescription());
//            System.out.println("~~~~~~~~~~~~~~~~~~");
//            System.out.println("getIndex() Представляет индекс ошибки:");
//            System.out.println(e.getIndex());
//            System.out.println("~~~~~~~~~~~~~~~~~~");
//            System.out.println("getPattern() Представляет шаблон регулярного выражения, содержащего ошибку");
//            System.out.println(e.getPattern());
//            System.out.println("~~~~~~~~~~~~~~~~~~");
//            System.out.println("getMessage() Производит возврат многострочной строки, содержащей описание синтаксической \nошибки и ее индекс, ошибочный образец регулярного выражения, \nа также визуальную индикацию индекса ошибки в шаблоне.");
//            System.out.println(e.getMessage());
//            System.out.println("~~~~~~~~~~~~~~~~~~");
//        }
    }
}
