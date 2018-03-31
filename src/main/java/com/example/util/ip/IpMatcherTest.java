package com.example.util.ip;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhangkh on 2018/1/4.
 */
public class IpMatcherTest {
    public IpMatcherTest() {
        System.out.println("构造器");
    }

    static {
        System.out.println("static");
    }

    static List<String> ipList = Arrays.asList("52.34.55.*", "111.111.112.*",
            "123.255.255.1", "1.2.3.4-6", "0.2.0.2", "255.255.255.35/23");

    static void print(Object val) {
        System.out.println(val);
    }


    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public static void main(String[] argc) {
//        IpMatcher ipMatcher = new IpMatcher(ipList);
//        print( ipMatcher.matches("123.255.255.1"));
//        print(Pattern.matches("52.34.55.1", "52.34.55.11"));
//        IpMatcherTest ipMatcherTest = new IpMatcherTest();

        String str = "&#x7528;&#x6237;&#x7981;&#x6b62;&#x767b;&#x9646;";

        String patt = "/v1/**";
        int[] a = {1,3,3};
        print(StringUtils.join(a,'.'));
//        print(Pattern.matches("/v1/**","/v1/user/1"));

    }
}
