package com.sysco.vrfs_api.tests.loadManager.displayCarrierDetails;

import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.ResponseUtil;
import com.sysco.vrfs_api.util.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DisplayCarrierDetailsTests extends TestBase {
    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "VRFS - Contract Test - displalyCarrierDetailsTest");
    }

    @Test(description = "ID-002", alwaysRun = true)
    public static void testDisplayCarrierDetailsSuccessCode200(){
        Response response = RequestUtil.displayCarrierDetails("usa", "97060824");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }
}
