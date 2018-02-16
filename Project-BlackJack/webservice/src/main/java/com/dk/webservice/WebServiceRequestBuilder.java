package com.dk.webservice;

import android.os.AsyncTask;

/**
 * Created by Dalibor on 14.2.2018..
 */

public class WebServiceRequestBuilder {
    private String replyMsg;
    private WebServiceInterface mWebServiceInterface;

    public WebServiceRequestBuilder(){}

    /**
     * Method that sends information user submitted to the server from where email is being sent
     * to the actual receiver.
     * @param name
     * @param email
     * @param msg
     * @return Return is a simple replay message, 'done' if succeed or 'error' if it didn't.
     */
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
