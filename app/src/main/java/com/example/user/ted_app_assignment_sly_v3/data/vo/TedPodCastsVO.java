package com.example.user.ted_app_assignment_sly_v3.data.vo;

//import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedPodCastsVO {
    //@SerializedName("podcast_id")
    private int podCastId;

    //@SerializedName("title")
    private String podCastTitle;

    //@SerializedName( "imageUrl")
    private String imageUrl;

   // @SerializedName( "description")
    private String description;

    //@SerializedName("segments")
    private List<SegmentsVO> segments;

    public int getPodCastId() {
        return podCastId;
    }

    public String getPodCastTitle() {
        return podCastTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<SegmentsVO> getSegments() {
        return segments;
    }
}
