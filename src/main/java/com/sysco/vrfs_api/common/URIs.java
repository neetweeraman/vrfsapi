package com.sysco.vrfs_api.common;

public class URIs {

    // public static final String SALESFORCE_TOKEN = "services/oauth2/token";

    public static String getCreateNewLoadURI(){
        return "createNewLoad";
    }

    public static String getDisplayCarrierDetailsURI(String loadNumber){
        return "displayCarrierDetails?loadNumber="+loadNumber;
    }

    public static String getDisplayEditCarrierDetailsURI(String loadNumber){
        return "displayEditCarrierDetails?loadNumber="+loadNumber;
    }

    public static String getDisplayLoadDetailsURI(String loadNumber){
        return "displayLoadDetail?loadNumber="+loadNumber;
    }

    public static String getDisplayEditLoadDetailsURI(String loadNumber){
        return "displayEditLoadDetail?loadNumber="+loadNumber;
    }

    public static String getDisplayNotesURI(String loadNumber){
        return "displayNotes?loadNumber="+loadNumber;
    }

    public static String getEditCarrierURI(){
        return "editCarrier";
    }

    public static String getEditDetailURI(){
        return "editDetail";
    }

    URIs() {

    }
}
