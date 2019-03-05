package com.sysco.vrfs_api.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.sysco.vrfs_api.common.Constant;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.ResponseUtil;
import com.sysco.vrfs_api.util.TestBase;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.Headers;
import org.apache.http.message.BasicHttpRequest;
import org.json.HTTP;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;


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
        System.out.println("send request\n");
        String response = RequestUtil.createNewLoad();

        System.out.println("execute\n");
        RequestUtil.executeCreateNewLoad();

        System.out.println("Response ==\n "+ response);

        /*Response response = RequestUtil.createNewLoad_();
        System.out.println("Response Code: "+ ResponseUtil.getResponseCode(response));*/

        System.out.println("\nafter response");

    }

}
