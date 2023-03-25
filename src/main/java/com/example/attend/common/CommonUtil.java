package com.example.attend.common;

public class CommonUtil {


    public static String makeKey(String userName,String slackUrl)
    {
        String userKey = userName+  slackUrl.substring(slackUrl.length()-3, slackUrl.length());
        return userKey;
    }


}
