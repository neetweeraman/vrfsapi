package com.sysco.vrfs_api.tests.newLoad.createNewLoad;

import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.ResponseUtil;
import com.sysco.vrfs_api.util.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewLoadTest extends TestBase {
    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "VRFS - Contract Test - createNewLoadTests");
    }

    @Test(description = "ID-001", alwaysRun = true)
    public static void testCreateNewLoadSuccessCode200() {
        Response response = RequestUtil.createNewLoad("usa");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }
}
