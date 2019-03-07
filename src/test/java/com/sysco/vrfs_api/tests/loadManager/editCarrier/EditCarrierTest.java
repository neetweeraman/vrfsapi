package com.sysco.vrfs_api.tests.loadManager.editCarrier;

import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.request.data.EditCarrierData;
import com.sysco.vrfs_api.util.JsonReaderUtil;
import com.sysco.vrfs_api.util.RequestUtil;
import com.sysco.vrfs_api.util.ResponseUtil;
import com.sysco.vrfs_api.util.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class EditCarrierTest extends TestBase {
    private static EditCarrierData[] editCarrierData;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "VRFS - API Test");
    }

    @Test(description = "ID-007", alwaysRun = true)
    public static void testEditLoadSuccessCode200() throws FileNotFoundException {
        editCarrierData = JsonReaderUtil.getEditLoadDataFromJasonArray();
        editCarrierData[0].loadNumber = "97060824";
        Response response = RequestUtil.editCarrier("usa", editCarrierData[0]);
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }
}
