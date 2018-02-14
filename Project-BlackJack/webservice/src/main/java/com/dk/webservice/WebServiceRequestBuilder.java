package com.dk.webservice;

import android.os.AsyncTask;

/**
 * Created by Dalibor on 14.2.2018..
 */

public class WebServiceRequestBuilder {
    private WebServiceInterface mWebServiceInterface;

    public WebServiceRequestBuilder(){}

    public void sendEmail(String name, String email, String msg){
        mWebServiceInterface = new EmailSender(name, email, msg);
        AsyncTask task = new AsyncTask<Object, Object, Void>() {
            @Override
            protected Void doInBackground(Object... params) {
                mWebServiceInterface.sendRequestToWS();
                return null;
            }
        };
        task.execute();
    }
}
