package com.example.user.ted_app_assignment_sly_v3.data.vo;

import com.google.gson.annotations.SerializedName;

public class SegmentsVO {
   @SerializedName("segment_id")
    private int segmentId;

   @SerializedName("title")
    private String segmentTitle;

    @SerializedName("imageUrl")
    private String imageUrl;

    public String getSegmentTitle() {
        return segmentTitle;
    }

    public String getImageUrl() {
       return imageUrl;
    }

    public int getSegmentId() {
        return segmentId;
    }
}
