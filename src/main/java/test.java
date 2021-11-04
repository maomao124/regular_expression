import javax.swing.text.DefaultEditorKit;
import java.awt.*;

/**
 * Project name(项目名称)：正则表达式
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/4
 * Time(创建时间)： 19:10
 * Version(版本): 1.0
 * Description(描述)：
 * 正则表达式所支持的合法字符
 * 字符	解释
 * X	字符x（x 可代表任何合法的字符)
 * \0mnn	八进制数 0mnn 所表示的字符
 * \xhh	十六进制值 0xhh 所表示的字符
 * \\uhhhh	十六进制值 0xhhhh 所表示的 Unicode 字符
 * \t	制表符（“\u0009”）
 * \n	新行（换行）符（‘\u000A’）
 * \r	回车符（‘\u000D’)
 * \f 	换页符（‘\u000C’）
 * \a	报警（bell）符（‘\u0007’）
 * \e	Escape 符（‘\u001B’）
 * \cx	x 对应的的控制符。例如，\cM匹配 Ctrl-M。x 值必须为 A~Z 或 a~z 之一。
 * 正则表达式中的特殊字符
 * 特殊字符	说明
 * $	匹配一行的结尾。要匹配 $ 字符本身，请使用\$
 * ^	匹配一行的开头。要匹配 ^ 字符本身，请使用\^
 * ()	标记子表达式的开始和结束位置。要匹配这些字符，请使用\(和\)
 * []	用于确定中括号表达式的开始和结束位置。要匹配这些字符，请使用\[和\]
 * {}	用于标记前面子表达式的出现频度。要匹配这些字符，请使用\{和\}
 * *	指定前面子表达式可以出现零次或多次。要匹配 * 字符本身，请使用\*
 * +	指定前面子表达式可以出现一次或多次。要匹配 + 字符本身，请使用\+
 * ?	指定前面子表达式可以出现零次或一次。要匹配 ？字符本身，请使用\?
 * .	匹配除换行符\n之外的任何单字符。要匹配.字符本身，请使用\.
 * \	用于转义下一个字符，或指定八进制、十六进制字符。如果需匹配\字符，请用\\
 * |	指定两项之间任选一项。如果要匹配丨字符本身，请使用\|
 * 预定义字符
 * 预定义字符	说明
 * .	可以匹配任何字符
 * \d	匹配 0~9 的所有数字
 * \D	匹配非数字
 * \s	匹配所有的空白字符，包括空格、制表符、回车符、换页符、换行符等
 * \S	匹配所有的非空白字符
 * \w	匹配所有的单词字符，包括 0~9 所有数字、26 个英文字母和下画线_
 * \W	匹配所有的非单词字符
 * 方括号表达式
 * 方括号表达式	说明
 * 表示枚举	例如[abc]表示 a、b、c 其中任意一个字符；[gz]表示 g、z 其中任意一个字符
 * 表示范围：-	例如[a-f]表示 a~f 范围内的任意字符；[\\u0041-\\u0056]表示十六进制字符 \u0041 到 \u0056 范围的字符。
 * 范围可以和枚举结合使用，如[a-cx-z]，表示 a~c、x~z 范围内的任意字符
 * 表示求否：^	例如[^abc]表示非 a、b、c 的任意字符；[^a-f]表示不是 a~f 范围内的任意字符
 * 表示“与”运算：&&	例如 [a-z&&[def]]是 a~z 和 [def] 的交集，表示 d、e
 * f[a-z&&^bc]]是 a~z 范围内的所有字符，除 b 和 c 之外
 * [ad-z] [a-z&&[m-p]]是 a~z 范围内的所有字符，除 m~p 范围之外的字符
 * 表示“并”运算	并运算与前面的枚举类似。例如[a-d[m-p]]表示 [a-dm-p]
 * 边界匹配符
 * 边界匹配符	说明
 * ^	行的开头
 * $	行的结尾
 * \b	单词的边界
 * \B	非单词的边界
 * \A	输入的开头
 * \G	前一个匹配的结尾
 * \Z	输入的结尾，仅用于最后的结束符
 * \z	输入的结尾
 * Greedy（贪婪模式）：数量表示符默认采用贪婪模式，除非另有表示。贪婪模式的表达式会一直匹配下去，直到无法匹配为止。
 * 如果你发现表达式匹配的结果与预期的不符，很有可能是因为你以为表达式只会匹配前面几个字符，而实际上它是贪婪模式，所以会一直匹配下去。
 * Reluctant（勉强模式）：用问号后缀（?）表示，它只会匹配最少的字符。也称为最小匹配模式。
 * Possessive（占有模式）：用加号后缀（+）表示，目前只有 Java 支持占有模式，通常比较少用。
 * 三种模式的数量表示符
 * 贪婪模式	勉强模式	占用模式	说明
 * X?	X??	X?+	X表达式出现零次或一次
 * X*	X*?	X*+	X表达式出现零次或多次
 * X+	X+?	X++	X表达式出现一次或多次
 * X{n}	X{n}?	X{n}+	X表达式出现 n 次
 * X{n,}	X{n,}?	X{n,}+	X表达式最少出现 n 次
 * X{n,m}	X{n,m}?	X{n,m}+	X表达式最少出现 n 次，最多出现 m 次
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        String s = "15 68 79,789.58，9t。48";
        String[] s1 = s.split("[ ,.，。]");
        for (String s2 : s1)
        {
            System.out.println(s2);
        }
        String s3 = "dtet8etryr9yture1awr25etry6QW";
        //String []s4 = s3.split("[1-9]");
        String[] s4 = s3.split("[^a-zA-Z]+");
        for (String s2 : s4)
        {
            System.out.println(s2);
        }
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
