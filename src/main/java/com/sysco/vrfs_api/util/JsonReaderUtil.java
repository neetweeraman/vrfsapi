package com.sysco.vrfs_api.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sysco.vrfs_api.request.data.EditLoadData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReaderUtil {
    public static final String DIR = "user.dir";
    public static final String USER_DIR = System.getProperty(DIR) + "/sysco_vrfs_api";

    /*public static EditLoadData[] getEditLoadDataFromJasonArray() throws FileNotFoundException {
        JsonElement root = new JsonParser.parse(new FileReader(USER_DIR + "/src/main/resources/loadManager/editLoad.json"));

    }*/
}
