package com.finvizapi.webfinvizapi.model;

public class UserAgent {

    private static final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36";

    public UserAgent() {

    }

    public static String getUserAgent() {
        return userAgent;
    }
}
