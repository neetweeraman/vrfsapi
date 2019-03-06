package com.sysco.vrfs_api.tests;

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

public class VrfsApiTest extends TestBase {
    private static EditCarrierData[] editCarrierData;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "VRFS - API Test");
    }

    @Test(description = "ID-001", alwaysRun = true)
    public static void testCreateNewLoadSuccessCode200() {
        Response response = RequestUtil.createNewLoad("usa");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
        System.out.println("Response body === "+ ResponseUtil.getResponseBodyAsString(response));
    }

    @Test(description = "ID-002", alwaysRun = true)
    public static void testDisplayCarrierDetailsSuccessCode200(){
        Response response = RequestUtil.displayCarrierDetails("usa", "97060824");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }

    @Test(description = "ID-003", alwaysRun = true)
    public static void testDisplayEditCarrierDetailsSuccessCode200(){
        Response response = RequestUtil.displayEditCarrierDetails("usa", "97060824");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }

    @Test(description = "ID-004", alwaysRun = true)
    public static void testDisplayLoadDetailsSuccessCode200(){
        Response response = RequestUtil.displayLoadDetails("usa", "97060824");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }

    @Test(description = "ID-005", alwaysRun = true)
    public static void testDisplayEditLoadDetailsSuccessCode200(){
        Response response = RequestUtil.displayEditLoadDetails("usa", "3914087");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }

    @Test(description = "ID-006", alwaysRun = true)
    public static void testDisplayNotesSuccessCode200(){
        Response response = RequestUtil.displayNotes("usa", "3914087");
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }

    @Test(description = "ID-005", alwaysRun = true)
    public static void testEditLoadSuccessCode200() throws FileNotFoundException {
        editCarrierData = JsonReaderUtil.getEditLoadDataFromJasonArray();
        editCarrierData[0].loadNumber = "97060824";
        Response response = RequestUtil.editCarrier("usa", editCarrierData[0]);
        Assert.assertEquals(ResponseUtil.getResponseCode(response), 200, "Success code is 200");
    }


}
