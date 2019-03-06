package com.sysco.vrfs_api.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sysco.vrfs_api.request.data.EditCarrierData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReaderUtil {
    public static final String DIR = "user.dir";

    public static EditCarrierData[] getEditLoadDataFromJasonArray() throws FileNotFoundException {
        JsonElement root = new JsonParser().parse(new FileReader(System.getProperty(DIR) + "/src/main/resources/loadManager/editCarrier.json"));
        Gson gson = new Gson();
        return gson.fromJson(root, EditCarrierData[].class);
    }

    public static <T> String objectToJson(T objectToJson){
        Gson gson = new Gson();
        return gson.toJson(objectToJson);
    }
}
