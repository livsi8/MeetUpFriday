package RegularExpressions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class RegExParametrized {

    private String str;
    private String regEx;
    private String result;
    private String replaceTo;

    public RegExParametrized(String regEx, String str, String result, String replaceTo) {
        this.str = str;
        this.regEx = regEx;
        this.result = result;
        this.replaceTo = replaceTo;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        String[][] data = {
            // 1
            {"a.b", "ahb acb aeb aeeb adcb axeb", "! ! ! aeeb adcb axeb", "!"},
            {"a..a", "aba aca aea abba adca abea", "aba aca aea ! ! !", "!"},
            {"ab.a", "aba aca aea abba adca abea", "aba aca aea ! adca !", "!"},

            // 2
            {"ab+a", "aa aba abba abbba abca abea", "aa ! ! ! abca abea", "!"},
            {"ab*a", "aa aba abba abbba abca abea", "! ! ! ! abca abea", "!"},
            {"ab?a", "aa aba abba abbba abca abea", "! ! abba abbba abca abea", "!"},
            {"(ab)+", "ab abab abab abababab abea", "! ! ! ! !ea", "!"},

            // 3
            {"a\\.a/", "a.a aba aea", "a.a aba aea", "!"},
            {"2\\+3", "2+3 223 2223", "! 223 2223", "!"},
            {"2\\++3", "23 2+3 2++3 2+++3 345 567", "23 ! ! ! 345 567", "!"},
            {"2\\+*3", "23 2+3 2++3 2+++3 345 567", "! ! ! ! 345 567", "!"},
            {"\\*q+\\+", "*+ *q+ *qq+ *qqq+ *qqq qqq+", "*+ ! ! ! *qqq qqq+", "!"},

            // 4
            {"a.+?a", "aba accca azzza wwwwa", "! ! ! wwwwa", "!"},

            // 5
            {"ab{2,4}a", "aa aba abba abbba abbbba abbbbba", "aa aba ! ! ! abbbbba", "!"},
            {"ab{0,3}a", "aa aba abba abbba abbbba abbbbba", "! ! ! ! abbbba abbbbba", "!"},
            {"ab{4,}a", "aa aba abba abbba abbbba abbbbba", "aa aba abba abbba ! !", "!"},

            // 6
            {"a\\da", "a1a a2a a3a a4a a5a aba aca", "! ! ! ! ! aba aca", "!"},
            {"a\\d+a", "a1a a22a a333a a4444a a55555a aba aca", "! ! ! ! ! aba aca", "!"},
            {"a\\d*a", "a1a a22a a333a a4444a a55555a aba aca", "! ! ! ! ! aba aca", "!"},
            {"a\\Db", "avb a1b a2b a3b a4b a5b abb acb", "! a1b a2b a3b a4b a5b ! !", "!"},
            {"a\\Wb", "ave a#b a2b a$b a4b a5b a-b acb", "ave ! a2b ! a4b a5b ! acb", "!"},
            {"\\s", "ave a#b a2b a$b a4b a5b a-b acb", "ave!a#b!a2b!a$b!a4b!a5b!a-b!acb", "!"},

            // 7
            {"a[aex]a", "aba aea aca aza axa", "aba ! aca aza !", "!"},
            {"a[b.+*]a", "aba aea aca aza axa a.a a+a a*a", "! aea aca aza axa ! ! !", "!"},
            {"a[3-7]a", "a1a a2a a3a a4a a5a a6a a7a aba", "a1a a2a ! ! ! ! ! aba", "!"},
            {"a[a-g]", "aaa aba aca ada ana a6a aga ", "!a !a !a !a ana a6a !a ", "!"},
            {"a[a-fj-z]a", "aaa aba aca ada afa aza aga ", "! ! ! ! ! ! aga ", "!"},
            {"a[a-fA-Z]a", "aaa aBa aca aDa afa aZa aga ", "! ! ! ! ! ! aga ", "!"},
            {"a[^ex]a", "aba aea aca aza axa a-a a#a", "! ae!c!z!x!-!#a", "!"},
            {"w[А-Яа-яЁё]w", "wйw wяw wёw wqw", "! ! ! wqw", "!"},

            // 8
            {"a[a-z]+a", "aAXa aeffa aGha aza ax23a a3sSa", "aAXa ! aGha ! ax23a a3sSa", "!"},
            {"a[a-zA-Z]+a", "aAXa aeffa aGha aza ax23a a3sSa", "! ! ! ! ax23a a3sSa", "!"},
            {"a[a-z0-9]+a", "aAXa aeffa aGha aza ax23a a3sSa", "aAXa ! aGha ! ! a3sSa", "!"},
            {"[А-Яа-яЁё]+", "ааа aAXa ббб ёёё ззз ййй aGha ААА БББ ЁЁЁ ЗЗЗ ЙЙЙ", "! aAXa ! ! ! ! aGha ! ! ! ! !", "!"},

            // 9
            {"^aaa", "aaa aaa aaa", "! aaa aaa", "!"},
            {"aaa$", "aaa aaa aaa", "aaa aaa !", "!"},

            // 10
            {"ae+a|ax+a", "aeeea aeea aea axa axxa axxxa", "! ! ! ! ! !", "!"},
            {"ae{2}a|ax+a", "aeeea aeea aea axa axxa axxxa", "aeeea ! aea ! ! !", "!"},

            // 11
            {"a\\\\a", "a\\a abc", "! abc", "!"},
            {"a(\\\\){3}a", "a\\a a\\\\\\a a\\\\\\\\\\a", "a\\a ! a\\\\\\\\\\a", "!"},
            {"\\/.+?\\\\", "bbb /aaa\\ bbb /ccc\\", "bbb ! bbb !", "!"},

            // 12
            {"(\\w+)@(\\w+)", "aaa@bbb eee7@kkk", "bbb@aaa kkk@eee7", "$2@$1"},
            {"(\\d)", "a1b2c3", "a11b22c33", "$1$1"},

            // 13
            {"[a-zA-z]+\\W?[a-z]+@[a-zA-z]+\\.[a-z]{2,3}", "mymail@mail.ru my.mail@google.com my-mail@i.ua my_mail@ukr.net mail@mail.com mail@mail.by mail@yandex.ru", "! ! ! ! ! ! !", "!"},
            {"[a-z-\\._]+\\.[a-z]{2,3}", "site.ua, site.com, my-site.com, my.site.com, my_site.com", "!, !, !, !, !", "!"},
            {"https?://[a-z-\\._]+\\.[a-z]{2,3}", "http://site.ua, http://site.com", "!, !", "!"},
            {"\\.(php|txt|html)", "index.php", "index!", "!"},
            {"\\d{12}", "123456789131", "!", "!"},

            // 14
            {"(https?://([a-z-\\._]+\\.[a-z]{2,3}))", "http://site.com", "<a href=\"http://site.com\">site.com</a>","<a href=\"$1\">$2</a>"},
            {"\\s{2}", "12  aa  aaa  56", "12 aa aaa 56", " "},
            {"(\\/\\*)(.*)(\\*\\/)", "/*color: #fff;*/", "color: #fff;", "$2"},
            {"<!--(.*)-->", "<!--html-->", "html", "$1"},

            // 15
            {"a+(?=b)", "aaab", "!b","!"},
            {"a{3}(?!b)", "aaaw aaab", "!w aaab", "!"},

            // 16
            {"(19)\\d\\d|(20)\\d\\d|(2100)", "2009", "!","!"},
            {"([01]\\d|2[0-3]):[0-5]\\d", "12:59, 23:41, 00:12, 00:00, 09:15, 24.00, 25.00, 12.60, 12.93, 41.93", "!, !, !, !, !, 24.00, 25.00, 12.60, 12.93, 41.93", "!"},
            {"(\\d|[01]\\d|2[0-3]):[0-5]\\d\\s[ap]m", "9:59 am, 12:30 pm, 24.00 am, 13.15 am", "!, !, 24.00 am, 13.15 am", "!"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void pushTest() {
        Assert.assertEquals(
            result,
            str.replaceAll(regEx, replaceTo)
        );
    }
}
