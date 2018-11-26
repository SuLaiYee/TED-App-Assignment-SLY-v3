package com.example.user.ted_app_assignment_sly_v3.event;

import com.example.user.ted_app_assignment_sly_v3.data.vo.TedTalksVO;

import java.util.List;

public class SuccessGetNewsEvent {

    private static List<TedTalksVO> mtalksList;

    public SuccessGetNewsEvent(List<TedTalksVO> talksList){
        this.mtalksList = talksList;
    }

    public static List<TedTalksVO> getMtalksList() {
        return mtalksList;
    }

}
