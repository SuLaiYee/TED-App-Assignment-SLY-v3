package com.example.user.ted_app_assignment_sly_v3.network.response;

import com.example.user.ted_app_assignment_sly_v3.data.vo.TedTalksVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTalksResponse {

    @SerializedName("code")
     private int code;
    @SerializedName("message")
     private String message;
    @SerializedName("apiVersion")
     private String apiVersion;
    @SerializedName("page")
    private String page;
    @SerializedName("ted_talks")
     private List<TedTalksVO> mmtalks;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TedTalksVO> getMmtalks() {
        return mmtalks;
    }

    public boolean isResponseOK(){
       return (code == 200 && mmtalks != null);
    }
}
