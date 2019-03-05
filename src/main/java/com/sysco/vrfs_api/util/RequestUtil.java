package com.sysco.vrfs_api.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.sysco.vrfs_api.common.Constant;
import com.sysco.vrfs_api.common.URIs;
import com.syscolab.qe.core.api.request.RequestBase;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.Headers;

/**
 * QE-CORE CONTAINS API RELATED FUNCTIONS
 * Refer  com.sysco.vrfs_api.core.api
 */
public class RequestUtil {

    public static final String NEW_LOAD_PATH = "/new-load-controller/";

    public static String createNewLoad(){
        return RestUtil.send(Headers.getHeader(), "", Constant.BASE_URI, Constant.BASE_PATH, URIs.getCreateNewLoadURI(), "GET");
    }

    public static <T> Response createNewLoad_(){
        RestAssured.baseURI = Constant.BASE_URI;
        RestAssured.basePath = Constant.BASE_PATH;
        String newLoadURI = NEW_LOAD_PATH + URIs.getCreateNewLoadURI();
        return RestUtil.send(Headers.getHeader(), "", newLoadURI , "GET");
    }

    public static void executeCreateNewLoad(){
        RequestSpecification reqSpec = RestUtil.getRequestSpec(Headers.getHeader(), "{\"loadNumber\":0}");
        String uri = NEW_LOAD_PATH + URIs.getCreateNewLoadURI();
        RestUtil.execute("GET",reqSpec, uri);
    }
    RequestUtil() {

    }

    public static void send() {
    }


    public static String getAsString(RequestBase requestBase){
        return getAsString(requestBase,false);
    }

    public static final String getAsString(RequestBase body, boolean ignoreNull){
        ObjectMapper mapper = new ObjectMapper();
        if(ignoreNull)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonInString ="";
        try {
            jsonInString = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            jsonInString = e.getStackTrace().toString();
        }finally {
            return jsonInString;
        }
    }

    public static String getAsArrayString(RequestBase... requestBase){
        return getAsArrayString(true,requestBase);
    }

    public static String getAsArrayString( boolean ignoreNull, RequestBase... requestBase){
        ObjectMapper mapper = new ObjectMapper();
        if(ignoreNull)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonInString ="";
        try {
            jsonInString = mapper.writeValueAsString(requestBase);
        } catch (JsonProcessingException e) {
            jsonInString = e.getStackTrace().toString();
        }finally {
            return jsonInString;
        }
    }
}
