/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import static com.mycompany.myapp.Config.MAIL_API_URL;

/**
 *
 * @author kaskous
 */
public class EmailUtil {
    
    
  /*String test1;
    public String getF(String test) {
        return test1;
    }*/

    public static void sendEmail(String content) {

        ConnectionRequest r = new ConnectionRequest();
        r.setUrl(MAIL_API_URL);
        r.setPost(true);
        
        

        //r.addRequestHeader("x-apikey", "bcb8c66bd822cc8a807b574c5f4a20e54da07");
        r.addRequestHeader("x-apikey", "c03ce06a5e2fe3bdb31ccb8e351c9d005d919");

        r.addArgument("to", "koussaybenhfaidh@gmail.com");
        r.addArgument("subject", "Foire");
        r.addArgument("html", "Votre Foire a ete crée");
        r.addArgument("sendername", "root");
        r.addArgument("company", "root");

        NetworkManager.getInstance().addToQueueAndWait(r);

    }
}
  
    

