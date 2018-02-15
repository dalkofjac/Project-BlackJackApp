package com.dk.webservice;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Dalibor on 14.2.2018..
 */

public class EmailSender implements WebServiceInterface {
    private String name;
    private String email;
    private String msg;
    private String serviceAnswer;

    public EmailSender(String name, String email, String msg){
        this.name = name;
        this.email = email;
        this.msg = msg;
    }

    @Override
    public String sendRequestToWS(){
        serviceAnswer = "";
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("name", name)
                    .add("email", email)
                    .add("message", msg)
                    .build();

            Request request = new Request.Builder()
                    .url("http://eventtracker.000webhostapp.com/emailSenderScript.php")
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            serviceAnswer = response.body().string();

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return serviceAnswer;
    }

}
