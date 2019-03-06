package com.sysco.vrfs_api.util;

import com.jayway.restassured.response.Response;
import com.syscolab.qe.core.api.restassured.RestUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.syscolab.qe.core.api.restassured.RestUtil.getValue;

/**
 * QE-CORE CONTAINS API RELATED FUNCTIONS
 * Refer  com.syscolabs.qe.core.api
 */
public class ResponseUtil {

    public static int getResponseCode(Response response){
        return RestUtil.getResponseCode(response);
    }

    public static String getResponseBodyAsString(Response response){ return  response.asString(); }

    public static boolean getResponseStatus(String response) {
        boolean isSuccess = false;
        try {
            String status = getValue(response,"success");
            if(!status.isEmpty())
                isSuccess = Boolean.parseBoolean(status);
            else
                isSuccess = getValue(response,"status").equals("success");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return isSuccess;
        }
    }

    public static String getDataValueFromResponse(String response, String key){
        String toReturn ="";
        try {
            JSONObject responseBody = new JSONObject(response);
            toReturn = ((JSONObject)responseBody.get("data")).getString(key);
        }catch (JSONException e){
        }finally {
            return toReturn;
        }
    }

    public static String getDataValueInDataArrayFromResponse(String response, int dataArrayIndex, String key){
        String toReturn ="";
        try {
            JSONObject responseBody = new JSONObject(response);
            JSONArray dataArray = (JSONArray)responseBody.get("data");
            if(dataArrayIndex < 0)
                dataArrayIndex = dataArray.length() - Math.abs(dataArrayIndex);
            JSONObject dataObject = (JSONObject)dataArray.get(dataArrayIndex);
            toReturn = dataObject.getString(key);
        }catch (Exception e){
            e.getMessage();
        }finally {
            return toReturn;
        }
    }

    public static String editResponse(String response, int dataArrayIndex, String key, String value) {
        JSONObject dataObject = null;
        try {
            JSONObject responseBody = new JSONObject(response);
            JSONArray dataArray = (JSONArray) responseBody.get("data");
            if (dataArrayIndex < 0)
                dataArrayIndex = dataArray.length() - Math.abs(dataArrayIndex);
            dataObject = (JSONObject) dataArray.get(dataArrayIndex);
            dataObject.put(key, value);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            return dataObject.toString();
        }
    }

    public static String editResponseBody(String response, String key, String value) {
        JSONObject responseBody = null;
        try {
            responseBody = new JSONObject(response);
            responseBody.put(key, value);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            return responseBody.toString();
        }
    }
}
