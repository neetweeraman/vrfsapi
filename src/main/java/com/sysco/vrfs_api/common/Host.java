package com.sysco.vrfs_api.common;

import com.syscolab.qe.core.api.restassured.RestUtil;

public class Host {
    public static void selectCountry(String country){
        if(country.equalsIgnoreCase("usa")){
            RestUtil.API_HOST = Constant.VRFS_API_HOST + Constant.USA_PORT;
            RestUtil.PORT = Constant.USA_PORT;
        }
        else if(country.equalsIgnoreCase("canada")){
            RestUtil.API_HOST = Constant.VRFS_API_HOST + Constant.CANADA_PORT;
            RestUtil.PORT = Constant.CANADA_PORT;
        }
        RestUtil.BASE_PATH = Constant.VRFS_BASE_PATH;
    }
}
