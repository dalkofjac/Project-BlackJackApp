package com.dk.webservice;

import android.os.AsyncTask;

/**
 * Created by Dalibor on 14.2.2018..
 */

public class WebServiceRequestBuilder {
    private String replyMsg;
    private WebServiceInterface mWebServiceInterface;

    public WebServiceRequestBuilder(){}

    public String sendEmail(String name, String email, String msg){
        mWebServiceInterface = new EmailSender(name, email, msg);
        AsyncTask task = new AsyncTask<Object, Object, Object>() {
            @Override
            protected String doInBackground(Object... params) {
                String serviceAnswer;
                serviceAnswer = mWebServiceInterface.sendRequestToWS();
                return serviceAnswer;
            }
        };
        try {
            replyMsg = task.execute().get().toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return replyMsg;
    }
}
