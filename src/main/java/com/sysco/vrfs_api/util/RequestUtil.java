package com.sysco.vrfs_api.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.sysco.vrfs_api.common.Host;
import com.sysco.vrfs_api.common.URIs;
import com.syscolab.qe.core.api.request.RequestBase;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.Headers;

/**
 * QE-CORE CONTAINS API RELATED FUNCTIONS
 * Refer  com.sysco.vrfs_api.core.api
 */
public class RequestUtil {

    private static final String NEW_LOAD_PATH = "newLoad/";
    private static final String LOAD_MGMR_PATH = "loadManager/";

    public static <T> Response createNewLoad(String country){
        Host.selectCountry(country);
        String uri = NEW_LOAD_PATH + URIs.getCreateNewLoadURI();
        return RestUtil.send(Headers.getHeader("vrfsadmin", "Sysco123"), "", uri, "GET");
    }

    public static <T> Response displayCarrierDetails(String country, String loadNumber){
        Host.selectCountry((country));
        String uri = LOAD_MGMR_PATH + URIs.getDisplayCarrierDetailsURI(loadNumber);
        return RestUtil.send(Headers.getHeader(), "", uri, "GET");
    }

    public static <T> Response displayEditCarrierDetails(String country, String loadNumber){
        Host.selectCountry(country);
        String uri = LOAD_MGMR_PATH + URIs.getDisplayEditCarrierDetailsURI(loadNumber);
        return RestUtil.send(Headers.getHeader(), "", uri, "GET");
    }

    public static <T> Response displayLoadDetails(String country, String loadNumber){
        Host.selectCountry(country);
        String uri = LOAD_MGMR_PATH + URIs.getDisplayLoadDetailsURI(loadNumber);
        return RestUtil.send(Headers.getHeader(), "", uri, "GET");
    }

    public static <T> Response displayEditLoadDetails(String country, String loadNumber){
        Host.selectCountry(country);
        String uri = LOAD_MGMR_PATH + URIs.getDisplayEditCarrierDetailsURI(loadNumber);
        return RestUtil.send(Headers.getHeader(), "", uri, "GET");
    }

    public static <T> Response displayNotes(String country, String loadNumber){
        Host.selectCountry(country);
        String uri = LOAD_MGMR_PATH + URIs.getDisplayNotesURI(loadNumber);
        return RestUtil.send(Headers.getHeader(), "", uri, "GET");
    }

    public static <T> Response editCarrier(String country, T object){
        Host.selectCountry(country);
        String uri = LOAD_MGMR_PATH + URIs.getEditCarrierURI();
        return RestUtil.send(Headers.getHeader(), JsonReaderUtil.objectToJson(object), uri, "POST");
    }

    public static <T> Response editDetail(String country, T object){
        Host.selectCountry(country);
        String uri = LOAD_MGMR_PATH + URIs.getEditDetailURI();
        return RestUtil.send(Headers.getHeader(), JsonReaderUtil.objectToJson(object), uri, "POST");
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
