package com.sysco.vrfs_api.tests;

import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.TestBase;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.Headers;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {


    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test(description = "ID-001", alwaysRun = true)
    public static void testLogin() {
//        Response response = given().when().get("http://vrfsweb-qa.aws-us-east-1.na.sysco.tst:8081/swagger-ui.html#!/new-load-controller/createNewLoadUsingGET");

        RestUtil.BASE_PATH = "";
        RestUtil.API_HOST = "";
        Response response = RestUtil.send(Headers.getHeader(), "{  \"lastLoadNumber\": 0 }", "http://vrfsweb-qa.aws-us-east-1.na.sysco.tst:8081/swagger-ui.html#!/new-load-controller/createNewLoadUsingGET",  "GET");
//        System.out.println("response code ==> "+response.statusCode());
//        System.out.println("response body ==> "+response.body().toString());
        System.out.println("Response code == "+response.statusCode());
    }

}
