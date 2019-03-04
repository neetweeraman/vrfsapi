package com.sysco.vrfs_api.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syscolab.qe.core.api.request.RequestBase;

/**
 * QE-CORE CONTAINS API RELATED FUNCTIONS
 * Refer  com.sysco.vrfs_api.core.api
 */
public class RequestUtil {

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
