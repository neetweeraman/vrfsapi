package com.sysco.vrfs_api.common;

public class Constant {
    public static final String TEST_ENV = System.getProperty("tests.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("tests.release", "<Your Release>");
    public static final String TEST_PROJECT = System.getProperty("tests.project", "<Your Project>");
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "true"));

    public static final int USA_PORT = 8081;
    public static final int CANADA_PORT = 8082;
    public static final String VRFS_USA_BASE_URI = "http://vrfsweb-qa.aws-us-east-1.na.sysco.tst:8081/swagger-ui.html#!";
    public static final String VRFS_CANADA_BASE_URI = "http://vrfsweb-qa.aws-us-east-1.na.sysco.tst:8082/swagger-ui.html#!";
    public static final String VRFS_API_HOST = "http://vrfsweb-qa.aws-us-east-1.na.sysco.tst:";
    public static final String VRFS_BASE_PATH = "";

    Constant() {

    }


}
