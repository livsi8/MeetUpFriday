package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_Tasks {
    public static void main(String[] args) {
        String str = null;
        String regEx = null;

        str = "066.225-23-23";
        regEx = ".+";
//        regEx = "[0-9]{3}\\.(\\d{2,3}|-)*";
//        regEx = "\\d{3}\\.\\d{3}-\\d{2}-\\d{2}";

//        str = "http://host.com/parameters";
//        regEx = ".+";
//        regEx = "[htps]+://\\w{2,}.\\w+/\\w+";
//

//        str = "email@gmail.com";
//        regEx = ".+";
//         regEx = "\\w+@\\w+.\\w+";
//

        // hexidecimal color

//        str = "#aabbcc";
//        regEx = ".+";
//        regEx = "#?[0-9A-Fa-f]{6}";
//


        /**
         * Regex-инструменты для использования онлайн
         * https://regexr.com/
         * https://rubular.com/
         * https://www.regexpal.com/
         * http://www.regexplanet.com/
         *
         * Links:
         * http://javascript.ru/basic/regular-expression
         * http://proglang.su/java/regular-expressions
         *
         * Шпаргалка по регулярным выражениям
         * https://www.exlab.net/tools/sheets/regexp.html
         */

        Pattern pattern = Pattern.compile(regEx);
        System.out.println("=> " + pattern.matcher(str).matches());
    }
}
