package com.example.user.ted_app_assignment_sly_v3.data.model;


import com.example.user.ted_app_assignment_sly_v3.network.TalksDataAgent;
import com.example.user.ted_app_assignment_sly_v3.network.TalksDataAgentImpl;

public class TedTalksModel {

    private TalksDataAgent mDataAgent;
    private static TedTalksModel objInstance;
    private final String PARAM_ACCESS_VALUE = "b002c7e1a528b7cb460933fc2875e916";
    private TedTalksModel(){
        mDataAgent = TalksDataAgentImpl.getmTalksObjInstance();
    }

    public static TedTalksModel getObjInstance(){
        if(objInstance == null){
            objInstance = new TedTalksModel();
        }
        return objInstance;
    }

    //offer when require data
    public void loadDataNews(){

        // to call need--> DataAgentInterface attribute and DataAgentClass objInstance
        mDataAgent.loadTalksList(1, PARAM_ACCESS_VALUE);


    }


}
