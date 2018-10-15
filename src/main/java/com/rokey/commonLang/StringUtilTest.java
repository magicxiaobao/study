package com.rokey.commonLang;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chenyuejun
 * @create 2017-09-08 下午2:17.
 */
public class StringUtilTest {


    public static void main(String[] args) {


        String str = "LIKES_name_OR_email";
        PropertyFilter filter = new PropertyFilter(str,"xiaobao");

        boolean blank = StringUtils.isBlank(" ");
        boolean empty = StringUtils.isEmpty("  ");
        System.out.println(Boolean.toString(blank));
        System.out.println(StringUtils.isNotBlank(" "));
        System.out.println(Boolean.toString(empty));

    }



}
