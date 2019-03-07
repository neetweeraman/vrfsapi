package com.sysco.vrfs_api.tests.loadManager.displayNotes;

import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.ResponseUtil;
import com.sysco.vrfs_api.util.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DisplayNotesTest extends TestBase {
    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "VRFS - API Test");
    }

    @Test(description = "ID-006", alwaysRun = true)
    public static void testDisplayNotesSuccessCode200(){
        Response response = RequestUtil.displayNotes("usa", "3914087");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }
}
