package com.sysco.vrfs_api.tests.loadManager.displayEditCarrierDetails;

import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.ResponseUtil;
import com.sysco.vrfs_api.util.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DisplayEditCarrierDetails extends TestBase {
    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "VRFS - API Test");
    }

    @Test(description = "ID-003", alwaysRun = true)
    public static void testDisplayEditCarrierDetailsSuccessCode200(){
        Response response = RequestUtil.displayEditCarrierDetails("usa", "97060824");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }
}
