package org.example;/* Import SDK classes */

import com.africastalking.AfricasTalking;
import com.africastalking.AirtimeService;
import com.africastalking.airtime.AirtimeResponse;
import io.github.cdimascio.dotenv.Dotenv;


public class TestSending
{
    public static void main(String[] args)
    {
        // Load the environment variables from the .env file
        Dotenv dotenv = Dotenv.load();



        /* Set your app credentials */
        String USERNAME = dotenv.get("AT_USERNAME");
        // Get the API key from the environment variable
        String API_KEY = dotenv.get("AT_KEY");

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the airtime service */
        AirtimeService airtime = AfricasTalking.getService(AfricasTalking.SERVICE_AIRTIME);

        /* Set the phone number, currency code and amount in the format below */
        String phoneNumber = "+254XXXXXX";
        String currencyCode = "KES";
        float amount = 5F;

        /* That’s it hit send and we’ll take care of the rest */
        try {
            AirtimeResponse response = airtime.send(phoneNumber, currencyCode, amount);
            System.out.println(response.toString());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}