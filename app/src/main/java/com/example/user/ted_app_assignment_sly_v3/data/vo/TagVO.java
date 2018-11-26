package com.example.user.ted_app_assignment_sly_v3.data.vo;

import com.google.gson.annotations.SerializedName;

public class TagVO {
    @SerializedName("tag_id")
    private int tagId;

   @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String description;

    public int getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }


}
