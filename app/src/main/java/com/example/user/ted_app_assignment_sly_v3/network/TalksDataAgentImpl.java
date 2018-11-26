package com.example.user.ted_app_assignment_sly_v3.network;

import android.os.AsyncTask;
import android.util.Log;


import com.example.user.ted_app_assignment_sly_v3.event.ApiErrorEvent;
import com.example.user.ted_app_assignment_sly_v3.event.SuccessGetNewsEvent;
import com.example.user.ted_app_assignment_sly_v3.network.response.GetTalksResponse;
import com.example.user.ted_app_assignment_sly_v3.utils.UtilsConstants;
import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TalksDataAgentImpl implements TalksDataAgent {


    private static TalksDataAgentImpl mTalksObjInstance;

    public static TalksDataAgentImpl getmTalksObjInstance(){
        if(mTalksObjInstance == null){
            mTalksObjInstance = new TalksDataAgentImpl();
        }
        return mTalksObjInstance;
    }

    @Override
    public void loadTalksList(final int page, final String accessToken) {

        new AsyncTask<Void, Void, String>() {
            URL url;
            BufferedReader reader;
            StringBuilder strBuilder;
            @Override
            protected String doInBackground(Void... voids) {

                try{
                    url = new URL(UtilsConstants.API_BASE + UtilsConstants.GET_NEWS);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("POST");
                    connection.setReadTimeout(15*1000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    List<NameValuePair> parms = new ArrayList<>();
                    parms.add(new BasicNameValuePair(UtilsConstants.PARAM_ACCESS_TOKEN,accessToken));
                    parms.add(new BasicNameValuePair(UtilsConstants.PARAM_PAGE, String.valueOf(page)));

                    OutputStream output = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,"UTF-8"));
                    writer.write(getQuery(parms));
                    writer.flush();
                    writer.close();

                    output.close();

                    connection.connect();

                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    strBuilder = new StringBuilder();

                    String line = null;

                    while((line = reader.readLine()) != null){
                        strBuilder.append(line +"\n");
                    }

                    String response = strBuilder.toString();
                    Log.d("RESPONSE", "asdf"+response);
                    return response;
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    if(reader != null){
                        try{
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s != null) {
                    Gson gson = new Gson();
                    GetTalksResponse getTalksResponse = gson.fromJson(s, GetTalksResponse.class);
                    Log.e("onPostExecute", "Size " + getTalksResponse.getMmtalks().size());
                    if(getTalksResponse.isResponseOK()){
                        SuccessGetNewsEvent event = new SuccessGetNewsEvent(getTalksResponse.getMmtalks());
                        EventBus.getDefault().post(event);
                    }else{
                        ApiErrorEvent event = new ApiErrorEvent(getTalksResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }

                }
            }
        }.execute();
    }


    private String getQuery(List<NameValuePair> parms) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for(NameValuePair pair : parms){
            if(first){
                first = false;
            }
            else {
                result.append("&");
            }

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }
        return result.toString();
    }

}
