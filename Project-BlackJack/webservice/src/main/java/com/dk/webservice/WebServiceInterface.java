package com.dk.webservice;

/**
 * Created by Dalibor on 14.2.2018..
 */

public interface WebServiceInterface {
    /**
     * Method that each webservice related class has to implement. Method has to send request
     * to webservice and wait for it to answer.
     * @return A String value that's eighter confirmation of success/faliure or an array with
     * wanted values
     */
    String sendRequestToWS();
}
